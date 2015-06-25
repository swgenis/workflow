package za.ac.nwu.workflow.backbone.producers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import za.ac.nwu.workflow.PGSMSService;
import coza.opencollab.backbone.ConfigurationProperty;
import coza.opencollab.backbone.ServiceFactory;
import coza.opencollab.backbone.person.service.PersonService;

@ApplicationScoped
public class PGSMSServiceFactory extends ServiceFactory {

    @Inject
    @ConfigurationProperty(value = "backbone.mode")
    private String mode;
    
    @Inject
    @PGSMSService 
    PersonService workflowPersonService;
    
    @PostConstruct
    public void init() {
    }

    @Produces
    @Specializes
    public PersonService producePersonService() {
	if (mode.equals("dev")) {
	    return super.producePersonService();
	} else {
	    //TODO: Investigate Instance<PersonService> with instance.select().
	    return workflowPersonService;
	}

    }

}
