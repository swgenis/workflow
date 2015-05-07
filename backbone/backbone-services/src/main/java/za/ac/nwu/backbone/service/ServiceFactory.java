package za.ac.nwu.backbone.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import za.ac.nwu.backbone.qualifiers.MapService;
import za.ac.nwu.workflow.backbone.authorization.service.AuthorizationService;
import za.ac.nwu.workflow.backbone.organization.service.OrganizationService;
import za.ac.nwu.workflow.backbone.person.service.PersonService;
import za.ac.nwu.workflow.backbone.type.service.TypeService;

@ApplicationScoped
public class ServiceFactory {
    
    @Inject
    @MapService 
    AuthorizationService authorizationService;
    
    @Inject
    @MapService 
    OrganizationService organizationService;
    
    @Inject
    @MapService 
    PersonService personService;
    
    @Inject
    @MapService 
    TypeService typeService;
    
    @Produces
    public AuthorizationService produceAuthorizationService() {
	return authorizationService;
    }
    
    @Produces
    public OrganizationService produceOrganizationService() {
	return organizationService;
    }
    
    @Produces
    public PersonService producePersonService() {
	return personService;
    }
    
    @Produces
    public TypeService produceTypeService() {
	return typeService;
    }

}
