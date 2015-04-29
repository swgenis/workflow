package za.ac.nwu.workflow.leave.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jbpm.services.api.ProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.ac.nwu.workflow.backbone.Message;
import za.ac.nwu.workflow.backbone.type.service.Type;
import za.ac.nwu.workflow.backbone.type.service.TypeService;
import za.ac.nwu.workflow.backbone.type.service.TypeServiceConstants;
import za.ac.nwu.workflow.leave.LeaveApplication;
import za.ac.nwu.workflow.leave.service.LeaveService;

/**
 * Handles requests for the application home page.
 */
@Stateless
@Path("/leave")
public class LeaveRestServiceImpl {

	private static final Logger logger = LoggerFactory
			.getLogger(LeaveRestServiceImpl.class);

	public static final String DEPLOYMENT_ID = "nwu.workflow.backbone:leave-application:1.0-SNAPSHOT";

	@Inject
	private LeaveService leaveService;

	@Inject
	private TypeService typeService;

	@Inject
	private ProcessService processService;

	/**
	 * Gets the types of leave that are available
	 * 
	 * @return
	 * @throws Exception
	 */
	@Path("/types.json")
	@GET
	@Produces({ "application/json" })
	public List<Type> getLeaveTypes() throws Exception {
		return typeService
				.getTypesByCategory(TypeServiceConstants.CATEGORY_LEAVE_TYPES);
	}
	
	/**
	 * Gets the types of leave that are available
	 * 
	 * @return
	 * @throws Exception
	 */
	@Path("/search")
	@GET
	@Produces({ "application/json" })
	public List<LeaveApplication> searchLeaveApplications(@QueryParam("applicantId") String applicantId) throws Exception {
		return leaveService.searchLeaveApplication(applicantId);
	}

	@Path("/apply")
	@POST
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Message apply(LeaveApplication leaveApplication) {
		long processInstanceId = -1;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("leaveApplication", leaveApplication);
		processInstanceId = processService.startProcess(
				"nwu.workflow.backbone:leave-application:1.0-SNAPSHOT",
				"ac.za.nwu.workflow.leave-application", params);
		logger.info("Succesfully started process with id: " + processInstanceId);
		
		return new Message("You have succesfully applied for leave");
	}

	@Path(value = "/submit")
	@POST
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Message submit(LeaveApplication leaveApplication) {
		try {
			leaveService.insertLeaveApplication(leaveApplication);
		} catch (Exception e) {
			logger.error("Unable to insert leave application", e);
			return new Message("Error inserting leave application for "
					+ leaveApplication.getApplicantId());
		}
		return new Message("Leave application has been approved for "
				+ leaveApplication.getApplicantId());
	}

}
