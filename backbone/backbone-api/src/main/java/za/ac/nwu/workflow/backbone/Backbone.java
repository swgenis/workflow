package za.ac.nwu.workflow.backbone;

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
    @XmlElement(name = "deployment")
    private List<Deployment> deployments;

    public List<Deployment> getDeployments() {
	if (deployments == null) {
	    deployments = new ArrayList<Deployment>();
        }
	return deployments;
    }

}
