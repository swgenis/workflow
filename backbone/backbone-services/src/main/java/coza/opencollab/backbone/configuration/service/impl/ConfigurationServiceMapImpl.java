package coza.opencollab.backbone.configuration.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Singleton;

import com.google.common.collect.Lists;

import coza.opencollab.backbone.configuration.Application;
import coza.opencollab.backbone.configuration.Deployment;
import coza.opencollab.backbone.configuration.service.ConfigurationService;
import coza.opencollab.backbone.qualifiers.MapService;

@MapService
@Singleton
public class ConfigurationServiceMapImpl implements ConfigurationService {

    /**
     * Map containing all deployments by id
     */
    private Map<String, Application> applications = new HashMap<String, Application>();
    private Map<String, Deployment> deployments = new HashMap<String, Deployment>();
    
    @Override
    public void register(Application application) {
	// Safety check
	if (application != null) {
	    applications.put(application.getName(), application);
	}
    }

    @Override
    public Application getAppliction(String id) {
	return applications.get(id);
    }

    @Override
    public void register(Deployment deployment) {
	// Safety check
	if (deployment != null) {
	    deployments.put(deployment.getDeploymentId(), deployment);
	}
    }

    @Override
    public Deployment getDeployment(String id) {
	return deployments.get(id);
    }

    @Override
    public List<String> getApplicationCategories() {
	Set<String> categories = new HashSet<String>();
	for(Application deployment : applications.values()){
	    categories.add(deployment.getCategory());
	}
	return Lists.newArrayList(categories);
    }

    @Override
    public List<Application> getApplicationsByCategory(String category) {
	List<Application> returnApps = new ArrayList<Application>();
	for(Application application : applications.values()){
	    if(application.getCategory().equals(category)){
		returnApps.add(application);
	    }
	}
	return returnApps;
    }

}
