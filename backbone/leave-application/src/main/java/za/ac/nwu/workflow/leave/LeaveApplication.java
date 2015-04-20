package za.ac.nwu.workflow.leave;

import java.io.Serializable;
import java.util.Date;

import za.ac.nwu.workflow.backbone.Entity;

public class LeaveApplication extends Entity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String applicantId;
	
	private Date startDate;
	
	private Date endDate;

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
