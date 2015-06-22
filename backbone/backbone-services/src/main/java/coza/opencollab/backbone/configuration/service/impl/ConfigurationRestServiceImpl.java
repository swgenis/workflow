package coza.opencollab.backbone.configuration.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import coza.opencollab.backbone.authorization.User;
import coza.opencollab.backbone.authorization.service.AuthorizationService;
import coza.opencollab.backbone.configuration.Application;
import coza.opencollab.backbone.configuration.ApplicationCategory;
import coza.opencollab.backbone.configuration.SubProcess;
import coza.opencollab.backbone.configuration.service.ConfigurationRestService;
import coza.opencollab.backbone.configuration.service.ConfigurationService;
import coza.opencollab.backbone.person.Person;
import coza.opencollab.backbone.person.service.PersonService;
import coza.opencollab.backbone.type.Type;
import coza.opencollab.backbone.type.service.TypeService;

@Path("/config")
public class ConfigurationRestServiceImpl implements ConfigurationRestService {

    private static final Logger logger = LoggerFactory.getLogger(ConfigurationRestServiceImpl.class);

    @Inject
    private ConfigurationService configurationService;

    @Inject
    private TypeService typeService;

    @Inject
    private AuthorizationService authorizationService;

    @Inject
    private PersonService personService;

    @GET
    @Path("/principal")
    @Produces({ "application/json" })
    public Person getPrincipal(@Context SecurityContext context) {
	String userId = context.getUserPrincipal().getName();
	User user = authorizationService.getUserById(userId);
	return personService.getPersonById(user.getPersonId());
    }

    @GET
    @Path("/processes")
    @Produces({ "application/json" })
    public List<ApplicationCategory> getProcesses() {
	List<ApplicationCategory> processes = new ArrayList<ApplicationCategory>();
	List<String> categories = configurationService.getApplicationCategories();
	for (String category : categories) {

	    logger.debug("Get Applications for category " + category);
	    Type type = typeService.getTypeByKey(category);
	    ApplicationCategory process = new ApplicationCategory(type.getDescription());

	    List<Application> applications = configurationService.getApplicationsByCategory(category);
	    for (Application application : applications) {
		process.getSubProcesses().add(new SubProcess(application.getName(), application.getUrl()));
	    }
	    processes.add(process);
	}
	return processes;
    }

}
