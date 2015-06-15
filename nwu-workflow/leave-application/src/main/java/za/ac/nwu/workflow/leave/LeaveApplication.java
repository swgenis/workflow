package za.ac.nwu.workflow.leave;

import java.io.Serializable;
import java.util.List;

import coza.opencollab.backbone.Entity;
import coza.opencollab.backbone.workflow.WorkflowState;

/**
 * 
 * @author SW Genis
 * 
 */
public class LeaveApplication extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String applicantId;

    private List<LeavePeriod> leavePeriods;
    
    /**
     * Address during leave
     */
    private String address;

    private WorkflowState state;

    public String getApplicantId() {
	return applicantId;
    }

    public void setApplicantId(String applicantId) {
	this.applicantId = applicantId;
    }

    public List<LeavePeriod> getLeavePeriods() {
	return leavePeriods;
    }

    public void setLeavePeriods(List<LeavePeriod> leavePeriods) {
	this.leavePeriods = leavePeriods;
    }

    public WorkflowState getState() {
	return state;
    }

    public void setState(WorkflowState state) {
	this.state = state;
    }

}
