package za.ac.nwu.workflow.leave.service;

import java.util.List;

import za.ac.nwu.workflow.leave.LeaveApplication;

public interface LeaveService {

	LeaveApplication getLeaveApplicattionById(String key);

	void insertLeaveApplication(LeaveApplication leaveApplication)
			throws Exception;

	void updateLeaveApplicationForm(LeaveApplication person)
			throws Exception;

	void deleteLeaveApplicationFormById(String id) throws Exception;

	List<LeaveApplication> searchLeaveApplicationForm(String applicant)
			throws Exception;

}
