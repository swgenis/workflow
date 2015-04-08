package za.ac.nwu.workflow.backbone.leave;

import java.util.Date;

import javax.ws.rs.FormParam;

public class LeaveApplicationForm {
	
	@FormParam("personLookupId")
	private String personId;
	
	private Date startDate;
	
	private Date endDate;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
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
