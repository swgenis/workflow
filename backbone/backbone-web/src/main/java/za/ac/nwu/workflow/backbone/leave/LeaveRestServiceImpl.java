package za.ac.nwu.workflow.backbone.leave;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.jbpm.examples.util.StartupBean;
import org.jbpm.services.ejb.api.ProcessServiceEJBLocal;
import org.jbpm.services.ejb.api.RuntimeDataServiceEJBLocal;
import org.jbpm.services.ejb.api.UserTaskServiceEJBLocal;
import org.kie.api.task.model.TaskSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles requests for the application home page.
 */
@Path("/leave")
public class LeaveRestServiceImpl {

	@EJB
	private ProcessServiceEJBLocal processService;
	
	@EJB
    private UserTaskServiceEJBLocal userTaskService;

    @EJB
    private RuntimeDataServiceEJBLocal runtimeDataService;

	private static final Logger logger = LoggerFactory
			.getLogger(LeaveRestServiceImpl.class);

	@POST
	@Path("/apply")
	public String apply(LeaveApplicationForm leaveApplicationForm) {

		long processInstanceId = -1;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("recipient", leaveApplicationForm.getPersonId());
		processInstanceId = processService.startProcess(
				StartupBean.DEPLOYMENT_ID, "org.jbpm.examples.rewards", params);
		logger.info("Process instance " + processInstanceId
				+ " has been successfully started.");

		return "You have succesfully applied for leave.";
	}
	
	@GET
	@Path("/list")
	public List<TaskSummary> taskList(String user){
		List<TaskSummary> taskList = runtimeDataService.getTasksAssignedAsPotentialOwner(user, null);
        return taskList;
	}

}
