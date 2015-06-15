package za.ac.nwu.workflow.backbone.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import coza.opencollab.backbone.person.service.PersonService;
import coza.opencollab.backbone.service.ServiceFactory;
import za.ac.nwu.workflow.NWUWorkflowService;

@ApplicationScoped
public class NWUWorkflowServiceFactory extends ServiceFactory {

    @Inject
    @ConfigurationProperty(value = "backbone.mode")
    private String mode;
    
    @Inject
    @NWUWorkflowService 
    PersonService workflowPersonService;

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
