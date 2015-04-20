package za.ac.nwu.workflow.backbone.person.service;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.ac.nwu.workflow.backbone.person.service.impl.PersonServiceMapImpl;

@RunWith(Arquillian.class)
public class PersonServiceTest {
	
	@Inject
	private PersonService personService;
	
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClass(PersonServiceMapImpl.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
	
	@Test
	public void testGetLeaveApplicationById(){
		Person person = personService.getPersonById("bob");
		Assert.assertNotNull(person);
	}
	
	@Test
	public void testInsertPerson() throws Exception{
		Person person = new Person();
		person.setId("test");
		person.setName("Test");
		personService.insertPerson(person);
		
		Person retrievedPerson = personService.getPersonById("test");
		Assert.assertNotNull(retrievedPerson);
		Assert.assertEquals("Test", retrievedPerson.getName());
	}
	
	@Test
	public void testUpdatePerson(){
		
	}
	
	@Test
	public void testDeletePerson(){
		
	}

	@Test
	public void testSearchPerson(){
		
	}
}
