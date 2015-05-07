package za.ac.nwu.workflow.backbone.person.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.ac.nwu.workflow.backbone.person.Person;
import za.ac.nwu.workflow.backbone.person.service.PersonRestService;
import za.ac.nwu.workflow.backbone.person.service.PersonService;

/**
 * 
 * @author SW Genis
 *
 */
@Path("/person")
public class PersonRestServiceImpl implements PersonRestService {

    private static final Logger logger = LoggerFactory.getLogger(PersonRestServiceImpl.class);

    @Inject
    private PersonService personService;

    @GET
    @Path("/search")
    @Produces({ "application/json" })
    public List<Person> search(@QueryParam("name") String name, @QueryParam("surname") String surname) throws Exception {
	logger.debug("Searching for a person " + name + " " + surname);

	// Delegate to service to do the actual searching.
	List<Person> searchResult = personService.searchPerson(name, surname);
	return searchResult;
    }

    @GET
    @Path("/lookup")
    @Produces({ "application/json" })
    public Person getPerson(@QueryParam("personLookupId") String personLookupId) {
	return personService.getPersonById(personLookupId);
    }

}
