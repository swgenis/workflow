package coza.opencollab.backbone.configuration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author SW Genis
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Deployment {

    @XmlElement(name = "group")
    private String groupId;

    @XmlElement(name = "artifact")
    private String artifactId;

    @XmlElement(name = "version")
    private String version;

    @XmlElement(name = "category")
    private String category;

    @XmlElement(name = "type-source")
    private String typeSourceFile;
    
    @XmlElement(name = "url-launch")
    private String launchUrl;

    @XmlElement(name = "enable-workflow")
    private boolean workflowEnabled;

    @XmlElement(name = "interpreter")
    private String interpreterClass;
    
    /**
     * URL to view a task created by this deployment
     */
    @XmlElement(name = "url-view")
    private String viewOnlyUrl;

    public String getGroupId() {
	return groupId;
    }

    public void setGroupId(String groupId) {
	this.groupId = groupId;
    }

    public String getArtifactId() {
	return artifactId;
    }

    public void setArtifactId(String artifactId) {
	this.artifactId = artifactId;
    }

    public String getVersion() {
	return version;
    }

    public void setVersion(String version) {
	this.version = version;
    }

    public String getCategory() {
	return category;
    }

    public void setCategory(String category) {
	this.category = category;
    }

    public String getTypeSourceFile() {
	return typeSourceFile;
    }

    public void setTypeSourceFile(String typeSourceFile) {
	this.typeSourceFile = typeSourceFile;
    }

    public boolean isWorkflowEnabled() {
	return workflowEnabled;
    }

    public void setWorkflowEnabled(boolean workflowEnabled) {
	this.workflowEnabled = workflowEnabled;
    }

    /**
     * Get the deployment ID in the form of groupId:artifactId:version
     * 
     * @return
     */
    public String getDeploymentId() {
	return new StringBuilder().append(groupId).append(":").append(artifactId).append(":")
		    .append(version).toString();
    }

    public String getInterpreterClass() {
	return interpreterClass;
    }

    public void setInterpreterClass(String interpreterClass) {
	this.interpreterClass = interpreterClass;
    }

    public String getViewOnlyUrl() {
	return viewOnlyUrl;
    }

    public void setViewOnlyUrl(String viewOnlyUrl) {
	this.viewOnlyUrl = viewOnlyUrl;
    }

}
