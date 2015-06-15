package coza.opencollab.backbone.person.service.impl;

import coza.opencollab.backbone.person.Person;
import coza.opencollab.backbone.person.service.PersonService;

/**
 * 
 * @author SW Genis
 * 
 */
public class PersonMockDataLoader {

    public static final String PERSON1_ID = "bob";
    public static final String PERSON1_NAME = "Bob";
    public static final String PERSON1_SURNAME = "Bobson";
    public static final String PERSON1_EMAIL = "bob@bobson.com";
    public static final String PERSON2_ID = "john";
    public static final String PERSON2_NAME = "John";
    public static final String PERSON2_SURNAME = "Johnson";
    public static final String PERSON3_ID = "carol";
    public static final String PERSON3_NAME = "Carol";
    public static final String PERSON3_SURNAME = "Carolson";
    public static final String PERSON4_ID = "jiri";
    public static final String PERSON4_NAME = "Jiri";
    public static final String PERSON4_SURNAME = "McJiri";
    public static final String PERSON5_ID = "mary";
    public static final String PERSON5_NAME = "Mary";
    public static final String PERSON5_SURNAME = "McMary";

    private PersonService personService;

    public PersonMockDataLoader(PersonService personService) {
	this.personService = personService;
    }

    public void loadData() throws Exception {
	addPerson(PERSON1_ID, PERSON1_NAME, PERSON1_SURNAME);
	addPerson(PERSON2_ID, PERSON2_NAME, PERSON2_SURNAME);
	addPerson(PERSON3_ID, PERSON3_NAME, PERSON3_SURNAME);
	addPerson(PERSON4_ID, PERSON4_NAME, PERSON4_SURNAME);
	addPerson(PERSON5_ID, PERSON5_NAME, PERSON5_SURNAME);
    }

    private void addPerson(String id, String name, String surname) throws Exception {
	Person person = new Person();
	person.setId(id);
	person.setName(name);
	person.setSurname(surname);
	personService.insertPerson(person);
    }

}
