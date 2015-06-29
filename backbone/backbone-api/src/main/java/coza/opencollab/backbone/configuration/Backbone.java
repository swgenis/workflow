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

    @XmlElement
    private String title;

    @XmlElement(name = "brand-image")
    private String brandImage;

    @XmlElementWrapper
    @XmlElement(name = "application")
    private List<Application> applications;

    @XmlElementWrapper
    @XmlElement(name = "deployment")
    private List<Deployment> deployments;

    @XmlElementWrapper(name = "types-source-files")
    @XmlElement(name = "type-source-file")
    private List<String> typeSourceFiles;

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getBrandImage() {
	return brandImage;
    }

    public void setBrandImage(String brandImage) {
	this.brandImage = brandImage;
    }

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

    public List<String> getTypeSourceFiles() {
	if (typeSourceFiles == null) {
	    typeSourceFiles = new ArrayList<String>();
	}
	return typeSourceFiles;
    }

}
