package za.ac.nwu.workflow.backbone.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jbpm.services.api.RuntimeDataService;
import org.jbpm.services.api.UserTaskService;
import org.jbpm.services.task.commands.CompleteTaskCommand;
import org.jbpm.services.task.commands.CompositeCommand;
import org.jbpm.services.task.commands.StartTaskCommand;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.TaskSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.ac.nwu.workflow.backbone.Message;
import za.ac.nwu.workflow.leave.service.LeaveServiceConstants;

/**
 * Handles requests for the application home page.
 */
@Path("/task")
public class TaskRestServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(TaskRestServiceImpl.class);

    @Inject
    private UserTaskService userTaskService;

    @Inject
    private RuntimeDataService runtimeDataService;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @GET
    @Path("/list")
    @Produces({ "application/json" })
    public List<TaskSummary> taskList(@QueryParam("user") String user) {
	logger.info("Displaying the task list for " + user);
	return runtimeDataService.getTasksAssignedAsPotentialOwner(user, null);
    }

    @GET
    @Path("/approve")
    @Produces({ "application/json" })
    public Message approveTask(@QueryParam("taskId") long taskId, @QueryParam("user") String user) {
	logger.info("User " + user + " is approving task " + taskId);
	Map<String, Object> inParams = userTaskService.getTaskInputContentByTaskId(taskId);
	Map<String, Object> outParams = new HashMap<String, Object>();
	outParams.put("leaveApplicationOut", inParams.get("leaveApplicationIn"));
	CompositeCommand compositeCommand = new CompositeCommand(new CompleteTaskCommand(taskId, user, outParams),
		new StartTaskCommand(taskId, user));
	userTaskService.execute(LeaveServiceConstants.LEAVE_APPLICATION_DEPLOYMENT_ID, compositeCommand);
	return new Message("Task (id = " + taskId + ") has been completed by " + user);
    }

    @GET
    @Path("/deny")
    @Produces({ "application/json" })
    public Message cancelTask(@QueryParam("taskId") long taskId, @QueryParam("user") String user) {
	logger.info("User " + user + " is denying task " + taskId);
	CompositeCommand compositeCommand = new CompositeCommand(new CompleteTaskCommand(taskId, user, null),
		new StartTaskCommand(taskId, user));
	userTaskService.execute(LeaveServiceConstants.LEAVE_APPLICATION_DEPLOYMENT_ID, compositeCommand);
	return new Message("Task (id = " + taskId + ") has been completed by " + user);
    }

    @GET
    @Path("/{id}")
    @Produces({ "application/json" })
    public Task getTask(@PathParam("id") long taskId) {
	logger.info("Retrieving the task by id.");
	return userTaskService.getTask(taskId);
    }

}
