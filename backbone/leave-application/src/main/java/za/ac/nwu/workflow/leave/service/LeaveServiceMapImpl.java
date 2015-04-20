package za.ac.nwu.workflow.leave.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import za.ac.nwu.workflow.leave.LeaveApplication;

public class LeaveServiceMapImpl implements LeaveService {

	private Map<String, LeaveApplication> leaveApplications = new HashMap<String, LeaveApplication>();

	@Override
	public LeaveApplication getLeaveApplicattionById(String key) {
		if(leaveApplications.containsKey(key)){
			return leaveApplications.get(key);
		}
		return null;
	}

	@Override
	public void insertLeaveApplication(LeaveApplication leaveApplication) throws Exception {
		if(leaveApplications.containsKey(leaveApplication.getId())){
			throw new Exception("Person already exists for id " + leaveApplication.getId());
		}
		leaveApplications.put(leaveApplication.getId(), leaveApplication);	
	}

	@Override
	public void updateLeaveApplicationForm(LeaveApplication person) throws Exception {
		if(!leaveApplications.containsKey(person.getId())){
			throw new Exception("Person does not exist for id " + person.getId());
		}
		leaveApplications.put(person.getId(), person);

	}

	@Override
	public void deleteLeaveApplicationFormById(String id) throws Exception {
		if(!leaveApplications.containsKey(id)){
			throw new Exception("Person does not exist for id " + id);
		}
		leaveApplications.remove(id);	
	}
	
	@Override
	public List<LeaveApplication> searchLeaveApplicationForm(String applicantId) throws Exception {
		List<LeaveApplication> searchResults = new ArrayList<LeaveApplication>();
		for (LeaveApplication person : leaveApplications.values()) {
			if(applicantId!=null){
				if (person.getApplicantId().equals(applicantId)) {
					searchResults.add(person);
				}
			}
		}
		return searchResults;
	}

	public Map<String, LeaveApplication> getPersons() {
		return leaveApplications;
	}

	public void setPersons(Map<String, LeaveApplication> leaveApplications) {
		this.leaveApplications = leaveApplications;
	}
}
