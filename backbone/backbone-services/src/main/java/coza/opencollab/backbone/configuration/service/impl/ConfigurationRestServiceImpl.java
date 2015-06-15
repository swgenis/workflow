package coza.opencollab.backbone.configuration.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import coza.opencollab.backbone.configuration.Deployment;
import coza.opencollab.backbone.configuration.service.ConfigurationRestService;
import coza.opencollab.backbone.configuration.service.ConfigurationService;

@Path("/config")
public class ConfigurationRestServiceImpl implements ConfigurationRestService {
    
    private static final Logger logger = LoggerFactory.getLogger(ConfigurationRestServiceImpl.class);
    
    @Inject
    ConfigurationService configurationService;
    
    @GET
    @Path("/categories")
    @Produces({ "application/json" })
    public List<String> getCategories() throws Exception {
	logger.debug("Get Categories");
	return configurationService.getDeploymentCategories();
    }

    @GET
    @Path("/categories/{category}/deployments")
    @Produces({ "application/json" })
    public List<Deployment> getDeploymentsForCategory(@PathParam("category") String category) {
	logger.debug("Get Deployments for category " + category);
	return configurationService.getDeploymentsByCategory(category);
    }

}
