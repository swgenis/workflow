package za.ac.nwu.workflow.backbone.person;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import za.ac.nwu.workflow.backbone.person.service.Person;
import za.ac.nwu.workflow.backbone.person.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/search")
	public @ResponseBody List<Person> search(@RequestParam(value="name", required=false) String name,
    							@RequestParam(value="surname", required=false) String surname) throws Exception {
		logger.debug("Searching for a person " + name + " " + surname);
		
		// Delegate to service to do the actual adding
		List<Person> searchResult = personService.searchPerson(name, surname);
		return searchResult;
	}
	
	@RequestMapping(value="/lookup")
	public @ResponseBody Person getPerson(@RequestParam String personLookupId) {
		return personService.getPersonById(personLookupId);
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public Person greetByRequest(@RequestParam String name) {
    	return new Person();
    }
	
}
