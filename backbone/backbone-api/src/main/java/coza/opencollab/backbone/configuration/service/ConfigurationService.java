package coza.opencollab.backbone.configuration.service;

import java.util.List;

import coza.opencollab.backbone.configuration.Deployment;

public interface ConfigurationService {

    public void register(Deployment deployment);

    /**
     * Get a deployment for the specified deployment id
     * 
     * @param id Id of the deployment
     * @return The instance of the deployment
     */
    public Deployment getDeployment(String id);

    public List<String> getDeploymentCategories();
    
    public List<Deployment> getDeploymentsByCategory(String category);

}
