package za.ac.nwu.workflow.backbone.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import za.ac.nwu.workflow.backbone.person.service.Instructor;
import za.ac.nwu.workflow.backbone.person.service.Person;
import za.ac.nwu.workflow.backbone.person.service.PersonService;

public class PersonServiceMapImpl implements PersonService {
	
	private Map<String, Person> persons = new HashMap<String, Person>();
	private Map<String, Instructor> instructors = new HashMap<String, Instructor>();

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

	@Override
	public Instructor getInstructorById(String id) {
		if(instructors.containsKey(id)){
			return instructors.get(id);
		}
		return null;
	}

	@Override
	public List<Instructor> getInstructorsByPersonId(String personId) throws Exception {
		if(personId==null){
			throw new Exception("PersonId is null");
		}
		
		List<Instructor> returnInstructors = new ArrayList<Instructor>();
		for (Instructor instructor : instructors.values()) {
		    if(personId.equals(instructor.getPerson().getId())){
		    	returnInstructors.add(instructor);
		    }
		}
		return returnInstructors;
	}

	@Override
	public void insertInstructor(Instructor instructor) throws Exception {
		if(instructors.containsKey(instructor.getId())){
			throw new Exception("Instructor already exists for key " + instructor.getId());
		}
		instructors.put(instructor.getId(), instructor);	
	}

	@Override
	public void updateInstructor(Instructor instructor) throws Exception {
		if(!instructors.containsKey(instructor.getId())){
			throw new Exception("Instructor does not exist for key " + instructor.getId());
		}
		instructors.put(instructor.getId(), instructor);
	}

	@Override
	public void deleteInstructorById(String id) throws Exception {
		if(!instructors.containsKey(id)){
			throw new Exception("Instructor does not exist for id " + id);
		}
		instructors.remove(id);	

	}

	public Map<String, Person> getPersons() {
		return persons;
	}

	public void setPersons(Map<String, Person> persons) {
		this.persons = persons;
	}

	public Map<String, Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(Map<String, Instructor> instructors) {
		this.instructors = instructors;
	}

}
