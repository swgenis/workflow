package za.ac.nwu.workflow.leave.service.impl;

import za.ac.nwu.workflow.leave.LeaveRecord;
import za.ac.nwu.workflow.leave.service.LeaveService;

/**
 * 
 * @author SW Genis
 * 
 */
public class LeaveMockDataLoader {

    public static final String APPLICANT1_ID = "bob";
    public static final String Record1_ID = "Record.1";
    public static final String APPLICANT2_ID = "john";
    public static final String Record2_ID = "Record.2";

    private LeaveService leaveService;

    public LeaveMockDataLoader(LeaveService leaveService) {
	this.leaveService = leaveService;
    }

    public void loadData() throws Exception {
	addLeave(Record1_ID, APPLICANT1_ID);
	addLeave(Record2_ID, APPLICANT2_ID);
    }

    private void addLeave(String id, String applicantId) throws Exception {
	LeaveRecord Record = new LeaveRecord();
	Record.setId(id);
	Record.setApplicantId(applicantId);
	leaveService.insertLeaveRecord(Record);
    }

}
