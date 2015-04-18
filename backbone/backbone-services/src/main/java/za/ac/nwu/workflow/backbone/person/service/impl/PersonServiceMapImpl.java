package za.ac.nwu.workflow.backbone.person.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Default;

import za.ac.nwu.workflow.backbone.person.service.Person;
import za.ac.nwu.workflow.backbone.person.service.PersonService;

@Default
public class PersonServiceMapImpl implements PersonService {
	
	private Map<String, Person> persons = new HashMap<String, Person>();

	@Override
	public Person getPersonById(String key) {
		if(persons.containsKey(key)){
			return persons.get(key);
		}
		return null;
	}

	@Override
	public void insertPerson(Person person) throws Exception {
		if(persons.containsKey(person.getId())){
			throw new Exception("Person already exists for id " + person.getId());
		}
		persons.put(person.getId(), person);	
	}

	@Override
	public void updatePerson(Person person) throws Exception {
		if(!persons.containsKey(person.getId())){
			throw new Exception("Person does not exist for id " + person.getId());
		}
		persons.put(person.getId(), person);

	}

	@Override
	public void deletePersonById(String id) throws Exception {
		if(!persons.containsKey(id)){
			throw new Exception("Person does not exist for id " + id);
		}
		persons.remove(id);	
	}
	
	@Override
	public List<Person> searchPerson(String name, String surname) throws Exception {
		List<Person> searchResults = new ArrayList<Person>();
		for (Person person : persons.values()) {
			if(name!=null){
				if (person.getName().equalsIgnoreCase(name)) {
					searchResults.add(person);
				}
			}
			if(surname!=null){
				if (person.getSurname().equalsIgnoreCase(surname)) {
					searchResults.add(person);
				}
			}
		}
		return searchResults;
	}

	public Map<String, Person> getPersons() {
		return persons;
	}

	public void setPersons(Map<String, Person> persons) {
		this.persons = persons;
	}

}
