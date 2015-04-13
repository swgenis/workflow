package za.ac.nwu.workflow.backbone.leave;

import java.io.Serializable;
import java.util.Date;

import javax.ws.rs.FormParam;

public class LeaveApplicationForm implements Serializable {
	
	private static final long serialVersionUID = 1L;

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
