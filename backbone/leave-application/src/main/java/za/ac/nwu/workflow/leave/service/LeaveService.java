package za.ac.nwu.workflow.leave.service;

import java.util.List;

import za.ac.nwu.workflow.leave.LeaveRecord;

/**
 * CRUD Service to persist leave records.
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
    LeaveRecord getLeaveRecordById(String key);

    /**
     * 
     * @param leaveRecord
     * @throws Exception
     */
    void insertLeaveRecord(LeaveRecord leaveRecord) throws Exception;

    /**
     * 
     * @param person
     * @throws Exception
     */
    void updateLeaveRecord(LeaveRecord person) throws Exception;

    /**
     * 
     * @param id
     * @throws Exception
     */
    void deleteLeaveRecordFormById(String id) throws Exception;

    /**
     * 
     * @param applicantId
     * @return
     * @throws Exception
     */
    List<LeaveRecord> searchLeaveRecords(String applicantId) throws Exception;

}
