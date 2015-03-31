package za.ac.nwu.workflow.backbone.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import za.ac.nwu.workflow.backbone.person.PersonLookupForm;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home! The client locale is {}.");

		model.addAttribute("message", "welcome to nwu backbone!");
		return "home";
	}

	@ModelAttribute("person-lookup-form")
	public PersonLookupForm createFormBean() {
		logger.info("Create new person inspector form");
		return new PersonLookupForm();
	}

}
