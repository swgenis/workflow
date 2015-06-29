package coza.opencollab.backbone.configuration.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.SecurityContext;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import coza.opencollab.backbone.authorization.User;
import coza.opencollab.backbone.authorization.service.AuthorizationService;
import coza.opencollab.backbone.configuration.Application;
import coza.opencollab.backbone.configuration.ApplicationCategory;
import coza.opencollab.backbone.configuration.ConfigProperties;
import coza.opencollab.backbone.configuration.SubProcess;
import coza.opencollab.backbone.configuration.service.ConfigurationRestService;
import coza.opencollab.backbone.configuration.service.ConfigurationService;
import coza.opencollab.backbone.configuration.service.ConfigurationServiceConstants;
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
    @Path("/properties")
    @Produces({ "application/json" })
    public ConfigProperties getConfiguration() {
	ConfigProperties properties = new ConfigProperties();
	properties.setTitle(configurationService.getPropertyForKey(ConfigurationServiceConstants.TITLE_PROPERTY));
	return properties;
    }

    @GET
    @Path("/brand")
    @Produces("image/*")
    public Response getBrandImage() {
	String imageFile = configurationService.getPropertyForKey(ConfigurationServiceConstants.BRAND_IMAGE_PROPERTY);

	// Get file from resources folder
	InputStream is = ConfigurationRestServiceImpl.class.getResourceAsStream(imageFile);
	byte[] bytes;
	try {
	    bytes = IOUtils.toByteArray(is);
	    ResponseBuilder response = Response.ok((Object) bytes);
	    return response.build();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return null;
    }

    @GET
    @Path("/principal")
    @Produces({ "application/json" })
    public Person getPrincipal(@Context SecurityContext context) {
	String userId = context.getUserPrincipal().getName();
	User user = authorizationService.getUserById(userId);
	return personService.getPersonById(user.getPersonId());
    }

    @GET
    @Path("/applications")
    @Produces({ "application/json" })
    public List<ApplicationCategory> getProcesses() {
	List<ApplicationCategory> processes = new ArrayList<ApplicationCategory>();
	List<String> categories = configurationService.getApplicationCategories();
	for (String category : categories) {

	    logger.info("Get Applications for category " + category);
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
