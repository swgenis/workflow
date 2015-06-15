package za.ac.nwu.workflow.leave;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

import coza.opencollab.backbone.task.BackboneTaskInterpreter;

public class LeaveTaskInterpreter implements BackboneTaskInterpreter<LeaveApplication> {

    @Override
    public String shortDescription(LeaveApplication task, String language) {
	StringBuilder sb = new StringBuilder();
	sb.append(task.getApplicantId());
	sb.append(" - Leave for ");

	List<LeavePeriod> leavePeriods = task.getLeavePeriods();
	int days = 0;
	for (LeavePeriod leavePeriod : leavePeriods) {
	    days += Days.daysBetween(new DateTime(leavePeriod.getStartDate().getTime()),
		    new DateTime(leavePeriod.getEndDate().getTime())).getDays();
	}
	sb.append(days).append(" days");
	return sb.toString();
    }

    @Override
    public String longDescription(LeaveApplication task, String language) {
	return shortDescription(task, language);
    }

}
