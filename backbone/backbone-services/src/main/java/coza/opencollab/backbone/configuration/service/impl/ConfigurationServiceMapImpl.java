package coza.opencollab.backbone.configuration.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Singleton;

import com.google.common.collect.Lists;

import coza.opencollab.backbone.configuration.Deployment;
import coza.opencollab.backbone.configuration.service.ConfigurationService;
import coza.opencollab.backbone.qualifiers.MapService;

@MapService
@Singleton
public class ConfigurationServiceMapImpl implements ConfigurationService {

    /**
     * Map containing all deployments by id
     */
    private Map<String, Deployment> deployments = new HashMap<String, Deployment>();

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
    public List<String> getDeploymentCategories() {
	Set<String> categories = new HashSet<String>();
	for(Deployment deployment : deployments.values()){
	    categories.add(deployment.getCategory());
	}
	return Lists.newArrayList(categories);
    }

    @Override
    public List<Deployment> getDeploymentsByCategory(String category) {
	List<Deployment> returnDeployments = new ArrayList<Deployment>();
	for(Deployment deployment : deployments.values()){
	    if(deployment.getCategory().equals(category)){
		returnDeployments.add(deployment);
	    }
	}
	return returnDeployments;
    }

}
