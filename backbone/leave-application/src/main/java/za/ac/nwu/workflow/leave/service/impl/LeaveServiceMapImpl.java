package za.ac.nwu.workflow.leave.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;

import za.ac.nwu.workflow.leave.LeaveApplication;
import za.ac.nwu.workflow.leave.service.LeaveService;

@Default
public class LeaveServiceMapImpl implements LeaveService {

	private Map<String, LeaveApplication> leaveApplications = new HashMap<String, LeaveApplication>();
	
	@PostConstruct
	public void initialize() throws Exception{
		LeaveMockDataLoader dataLoader = new LeaveMockDataLoader(this);
		try {
			dataLoader.loadData();
		} catch (Exception e) {
			throw new Exception("Unable to load data for PersonServiceMapImpl", e);
		}
	}

	@Override
	public LeaveApplication getLeaveApplicationById(String id) {
		if(leaveApplications.containsKey(id)){
			return leaveApplications.get(id);
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
	public void updateLeaveApplication(LeaveApplication person) throws Exception {
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
	public List<LeaveApplication> searchLeaveApplication(String applicantId) throws Exception {
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

}
