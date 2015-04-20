package za.ac.nwu.workflow.backbone.person.service;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class PersonServiceTest {
	
	@Inject
	private PersonService personService;
	
	@Test
	public void testGetLeaveApplicationById(){
		Person person = personService.getPersonById("bob");
	}
	
	@Test
	public void testInsertPerson(){
		
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
