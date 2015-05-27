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

import org.jbpm.services.api.RuntimeDataService;
import org.jbpm.services.api.UserTaskService;
import org.jbpm.services.task.commands.CompleteTaskCommand;
import org.jbpm.services.task.commands.CompositeCommand;
import org.jbpm.services.task.commands.StartTaskCommand;
import org.kie.api.task.model.TaskSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.ac.nwu.workflow.backbone.Deployments;
import za.ac.nwu.workflow.backbone.Message;
import za.ac.nwu.workflow.backbone.organization.OrgUnitMember;
import za.ac.nwu.workflow.backbone.organization.service.OrganizationService;
import za.ac.nwu.workflow.backbone.organization.service.OrganizationServiceConstants;
import za.ac.nwu.workflow.backbone.type.Type;
import za.ac.nwu.workflow.backbone.type.service.TypeService;
import za.ac.nwu.workflow.backbone.workflow.service.BackboneState;
import za.ac.nwu.workflow.backbone.workflow.service.WorkflowService;
import za.ac.nwu.workflow.leave.LeaveApplication;
import za.ac.nwu.workflow.leave.LeaveRecord;
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
    private WorkflowService workflowService;

    @Inject
    private UserTaskService userTaskService;
    
    @Inject
    private RuntimeDataService runtimeDataService;

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
     * Search for finalized leave records
     * 
     * @return
     * @throws Exception
     */
    @GET
    @Path("/search/records")
    @Produces({ "application/json" })
    public List<LeaveRecord> searchLeaveRecords(@QueryParam("applicantId") String applicantId)
	    throws Exception {
	return leaveService.searchLeaveRecords(applicantId);
    }
    
    /**
     * Search for leave applications.
     * 
     * @return
     * @throws Exception
     */
    @GET
    @Path("/search/applications")
    @Produces({ "application/json" })
    public List<TaskSummary> searchLeaveApplications(@QueryParam("user") String user)
	    throws Exception {
	logger.info("Displaying the task list for " + user);
	return runtimeDataService.getTasksAssignedAsPotentialOwner(user, null);
    }

    @POST
    @Path("/apply")
    @Produces({ "application/json" })
    public Message apply(LeaveApplication leaveApplication) {
	
	leaveApplication.setState(BackboneState.APPLIED);

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("leaveApplication", leaveApplication);
	params.put("manager", getManagerForApplicant(leaveApplication.getApplicantId()));

	String deploymentId = Deployments.get().getDeploymentIdForKey(LeaveServiceConstants.LEAVE_APPLICATION_DEPLOYMENT_KEY);
	long processInstanceId = workflowService.startProcess(deploymentId, LeaveServiceConstants.LEAVE_APPLICATION_PROCESS_ID, params);
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
		    return manager.getUserId();
		}
	    }
	} catch (Exception e) {
	    throw new RuntimeException("Unable to retrieve Manager for " + applicantId, e);
	}
	return null;
    }

    @GET
    @Path("/approve")
    @Produces({ "application/json" })
    public Message approveLeave(@QueryParam("taskId") long taskId, @QueryParam("user") String user) {
	logger.info("User " + user + " is approving task " + taskId);
	Map<String, Object> inParams = userTaskService.getTaskInputContentByTaskId(taskId);
	Map<String, Object> outParams = new HashMap<String, Object>();
	outParams.put("leaveApplicationOut", inParams.get("leaveApplicationIn"));
	CompositeCommand compositeCommand = new CompositeCommand(new CompleteTaskCommand(taskId, user, outParams),
		new StartTaskCommand(taskId, user));
	
	String deploymentId = Deployments.get().getDeploymentIdForKey(LeaveServiceConstants.LEAVE_APPLICATION_DEPLOYMENT_KEY);
	userTaskService.execute(deploymentId, compositeCommand);
	return new Message("Task (id = " + taskId + ") has been completed by " + user);
    }

    @GET
    @Path("/deny")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Message denyLeave(@QueryParam("taskId") long taskId, @QueryParam("user") String user) {
	logger.info("User " + user + " is denying task " + taskId);
	Map<String, Object> inParams = userTaskService.getTaskInputContentByTaskId(taskId);
	LeaveApplication leaveApplication = (LeaveApplication) inParams.get("leaveApplicationIn");
	leaveApplication.setState(BackboneState.DENIED);
	
	Map<String, Object> outParams = new HashMap<String, Object>();
	outParams.put("leaveApplicationOut", inParams.get("leaveApplicationIn"));
	CompositeCommand compositeCommand = new CompositeCommand(new CompleteTaskCommand(taskId, user, null),
		new StartTaskCommand(taskId, user));
	
	String deploymentId = Deployments.get().getDeploymentIdForKey(LeaveServiceConstants.LEAVE_APPLICATION_DEPLOYMENT_KEY);
	userTaskService.execute(deploymentId, compositeCommand);
	return new Message("Task (id = " + taskId + ") has been completed by " + user);
    }

}
