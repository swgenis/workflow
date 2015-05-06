package za.ac.nwu.workflow.leave;

import java.io.Serializable;
import java.util.List;

import za.ac.nwu.workflow.backbone.Entity;
import za.ac.nwu.workflow.backbone.workflow.service.BackboneState;

public class LeaveRecord extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String applicantId;

    private List<LeavePeriod> leavePeriods;

    private BackboneState state;

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

    public BackboneState getState() {
	return state;
    }

    public void setState(BackboneState state) {
	this.state = state;
    }
    
}
