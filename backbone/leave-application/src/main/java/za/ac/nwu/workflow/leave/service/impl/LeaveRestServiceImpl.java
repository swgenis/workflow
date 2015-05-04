package za.ac.nwu.workflow.leave.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jbpm.services.api.DeploymentNotFoundException;
import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.api.UserTaskService;
import org.jbpm.services.api.model.DeployedUnit;
import org.jbpm.services.cdi.Kjar;
import org.jbpm.services.task.commands.CompleteTaskCommand;
import org.jbpm.services.task.commands.CompositeCommand;
import org.jbpm.services.task.commands.StartTaskCommand;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.ac.nwu.workflow.backbone.Message;
import za.ac.nwu.workflow.backbone.authorization.User;
import za.ac.nwu.workflow.backbone.authorization.service.AuthorizationService;
import za.ac.nwu.workflow.backbone.organization.OrgUnitMember;
import za.ac.nwu.workflow.backbone.organization.service.OrganizationService;
import za.ac.nwu.workflow.backbone.organization.service.OrganizationServiceConstants;
import za.ac.nwu.workflow.backbone.type.Type;
import za.ac.nwu.workflow.backbone.type.service.TypeService;
import za.ac.nwu.workflow.leave.LeaveApplication;
import za.ac.nwu.workflow.leave.service.LeaveService;
import za.ac.nwu.workflow.leave.service.LeaveServiceConstants;

/**
 * Handles requests for the application home page.
 */
@Path("/leave")
public class LeaveRestServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(LeaveRestServiceImpl.class);

    @Inject
    private LeaveService leaveService;

    @Inject
    private TypeService typeService;

    @Inject
    private OrganizationService organizationService;

    @Inject
    private AuthorizationService authorizationService;

    @Inject
    @Kjar
    DeploymentService deploymentService;

    @Inject
    private UserTaskService userTaskService;

    /**
     * This method must be extracted to a super class.
     * 
     * @param deploymentId
     * @param processId
     * @param params
     * @return
     */
    private Long startProcess(String deploymentId, String processId, Map<String, Object> params) {
	DeployedUnit deployedUnit = deploymentService.getDeployedUnit(deploymentId);
	if (deployedUnit == null) {
	    throw new DeploymentNotFoundException("No deployments available for " + deploymentId);
	}
	if (!deployedUnit.isActive()) {
	    throw new DeploymentNotFoundException("Deployments " + deploymentId + " is not active");
	}

	RuntimeManager manager = deployedUnit.getRuntimeManager();

	RuntimeEngine engine = manager.getRuntimeEngine(ProcessInstanceIdContext.get());
	KieSession ksession = engine.getKieSession();
	ProcessInstance pi = null;
	try {
	    pi = ksession.startProcess(processId, params);
	    return pi.getId();
	} finally {
	    manager.disposeRuntimeEngine(engine);
	}
    }

    /**
     * Gets the types of leave that are available
     * 
     * @return
     * @throws Exception
     */
    @GET
    @Path("/types.json")
    @Produces({ "application/json" })
    public List<Type> getLeaveTypes() throws Exception {
	return typeService.getTypesByCategory(LeaveServiceConstants.CATEGORY_LEAVE_TYPES);
    }

    /**
     * Gets the types of leave that are available
     * 
     * @return
     * @throws Exception
     */
    @GET
    @Path("/search")
    @Produces({ "application/json" })
    public List<LeaveApplication> searchLeaveApplications(@QueryParam("applicantId") String applicantId)
	    throws Exception {
	return leaveService.searchLeaveApplication(applicantId);
    }

    @POST
    @Path("/apply")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Message apply(LeaveApplication leaveApplication) {

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("leaveApplication", leaveApplication);
	params.put("manager", getManagerForApplicant(leaveApplication.getApplicantId()));

	long processInstanceId = this.startProcess(LeaveServiceConstants.LEAVE_APPLICATION_DEPLOYMENT_ID,
		LeaveServiceConstants.LEAVE_APPLICATION_PROCESS_ID, params);
	logger.info("Succesfully started process with id: " + processInstanceId);

	return new Message("You have succesfully applied for leave");
    }

    private String getManagerForApplicant(String applicantId) {
	try {
	    List<OrgUnitMember> orgUnitMembers = organizationService.searchOrgUnitMember(null, applicantId);
	    for (OrgUnitMember orgUnitMember : orgUnitMembers) {
		List<OrgUnitMember> managers = organizationService.getOrgUnitMembersByOrgIdAndType(
			orgUnitMember.getOrgId(), OrganizationServiceConstants.TYPE_ORGUNITMEMBER_MANAGER);
		for (OrgUnitMember manager : managers) {
		    User user = authorizationService.getUserByPersonId(manager.getPersonId());
		    return user.getId();
		}
	    }
	} catch (Exception e) {
	    throw new RuntimeException("Unable to retrieve Manager for " + applicantId, e);
	}
	return null;
    }

    @GET
    @Path("/approve")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Message approveLeave(@QueryParam("taskId") long taskId, @QueryParam("user") String user) {
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
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Message denyLeave(@QueryParam("taskId") long taskId, @QueryParam("user") String user) {
	logger.info("User " + user + " is denying task " + taskId);
	CompositeCommand compositeCommand = new CompositeCommand(new CompleteTaskCommand(taskId, user, null),
		new StartTaskCommand(taskId, user));
	userTaskService.execute(LeaveServiceConstants.LEAVE_APPLICATION_DEPLOYMENT_ID, compositeCommand);
	return new Message("Task (id = " + taskId + ") has been completed by " + user);
    }

    @POST
    @Path(value = "/submit")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Message submit(LeaveApplication leaveApplication) {
	try {
	    leaveService.insertLeaveApplication(leaveApplication);
	} catch (Exception e) {
	    logger.error("Unable to insert leave application", e);
	    return new Message("Error inserting leave application for " + leaveApplication.getApplicantId());
	}
	return new Message("Leave application has been approved for " + leaveApplication.getApplicantId());
    }

}
