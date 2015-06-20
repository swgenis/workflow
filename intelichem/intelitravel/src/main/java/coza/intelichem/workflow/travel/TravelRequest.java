package coza.intelichem.workflow.travel;

import java.io.Serializable;
import java.util.List;

import coza.opencollab.backbone.Entity;
import coza.opencollab.backbone.workflow.WorkflowState;

/**
 * 
 * @author SW Genis
 * 
 */
public class TravelRequest extends Entity implements Serializable {

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
