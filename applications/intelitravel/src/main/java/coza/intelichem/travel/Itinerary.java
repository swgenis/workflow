package coza.intelichem.travel;

import java.io.Serializable;

import coza.opencollab.backbone.Entity;
import coza.opencollab.backbone.workflow.WorkflowState;

public class Itinerary extends Entity implements Serializable {

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
