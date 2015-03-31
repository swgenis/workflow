package za.ac.nwu.workflow.backbone.person;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import za.ac.nwu.workflow.backbone.person.service.Person;
import za.ac.nwu.workflow.backbone.person.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody List<Person> search(@RequestParam(value="name", required=true) String name,
    							@RequestParam(value="surname", required=true) String surname,
    							Model model) throws Exception {
		logger.debug("Searching for a person " + name + " " + surname);
		
		// Delegate to service to do the actual adding
		List<Person> searchResult = personService.searchPerson(name, surname);
		model.addAttribute("searchResult", searchResult);
		return searchResult;
	}
	
	@RequestMapping(value="/lookup", method = RequestMethod.POST)
	public @ResponseBody Person getPerson(PersonLookupForm personLookupForm, BindingResult result,
			Model model, RedirectAttributes redirectAttrs) {
		return personService.getPersonById(personLookupForm.getId());
	}
	
}
