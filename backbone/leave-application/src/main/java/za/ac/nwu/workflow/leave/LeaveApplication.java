package za.ac.nwu.workflow.leave;

import java.io.Serializable;
import java.util.List;

import za.ac.nwu.workflow.backbone.Entity;

public class LeaveApplication extends Entity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String applicantId;
	
	private List<LeavePeriod> leavePeriods;

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

}
