package za.ac.nwu.workflow.leave.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.inject.Singleton;

import za.ac.nwu.workflow.leave.LeaveRecord;
import za.ac.nwu.workflow.leave.service.LeaveService;

@Default
@Singleton
public class LeaveServiceMapImpl implements LeaveService {

    private Map<String, LeaveRecord> leaveRecords = new HashMap<String, LeaveRecord>();

    @PostConstruct
    public void initialize() throws Exception {
	LeaveMockDataLoader dataLoader = new LeaveMockDataLoader(this);
	try {
	    dataLoader.loadData();
	} catch (Exception e) {
	    throw new Exception("Unable to load data for PersonServiceMapImpl", e);
	}
    }

    @Override
    public LeaveRecord getLeaveRecordById(String id) {
	if (leaveRecords.containsKey(id)) {
	    return leaveRecords.get(id);
	}
	return null;
    }

    @Override
    public void insertLeaveRecord(LeaveRecord leaveRecord) throws Exception {
	// Set new id if it is null.
	if (leaveRecord.getId() == null) {
	    leaveRecord.setId(UUID.randomUUID().toString());
	}

	// Check if id does not already exist.
	if (leaveRecords.containsKey(leaveRecord.getId())) {
	    throw new Exception("Person already exists for id " + leaveRecord.getId());
	}
	leaveRecords.put(leaveRecord.getId(), leaveRecord);
    }

    @Override
    public void updateLeaveRecord(LeaveRecord person) throws Exception {
	if (!leaveRecords.containsKey(person.getId())) {
	    throw new Exception("Person does not exist for id " + person.getId());
	}
	leaveRecords.put(person.getId(), person);

    }

    @Override
    public void deleteLeaveRecordFormById(String id) throws Exception {
	if (!leaveRecords.containsKey(id)) {
	    throw new Exception("Person does not exist for id " + id);
	}
	leaveRecords.remove(id);
    }

    @Override
    public List<LeaveRecord> searchLeaveRecords(String applicantId) throws Exception {
	List<LeaveRecord> searchResults = new ArrayList<LeaveRecord>();
	for (LeaveRecord person : leaveRecords.values()) {
	    if (applicantId != null) {
		if (person.getApplicantId().equals(applicantId)) {
		    searchResults.add(person);
		}
	    }
	}
	return searchResults;
    }

}
