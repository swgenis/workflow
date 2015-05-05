package za.ac.nwu.workflow.leave.service.impl;

import javax.inject.Inject;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.ac.nwu.workflow.leave.LeaveApplication;
import za.ac.nwu.workflow.leave.LeaveRecord;
import za.ac.nwu.workflow.leave.service.LeaveService;

/**
 * 
 * @author SW Genis
 * 
 */
public class LeaveApplicationWorkItem implements WorkItemHandler {

    private static final Logger logger = LoggerFactory.getLogger(LeaveApplicationWorkItem.class);

    @Inject
    private LeaveService leaveService;

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
	logger.info("Submitting an approved leave application");
	try {
	    LeaveRecord record = new LeaveRecord();
	    LeaveApplication application = (LeaveApplication) workItem.getParameter("leaveApplicationIn");
	    record.setApplicantId(application.getApplicantId());
	    record.setLeavePeriods(application.getLeavePeriods());
	    record.setState(application.getState());
	    leaveService.insertLeaveRecord(record);
	} catch (Exception e) {
	    throw new RuntimeException("Unable to submit leave applicaiton.", e);
	}
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
	logger.info("Leave Application was aborted.");
    }

}
