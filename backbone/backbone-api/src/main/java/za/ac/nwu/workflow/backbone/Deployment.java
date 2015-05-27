package za.ac.nwu.workflow.backbone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

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

    @XmlElement(name = "type-source")
    private String typeSourceFile;
    
    @XmlTransient
    private String deploymentId;
    
    /**
     * A key that uniquely identifies the deployment
     */
    @XmlElement(name = "key")
    private String deploymentKey;

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

    public String getTypeSourceFile() {
	return typeSourceFile;
    }

    public void setTypeSourceFile(String typeSourceFile) {
	this.typeSourceFile = typeSourceFile;
    }
    
    /**
     * Get the deployment ID in the form of groupId:artifactId:version
     * @return
     */
    public String getDeploymentId(){
    	if(deploymentId == null){
    		deploymentId = new StringBuilder()
    		.append(groupId).append(":")
    		.append(artifactId).append(":")
    		.append(version).toString();
    	}
    	return deploymentId;
    }

	public String getDeploymentKey() {
		return deploymentKey;
	}

	public void setDeploymentKey(String deploymentKey) {
		this.deploymentKey = deploymentKey;
	}
    

}
