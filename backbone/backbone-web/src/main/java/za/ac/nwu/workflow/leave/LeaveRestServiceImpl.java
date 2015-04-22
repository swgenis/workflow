package za.ac.nwu.workflow.leave;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.jbpm.services.ejb.api.ProcessServiceEJBLocal;
import org.jbpm.services.ejb.api.UserTaskServiceEJBLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.ac.nwu.workflow.StartupBean;
import za.ac.nwu.workflow.leave.service.LeaveService;

/**
 * Handles requests for the application home page.
 */
@Stateless
@Path("/leave")
public class LeaveRestServiceImpl {

	@EJB
	private ProcessServiceEJBLocal processService;

	@EJB
	private UserTaskServiceEJBLocal userTaskService;

	@Inject
	private LeaveService leaveService;

	private static final Logger logger = LoggerFactory
			.getLogger(LeaveRestServiceImpl.class);

	@Path(value = "/apply")
	@POST
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public String apply(LeaveApplication leaveApplication) {

		long processInstanceId = -1;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicantId", leaveApplication.getApplicantId());
		processInstanceId = processService.startProcess(
				StartupBean.DEPLOYMENT_ID,
				"ac.za.nwu.workflow.leave-application", params);
		logger.info("Process instance " + processInstanceId
				+ " has been successfully started.");

		return "{\"msg\":\"You have succesfully applied for leave\"}";
	}

}