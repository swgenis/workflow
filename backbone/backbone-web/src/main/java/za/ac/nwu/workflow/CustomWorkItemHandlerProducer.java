package za.ac.nwu.workflow;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.internal.runtime.manager.WorkItemHandlerProducer;

import za.ac.nwu.workflow.leave.service.impl.LeaveApplicationWorkItem;

/**
 * Allows to register custom work item handlers for every session that will be
 * build by the RuntimeManager.
 * 
 */
@ApplicationScoped
public class CustomWorkItemHandlerProducer implements WorkItemHandlerProducer {
	
	@Inject
	private LeaveApplicationWorkItem leaveApplicationWorkItem;

	public Map<String, WorkItemHandler> getWorkItemHandlers(String identifier,
			Map<String, Object> params) {
		Map<String, WorkItemHandler> handlers = new HashMap<String, WorkItemHandler>();
		handlers.put("submitLeaveApplication", leaveApplicationWorkItem);
		return handlers;
	}

}
