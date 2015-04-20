package za.ac.nwu.workflow.leave.service;

import java.util.List;

import za.ac.nwu.workflow.leave.LeaveApplication;

/**
 * 
 * @author SW Genis
 *
 */
public interface LeaveService {

	/**
	 * 
	 * @param key
	 * @return
	 */
	LeaveApplication getLeaveApplicationById(String key);

	/**
	 * 
	 * @param leaveApplication
	 * @throws Exception
	 */
	void insertLeaveApplication(LeaveApplication leaveApplication)
			throws Exception;

	/**
	 * 
	 * @param person
	 * @throws Exception
	 */
	void updateLeaveApplication(LeaveApplication person)
			throws Exception;

	/**
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteLeaveApplicationFormById(String id) throws Exception;

	/**
	 * 
	 * @param applicant
	 * @return
	 * @throws Exception
	 */
	List<LeaveApplication> searchLeaveApplication(String applicant)
			throws Exception;

}
