package coza.opencollab.backbone.person.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kzac.common.dto.ContextInfo;
import org.kzac.common.search.Criteria;
import org.kzac.common.search.RelationalExpression;
import org.kzac.core.person.dto.PersonInfo;
import org.kzac.core.person.service.PersonService;
import org.kzac.exceptions.DoesNotExistException;
import org.kzac.exceptions.InvalidParameterException;
import org.kzac.exceptions.MissingParameterException;
import org.kzac.exceptions.OperationFailedException;
import org.kzac.exceptions.PermissionDeniedException;

import coza.opencollab.backbone.authorization.service.impl.AuthorizationServiceMapImpl;
import coza.opencollab.backbone.identity.IdentityServiceFactory;
import coza.opencollab.backbone.person.service.impl.PersonServiceConstants;
import coza.opencollab.backbone.person.service.impl.PersonServiceMapImpl;
import coza.opencollab.backbone.qualifiers.MapService;

@RunWith(Arquillian.class)
public class PersonServiceTest {

    @Inject
    @MapService
    private PersonService personService;

    @Deployment
    public static JavaArchive createDeployment() {
	return ShrinkWrap.create(JavaArchive.class).addClass(PersonServiceMapImpl.class)
		.addClass(AuthorizationServiceMapImpl.class).addClass(IdentityServiceFactory.class)
		.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    public ContextInfo contextInfo = null;
    public static String principalId = "123";

    @Before
    public void setUp() {
	principalId = "123";
	contextInfo = new ContextInfo();
	contextInfo.setPrincipalId(principalId);

	// Load Mock data.
	IdentityServiceFactory.createPersonDataLoader(personService).loadData("mock-person.json");
    }

    @Test
    public void testGetLeaveApplicationById() throws DoesNotExistException, InvalidParameterException,
	    MissingParameterException, OperationFailedException, PermissionDeniedException {
	PersonInfo person = personService.getPerson(PersonMockDataLoader.PERSON1_ID, contextInfo);
	assertNotNull(person);
    }

    @Test
    public void testInsertPerson() throws Exception {
	PersonInfo person = new PersonInfo();
	person.setId("test");
	person.setName("Test");
	person.setTypeKey(PersonServiceConstants.PERSON_TYPE_KEY);
	personService.createPerson(PersonServiceConstants.PERSON_TYPE_KEY, person, contextInfo);

	PersonInfo retrievedPerson = personService.getPerson("test", contextInfo);
	assertNotNull(retrievedPerson);
	assertEquals("Test", retrievedPerson.getName());
    }

    @Test
    public void testUpdatePerson() throws Exception {
	PersonInfo person = personService.getPerson(PersonMockDataLoader.PERSON1_ID, contextInfo);
	person.setName("name01");
	personService.updatePerson(person.getId(), person, contextInfo);

	PersonInfo updatedPerson = personService.getPerson(PersonMockDataLoader.PERSON1_ID, contextInfo);
	assertEquals("name01", updatedPerson.getName());
    }

    @Test
    public void testDeletePerson() throws Exception {
	personService.deletePerson(PersonMockDataLoader.PERSON3_ID, contextInfo);
	try {
	    personService.getPerson(PersonMockDataLoader.PERSON3_ID, contextInfo);
	    fail("Did not receive DoesNotExistException when attempting to get already-deleted entity");
	} catch (DoesNotExistException dnee) {
	    // expected
	}
    }

    @Test
    public void testSearchPerson() throws Exception {

	// Delegate to service to do the actual searching.
	Criteria criteria = new Criteria();
	criteria.setWhere(new RelationalExpression("id", RelationalExpression.Operator.EQUALS, "bob"));
	List<PersonInfo> persons = personService.searchForPersons(criteria, contextInfo);
	assertNotNull(persons);
	assertEquals(1, persons.size());
	assertEquals("Bob, Bobson", persons.get(0).getName());
    }
}
