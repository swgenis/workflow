package za.ac.nwu.workflow.backbone.producers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import org.kzac.core.person.service.PersonService;

import za.ac.nwu.workflow.ShawaService;
import coza.opencollab.backbone.ConfigurationProperty;
import coza.opencollab.backbone.identity.IdentityServiceFactory;

@ApplicationScoped
public class ShawaIdentityServiceFactory extends IdentityServiceFactory {

    @Inject
    @ConfigurationProperty(value = "backbone.mode")
    private String mode;
    
    @Inject
    @ShawaService 
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
