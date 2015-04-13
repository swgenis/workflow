package za.ac.nwu.workflow.backbone.home;

import java.util.List;

import javax.ejb.EJB;

import org.jbpm.examples.util.StartupBean;
import org.jbpm.services.ejb.api.RuntimeDataServiceEJBLocal;
import org.jbpm.services.ejb.api.UserTaskServiceEJBLocal;
import org.jbpm.services.task.commands.CompleteTaskCommand;
import org.jbpm.services.task.commands.CompositeCommand;
import org.jbpm.services.task.commands.StartTaskCommand;
import org.kie.api.task.model.TaskSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import za.ac.nwu.workflow.backbone.leave.LeaveApplicationForm;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@EJB(mappedName = "java:module/RuntimeDataServiceEJBImpl!org.jbpm.services.ejb.api.RuntimeDataServiceEJBLocal")
	private RuntimeDataServiceEJBLocal runtimeDataService;

	@EJB(mappedName = "java:module/UserTaskServiceEJBImpl!org.jbpm.services.ejb.api.UserTaskServiceEJBLocal")
	private UserTaskServiceEJBLocal userTaskService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home! The client locale is {}.");

		model.addAttribute("message", "welcome to nwu backbone!");
		return "home";
	}

	@ModelAttribute("leave-application-form")
	public LeaveApplicationForm createFormBean() {
		logger.info("Create new person inspector form");
		return new LeaveApplicationForm();
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/tasklist", method = RequestMethod.GET)
	public String taskList(@RequestParam String user, Model model) {
		logger.info("Displaying the task list for the user.");

		List<TaskSummary> taskList = runtimeDataService.getTasksAssignedAsPotentialOwner(user, null);
		model.addAttribute("taskList", taskList);
		return "task-list";
	}

	@RequestMapping(value = "/approve", method = RequestMethod.GET)
	public String approveTask(@RequestParam long taskId,
			@RequestParam String user, Model model) {
		String message;
		CompositeCommand compositeCommand = new CompositeCommand(new CompleteTaskCommand(taskId, user, null),
				new StartTaskCommand(taskId, user));
		userTaskService.execute(StartupBean.DEPLOYMENT_ID, compositeCommand);
		message = "Task (id = " + taskId + ") has been completed by " + user;
		System.out.println(message);
		model.addAttribute("message", message);
		return "home";
	}

}
