package za.ac.nwu.workflow.backbone.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import org.jbpm.services.api.RuntimeDataService;
import org.jbpm.services.api.UserTaskService;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.TaskSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.ac.nwu.workflow.backbone.Deployment;
import za.ac.nwu.workflow.backbone.Deployments;
import za.ac.nwu.workflow.backbone.Message;
import za.ac.nwu.workflow.backbone.workflow.service.WorkflowService;

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

	@Inject
	private WorkflowService workflowService;

	/**
	 * Get all the tasks for the current user session
	 */
	@GET
	@Path("/list")
	@Produces({ "application/json" })
	public List<BackboneTaskSummary> taskListForActiveUser(@Context SecurityContext context, @QueryParam("user") String user) {

		// If no user is specified, we use the logged in user
		if(user == null){
			user = context.getUserPrincipal().getName();
		}
		List<TaskSummary> taskList = runtimeDataService.getTasksAssignedAsPotentialOwner(user, null);
		List<BackboneTaskSummary> bbTasks = new ArrayList<BackboneTaskSummary>(taskList.size());
		for(TaskSummary ts : taskList){
			Deployment deployment = Deployments.get().getForId(ts.getDeploymentId());
			BackboneTaskSummary bts = new BackboneTaskSummary();

			// Get the variables set when the task was started
			Map<String, Object> vars = workflowService.getProcessParams(ts.getDeploymentId(), ts.getProcessInstanceId());

			// Get the specific object that represents the task form
			Object ob = vars.get("leaveApplication"); // TODO this field name should become fixed for all tasks
			

			// Find the interpreter that will provide a nicer message about the task
			try {
				// Instantiate an instance of the interpreter for the task
				BackboneTaskInterpreter interpreter = (BackboneTaskInterpreter)Class.forName(deployment.getInterpreterClass()).newInstance();
				bts.setDescription(interpreter.shortDescription(ob, "en"));
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bts.setViewUrl(String.format(deployment.getUrlView(), Long.toString(ts.getId())));
			bts.setStatus(ts.getStatus().name());
			bts.setTaskId(ts.getId());
			bbTasks.add(bts);
		}

		logger.info("Displaying the task list for " + user);
		return bbTasks;
	}

	//    /**
	//     * Simply selects the home view to render by returning its name.
	//     */
	//    @GET
	//    @Path("/list")
	//    @Produces({ "application/json" })
	//    public List<TaskSummary> taskList(@QueryParam("user") String user) {
	//	logger.info("Displaying the task list for " + user);
	//	return runtimeDataService.getTasksAssignedAsPotentialOwner(user, null);
	//    }

	@GET
	@Path("/approve")
	@Produces({ "application/json" })
	public Message approveTask(@QueryParam("taskId") long taskId, @QueryParam("user") String user) {
		logger.info("User " + user + " is approving task " + taskId);
		userTaskService.claim(taskId, user);
		userTaskService.start(taskId, user);
		Map<String, Object> params = new HashMap<String, Object>();
		userTaskService.complete(taskId, user, params);
		return new Message("Task (id = " + taskId + ") has been completed by " + user);
	}

	@GET
	@Path("/deny")
	@Produces({ "application/json" })
	public Message cancelTask(@QueryParam("taskId") long taskId, @QueryParam("user") String user) {
		logger.info("User " + user + " is denying task " + taskId);
		userTaskService.claim(taskId, user);
		userTaskService.start(taskId, user);
		Map<String, Object> params = new HashMap<String, Object>();
		userTaskService.complete(taskId, user, params);
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
