package za.ac.nwu.workflow.backbone.leave;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;

import org.jbpm.examples.util.StartupBean;
import org.jbpm.services.ejb.api.ProcessServiceEJBLocal;
import org.jbpm.services.ejb.api.UserTaskServiceEJBLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/leave")
public class LeaveController {

	@EJB(mappedName = "java:module/ProcessServiceEJBImpl!org.jbpm.services.ejb.api.ProcessServiceEJBLocal")
	private ProcessServiceEJBLocal processService;

	@EJB(mappedName = "java:module/UserTaskServiceEJBImpl!org.jbpm.services.ejb.api.UserTaskServiceEJBLocal")
	private UserTaskServiceEJBLocal userTaskService;

	private static final Logger logger = LoggerFactory
			.getLogger(LeaveController.class);

	@RequestMapping(value = "/apply")
	public @ResponseBody
	String apply(LeaveApplicationForm leaveApplicationForm) {

		long processInstanceId = -1;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("recipient", leaveApplicationForm.getPersonId());
		params.put("form", leaveApplicationForm);
		processInstanceId = processService.startProcess(
				StartupBean.DEPLOYMENT_ID, "ac.za.nwu.workflow.leave-application", params);
		logger.info("Process instance " + processInstanceId
				+ " has been successfully started.");

		return "You have succesfully applied for leave.";
	}

}
