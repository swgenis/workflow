package za.ac.nwu.workflow.backbone.task;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.kie.api.task.TaskService;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.TaskSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles requests for the application home page.
 */
@Stateless
@Path("/task")
public class TaskRestServiceImpl {

	private static final Logger logger = LoggerFactory
			.getLogger(TaskRestServiceImpl.class);
	
	@Inject
    TaskService taskService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GET
	@Path("/list")
	@Produces({ "application/json" })
	public List<TaskSummary> taskList(@QueryParam("user") String user) {
		logger.info("Displaying the task list for the user.");
		return taskService.getTasksAssignedAsPotentialOwner(user, null);
	}
	
	@GET
	@Path("/approve")
	@Produces({ "application/json" })
	public String approveTask(@QueryParam("taskId") long taskId,
			@QueryParam("user") String user) {
		taskService.start(taskId, user);
        taskService.complete(taskId, user, null);
		return "{\"msg\":\"Task (id = " + taskId + ") has been completed by " + user + "\"}";
	}
	
	@GET
	@Path("/deny")
	@Produces({ "application/json" })
	public String denyTask(@QueryParam("taskId") long taskId,
			@QueryParam("user") String user) {
		taskService.start(taskId, user);
        taskService.complete(taskId, user, null);
		return "Task (id = " + taskId + ") has been completed by " + user;
	}
	
	@GET
	@Path("/{id}")
	@Produces({ "application/json" })
	public Task getTask(@PathParam("id") long taskId) {
		logger.info("Retrieving the task by id.");
		return taskService.getTaskById(taskId);
	}

}
