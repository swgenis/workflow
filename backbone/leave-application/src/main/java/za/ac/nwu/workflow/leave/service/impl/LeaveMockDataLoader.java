package za.ac.nwu.workflow.leave.service.impl;

import za.ac.nwu.workflow.leave.LeaveApplication;
import za.ac.nwu.workflow.leave.service.LeaveService;

/**
 * 
 * @author SW Genis
 *
 */
public class LeaveMockDataLoader {
	
	public static final String APPLICANT1_ID = "bob";
	public static final String APPLICATION1_ID = "application.1";
	public static final String APPLICANT2_ID = "john";
	public static final String APPLICATION2_ID = "application.2";

	private LeaveService leaveService;
	
	public LeaveMockDataLoader(LeaveService leaveService){
		this.leaveService = leaveService;
	}

	public void loadData() throws Exception {
		addLeave(APPLICATION1_ID, APPLICANT1_ID);
		addLeave(APPLICATION2_ID, APPLICANT2_ID);
	}

	private void addLeave(String id, String applicantId) throws Exception {
		LeaveApplication application = new LeaveApplication();
		application.setId(id);
		application.setApplicantId(applicantId);
		leaveService.insertLeaveApplication(application);
	}

}
