package coza.opencollab.backbone.person.service;

import java.util.List;

import coza.opencollab.backbone.person.Person;

/**
 * CRUD Service interface used to persist person related information.
 * 
 * @author SW Genis
 * 
 */
public interface PersonService {

    /**
     * Retrieve a person for the given personId.
     * 
     * @param id
     * @return
     */
    public Person getPersonById(String id);

    /**
     * 
     * @param person
     * @throws Exception
     */
    public void insertPerson(Person person) throws Exception;

    /**
     * 
     * @param person
     * @throws Exception
     */
    public void updatePerson(Person person) throws Exception;

    /**
     * 
     * @param key
     * @throws Exception
     */
    public void deletePersonById(String key) throws Exception;

    /**
     * 
     * @param name
     * @param surname
     * @return
     * @throws Exception
     */
    public List<Person> searchPerson(String name, String surname) throws Exception;

}
