package za.ac.nwu.workflow.backbone.person;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.ac.nwu.workflow.backbone.person.service.Person;
import za.ac.nwu.workflow.backbone.person.service.PersonService;

@Stateless
@Path("/person")
public class PersonRestServiceImpl {

	private static final Logger logger = LoggerFactory
			.getLogger(PersonRestServiceImpl.class);

	@Inject
	private PersonService personService;

	@GET
	@Path("/search")
	@Produces({ "application/json" })
	public List<Person> search(@QueryParam("name") String name,
			@PathParam("surname") String surname) throws Exception {
		logger.debug("Searching for a person " + name + " " + surname);

		// Delegate to service to do the actual adding
		List<Person> searchResult = personService.searchPerson(name, surname);
		return searchResult;
	}

	@GET
	@Path("/lookup")
	@Produces({ "application/json" })
	public Person getPerson(@QueryParam("personLookupId") String personLookupId) {
		return personService.getPersonById(personLookupId);
	}

	@GET
	@Path("/hello")
	@Produces({ "application/json" })
	public Person greetByRequest(@QueryParam("name") String name) {
		return new Person();
	}

}
