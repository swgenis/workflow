package za.ac.nwu.workflow.backbone.person.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.ac.nwu.workflow.backbone.person.Person;
import za.ac.nwu.workflow.backbone.person.service.impl.PersonMockDataLoader;
import za.ac.nwu.workflow.backbone.person.service.impl.PersonServiceMapImpl;

@RunWith(Arquillian.class)
public class PersonServiceTest {

    @Inject
    private PersonService personService;

    @Deployment
    public static JavaArchive createDeployment() {
	return ShrinkWrap.create(JavaArchive.class).addClass(PersonServiceMapImpl.class)
		.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testGetLeaveApplicationById() {
	Person person = personService.getPersonById(PersonMockDataLoader.PERSON1_ID);
	assertNotNull(person);
    }

    @Test
    public void testInsertPerson() throws Exception {
	Person person = new Person();
	person.setId("test");
	person.setName("Test");
	personService.insertPerson(person);

	Person retrievedPerson = personService.getPersonById("test");
	assertNotNull(retrievedPerson);
	assertEquals("Test", retrievedPerson.getName());
    }

    @Test
    public void testUpdatePerson() throws Exception {
	Person person = personService.getPersonById(PersonMockDataLoader.PERSON1_ID);
	person.setEmail(PersonMockDataLoader.PERSON1_EMAIL);
	personService.updatePerson(person);

	Person updatedPerson = personService.getPersonById(PersonMockDataLoader.PERSON1_ID);
	assertEquals(PersonMockDataLoader.PERSON1_EMAIL, updatedPerson.getEmail());
    }

    @Test
    public void testDeletePerson() throws Exception {
	personService.deletePersonById(PersonMockDataLoader.PERSON3_ID);
	Person person = personService.getPersonById(PersonMockDataLoader.PERSON3_ID);
	assertEquals(null, person);
    }

    @Test
    public void testSearchPerson() throws Exception {
	List<Person> persons = personService.searchPerson(PersonMockDataLoader.PERSON1_NAME, null);
	assertNotNull(persons);
	assertEquals(1, persons.size());
    }
}
