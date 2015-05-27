package za.ac.nwu.workflow.backbone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that contains all the deployments that have been made in backbone
 * @author Charl Thiem
 *
 */
public class Deployments {

	/**
	 * Single instance of the deployments class
	 */
	private static Deployments singleton;
	
	/**
	 * Map containing all deployments
	 */
	private Map<String, Deployment> deploymentsMap = new HashMap<String, Deployment>();
	
	private Deployments(){}
	
	/**
	 * Get the instance of the Deployments object
	 * @return
	 */
	public static Deployments get(){
		if(singleton == null){
			singleton = new Deployments();
		}
		return singleton;
	}
	
	/**
	 * Add deployments
	 * @param deployments
	 */
	public void addDeployments(List<Deployment> deployments){
		// Safety check
		if(deployments != null && deployments.size() > 0){
			for(Deployment deployment : deployments){
				deploymentsMap.put(deployment.getDeploymentKey(), deployment);
			}
		}
	}
	
	/**
	 * Get a deployment for the specified deployment key
	 * @param deploymentKey Key of the deployment
	 * @return The instance of the deployment
	 */
	public Deployment getForKey(String deploymentKey){
		return deploymentsMap.get(deploymentKey);
	}
	
	public String getDeploymentIdForKey(String deploymentKey){
		Deployment deployment = getForKey(deploymentKey);
		if(deployment == null){
			throw new IllegalArgumentException("No deployment found for key: " + deploymentKey);
		}
		return deployment.getDeploymentId();
	}
	
}
