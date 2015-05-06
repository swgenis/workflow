package za.ac.nwu.workflow.backbone.producers;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import za.ac.nwu.workflow.backbone.person.service.PersonService;
import za.ac.nwu.workflow.backbone.person.service.impl.PersonServiceKimImpl;
import za.ac.nwu.workflow.backbone.person.service.impl.PersonServiceMapImpl;

public class PersonServiceProducer {

    @Inject
    @ConfigurationProperty(value = "devmode")
    private boolean devmode;
    @Inject
    private PersonServiceMapImpl personServiceMapImpl;
    @Inject
    private PersonServiceKimImpl personServiceKimImpl;

    @Produces
    @Chosen
    private PersonService producetPersonService() {
	if (devmode) {
	    return personServiceMapImpl;
	} else {
	    return personServiceKimImpl;
	}

    }

}
