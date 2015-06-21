package za.ac.nwu.workflow.backbone.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import za.ac.nwu.workflow.ShawaService;
import coza.opencollab.backbone.ConfigurationProperty;
import coza.opencollab.backbone.person.service.PersonService;
import coza.opencollab.backbone.service.ServiceFactory;

@ApplicationScoped
public class ShawaBackboneServiceFactory extends ServiceFactory {

    @Inject
    @ConfigurationProperty(value = "backbone.mode")
    private String mode;
    
    @Inject
    @ShawaService 
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
