package coza.opencollab.backbone.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author SW Genis
 * 
 */
@XmlRootElement(name = "backbone")
@XmlAccessorType(XmlAccessType.FIELD)
public class Backbone {
    
    @XmlElementWrapper
    @XmlElement(name = "application")
    private List<Application> applications;

    @XmlElementWrapper
    @XmlElement(name = "deployment")
    private List<Deployment> deployments;

    public List<Application> getApplications() {
	if (applications == null) {
	    applications = new ArrayList<Application>();
        }
	return applications;
    }
    
    public List<Deployment> getDeployments() {
	if (deployments == null) {
	    deployments = new ArrayList<Deployment>();
        }
	return deployments;
    }

}
