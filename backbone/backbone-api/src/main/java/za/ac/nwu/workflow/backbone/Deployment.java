package za.ac.nwu.workflow.backbone;

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

}
