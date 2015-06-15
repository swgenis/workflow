package za.ac.nwu.workflow.pay;

import java.io.Serializable;

import coza.opencollab.backbone.Entity;
import coza.opencollab.backbone.workflow.WorkflowState;

/**
 * 
 * @author SW Genis
 * 
 */
public class PayAdvice extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String applicantId;

    private WorkflowState state;

    public String getApplicantId() {
	return applicantId;
    }

    public void setApplicantId(String applicantId) {
	this.applicantId = applicantId;
    }

    public WorkflowState getState() {
	return state;
    }

    public void setState(WorkflowState state) {
	this.state = state;
    }

}
