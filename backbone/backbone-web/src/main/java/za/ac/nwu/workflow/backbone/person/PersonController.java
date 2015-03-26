package za.ac.nwu.workflow.backbone.person;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import za.ac.nwu.workflow.backbone.person.service.Person;
import za.ac.nwu.workflow.backbone.person.service.PersonService;
import za.ac.nwu.workflow.backbone.utils.AjaxUtils;

@Controller
@RequestMapping("/person")
@SessionAttributes("personForm")
public class PersonController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService personService;

	// Invoked on every request

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		logger.info("Set ajaxRequest attribute");
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	// Invoked initially to create the "form" attribute
	// Once created the "form" attribute comes from the HTTP session (see @SessionAttributes)

	@ModelAttribute("personForm")
	public PersonForm createFormBean() {
		logger.info("Create new person form");
		return new PersonForm();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void createPerson() {
	}
	
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
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody String editPerson(@PathVariable String id, Model model) {
		Person person = personService.getPersonById(id);
		model.addAttribute("personForm", new PersonForm(person));
		return null;
	}

	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@Valid PersonForm person, BindingResult result, 
								@ModelAttribute("ajaxRequest") boolean ajaxRequest, 
								Model model, RedirectAttributes redirectAttrs) {
		logger.info("Insert a new person.");
		if (result.hasErrors()) {
			return null;
		}
		
		try {
			personService.insertPerson(person.toPerson());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Typically you would save to a db and clear the "form" attribute from the session 
		//SessionStatus.setCompleted().
		String message = "Person was successfully created.";
		// Success response handling
		if (ajaxRequest) {
			// prepare model for rendering success message in this request
			model.addAttribute("message", message);
			return person.toString();
		} else {
			// store a success message for rendering on the next request after redirect
			// redirect back to the form to render the success message along with newly bound values
			redirectAttrs.addFlashAttribute("message", message);
			return "redirect:/form";			
		}
	}
	
}
