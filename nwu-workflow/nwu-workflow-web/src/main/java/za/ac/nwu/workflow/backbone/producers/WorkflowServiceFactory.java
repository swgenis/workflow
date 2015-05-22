package za.ac.nwu.workflow.backbone.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import za.ac.nwu.backbone.service.ServiceFactory;
import za.ac.nwu.workflow.WorkflowService;
import za.ac.nwu.workflow.backbone.person.service.PersonService;

@ApplicationScoped
public class WorkflowServiceFactory extends ServiceFactory {

    @Inject
    @ConfigurationProperty(value = "devmode")
    private boolean devmode;
    
    @Inject
    @WorkflowService 
    PersonService workflowPersonService;

    @Produces
    @Specializes
    public PersonService producePersonService() {
	if (devmode) {
	    return super.producePersonService();
	} else {
	    //TODO: Investigate Instance<PersonService> with instance.select().
	    return workflowPersonService;
	}

    }

}
