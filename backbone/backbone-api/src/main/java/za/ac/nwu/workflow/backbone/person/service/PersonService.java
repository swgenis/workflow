package za.ac.nwu.workflow.backbone.person.service;

import java.util.List;

public interface PersonService {
	
	public Person getPersonById(String id);
	
	public void insertPerson(Person person) throws Exception;
	
	public void updatePerson(Person person) throws Exception;
	
	public void deletePersonById(String key) throws Exception;
	
	public List<Person> searchPerson(String name, String surname) throws Exception;

}
