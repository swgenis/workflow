package za.ac.nwu.workflow.backbone.task;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jbpm.examples.util.StartupBean;
import org.jbpm.services.ejb.api.RuntimeDataServiceEJBLocal;
import org.jbpm.services.ejb.api.UserTaskServiceEJBLocal;
import org.jbpm.services.task.commands.CompleteTaskCommand;
import org.jbpm.services.task.commands.CompositeCommand;
import org.jbpm.services.task.commands.StartTaskCommand;
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

	@EJB(mappedName = "java:module/RuntimeDataServiceEJBImpl!org.jbpm.services.ejb.api.RuntimeDataServiceEJBLocal")
	private RuntimeDataServiceEJBLocal runtimeDataService;

	@EJB(mappedName = "java:module/UserTaskServiceEJBImpl!org.jbpm.services.ejb.api.UserTaskServiceEJBLocal")
	private UserTaskServiceEJBLocal userTaskService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GET
	@Path("/list")
	@Produces({ "application/json" })
	public List<TaskSummary> taskList(@QueryParam("user") String user) {
		logger.info("Displaying the task list for the user.");

		return runtimeDataService.getTasksAssignedAsPotentialOwner(user, null);
	}

	@GET
	@Path("/approve")
	@Produces({ "application/json" })
	public String approveTask(@QueryParam("taskId") long taskId,
			@QueryParam("user") String user) {
		CompositeCommand compositeCommand = new CompositeCommand(
				new CompleteTaskCommand(taskId, user, null),
				new StartTaskCommand(taskId, user));
		userTaskService.execute(StartupBean.DEPLOYMENT_ID, compositeCommand);
		return "Task (id = " + taskId + ") has been completed by " + user;
	}

}