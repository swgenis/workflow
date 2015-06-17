package coza.opencollab.backbone.configuration.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import coza.opencollab.backbone.configuration.Deployment;
import coza.opencollab.backbone.configuration.ProcessCategory;
import coza.opencollab.backbone.configuration.SubProcess;
import coza.opencollab.backbone.configuration.service.ConfigurationRestService;
import coza.opencollab.backbone.configuration.service.ConfigurationService;
import coza.opencollab.backbone.type.Type;
import coza.opencollab.backbone.type.service.TypeService;

@Path("/config")
public class ConfigurationRestServiceImpl implements ConfigurationRestService {

    private static final Logger logger = LoggerFactory.getLogger(ConfigurationRestServiceImpl.class);

    @Inject
    private ConfigurationService configurationService;
    
    @Inject
    private TypeService typeService;

    @GET
    @Path("/processes")
    @Produces({ "application/json" })
    public List<ProcessCategory> getProcesses() {
	List<ProcessCategory> processes = new ArrayList<ProcessCategory>();
	List<String> categories = configurationService.getDeploymentCategories();
	for (String category : categories) {
	    
	    logger.debug("Get Deployments for category " + category);
	    Type type = typeService.getTypeByKey(category);
	    ProcessCategory process = new ProcessCategory(type.getDescription());
	    
	    List<Deployment> deployments = configurationService.getDeploymentsByCategory(category);
	    for(Deployment deployment : deployments){
		process.getSubProcesses().add(new SubProcess(deployment.getName(), deployment.getLaunchUrl()));
	    }
	    processes.add(process);
	}
	return processes;
    }

}
