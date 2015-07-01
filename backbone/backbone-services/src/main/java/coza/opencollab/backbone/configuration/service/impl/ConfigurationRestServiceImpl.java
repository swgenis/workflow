package coza.opencollab.backbone.configuration.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.SecurityContext;

import org.apache.commons.io.IOUtils;
import org.kzac.core.person.dto.PersonInfo;
import org.kzac.core.person.service.PersonService;
import org.kzac.exceptions.DoesNotExistException;
import org.kzac.exceptions.InvalidParameterException;
import org.kzac.exceptions.MissingParameterException;
import org.kzac.exceptions.OperationFailedException;
import org.kzac.exceptions.PermissionDeniedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import coza.opencollab.backbone.AbstractBackboneRestService;
import coza.opencollab.backbone.authorization.User;
import coza.opencollab.backbone.authorization.service.AuthorizationService;
import coza.opencollab.backbone.configuration.Application;
import coza.opencollab.backbone.configuration.ApplicationCategory;
import coza.opencollab.backbone.configuration.ConfigProperties;
import coza.opencollab.backbone.configuration.SubProcess;
import coza.opencollab.backbone.configuration.service.ConfigurationRestService;
import coza.opencollab.backbone.configuration.service.ConfigurationService;
import coza.opencollab.backbone.configuration.service.ConfigurationServiceConstants;
import coza.opencollab.backbone.type.Type;
import coza.opencollab.backbone.type.service.TypeService;

@Path("/config")
public class ConfigurationRestServiceImpl extends AbstractBackboneRestService implements ConfigurationRestService {

    private static final Logger logger = LoggerFactory.getLogger(ConfigurationRestServiceImpl.class);

    @Inject
    private ConfigurationService configurationService;

    @Inject
    private TypeService typeService;

    @Inject
    private AuthorizationService authorizationService;

    @Inject
    private PersonService personService;

    @Override
    public ConfigProperties getConfiguration() {
	ConfigProperties properties = new ConfigProperties();
	properties.setTitle(configurationService.getPropertyForKey(ConfigurationServiceConstants.TITLE_PROPERTY));
	return properties;
    }

    @Override
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

    @Override
    public PersonInfo getPrincipal(SecurityContext context) throws DoesNotExistException,
	    InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
	String userId = context.getUserPrincipal().getName();
	User user = authorizationService.getUserById(userId);
	return personService.getPerson(user.getPersonId(), this.getContextInfo(context));
    }

    @Override
    public List<ApplicationCategory> getApplications() {
	List<ApplicationCategory> applicationCategories = new ArrayList<ApplicationCategory>();
	List<String> categories = configurationService.getApplicationCategories();
	for (String category : categories) {

	    logger.info("Get Applications for category " + category);
	    Type type = typeService.getTypeByKey(category);
	    ApplicationCategory applicationCategory = new ApplicationCategory(type.getDescription());

	    List<Application> applications = configurationService.getApplicationsByCategory(category);
	    for (Application application : applications) {
		applicationCategory.getSubProcesses().add(new SubProcess(application.getName(), application.getUrl()));
	    }
	    applicationCategories.add(applicationCategory);
	}
	return applicationCategories;
    }

}
