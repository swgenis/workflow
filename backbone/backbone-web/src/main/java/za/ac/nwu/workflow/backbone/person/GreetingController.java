package za.ac.nwu.workflow.backbone.person;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String greetByRequest(@RequestParam String name) {
    	String result="Hello "+name; 
    	return result;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String greetByPath(@PathVariable String name) {
    	String result="Hello "+name; 
    	return result;
    }
    
}
