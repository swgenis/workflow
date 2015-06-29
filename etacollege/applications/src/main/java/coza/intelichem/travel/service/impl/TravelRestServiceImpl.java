package coza.intelichem.travel.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jbpm.services.api.RuntimeDataService;
import org.kie.api.task.model.TaskSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import coza.intelichem.travel.TravelRequest;
import coza.intelichem.travel.service.TravelService;
import coza.intelichem.travel.service.TravelServiceConstants;
import coza.opencollab.backbone.Message;
import coza.opencollab.backbone.organization.OrgUnitMember;
import coza.opencollab.backbone.organization.service.OrganizationService;
import coza.opencollab.backbone.organization.service.OrganizationServiceConstants;
import coza.opencollab.backbone.type.Type;
import coza.opencollab.backbone.type.service.TypeService;
import coza.opencollab.backbone.workflow.WorkflowState;
import coza.opencollab.backbone.workflow.service.WorkflowService;

/**
 * Handles requests for the application home page.
 */
@Path("/travel")
public class TravelRestServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(TravelRestServiceImpl.class);

    @Inject
    private TravelService travelService;

    @Inject
    private TypeService typeService;

    @Inject
    private OrganizationService organizationService;
    
    @Inject
    private WorkflowService workflowService;
    
    @Inject
    private RuntimeDataService runtimeDataService;

    /**
     * Gets the types of leave that are available
     * 
     * @return
     * @throws Exception
     */
    @GET
    @Path("/types/seat")
    @Produces({ "application/json" })
    public List<Type> getSeatPreferenceTypes() throws Exception {
	return typeService.getTypesByCategory(TravelServiceConstants.CATEGORY_SEAT_PREFERENCE_TYPES);
    }
    
    /**
     * Gets the types of leave that are available
     * 
     * @return
     * @throws Exception
     */
    @GET
    @Path("/types/departure")
    @Produces({ "application/json" })
    public List<Type> getDeparturePreferenceTypes() throws Exception {
	return typeService.getTypesByCategory(TravelServiceConstants.CATEGORY_DEPARTURE_PREFERENCE_TYPES);
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
    @Path("/request")
    @Produces({ "application/json" })
    public Message request(TravelRequest travelRequest) {
	
	travelRequest.setState(WorkflowState.APPLIED);

	Map<String, Object> params = new HashMap<String, Object>();
	params.put("leaveApplication", travelRequest);
	params.put("manager", getManagerForApplicant(travelRequest.getApplicantId()));

	long processInstanceId = workflowService.startProcess(TravelServiceConstants.TRAVEL_APPLICATION_DEPLOYMENT_ID, TravelServiceConstants.TRAVEL_APPLICATION_PROCESS_ID, params);
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
	Map<String, Object> inParams = workflowService.getTaskParams(taskId);
	Map<String, Object> outParams = new HashMap<String, Object>();
	outParams.put("leaveApplicationOut", inParams.get("leaveApplicationIn"));
	workflowService.performUserTask(TravelServiceConstants.TRAVEL_APPLICATION_DEPLOYMENT_ID, taskId, user, outParams);
	return new Message("Task (id = " + taskId + ") has been completed by " + user);
    }

    @GET
    @Path("/deny")
    @Produces({ "application/json" })
    public Message denyLeave(@QueryParam("taskId") long taskId, @QueryParam("user") String user) {
	logger.info("User " + user + " is denying task " + taskId);
	Map<String, Object> inParams = workflowService.getTaskParams(taskId);
	TravelRequest leaveApplication = (TravelRequest) inParams.get("leaveApplicationIn");
	leaveApplication.setState(WorkflowState.DENIED);
	
	Map<String, Object> outParams = new HashMap<String, Object>();
	outParams.put("leaveApplicationOut", inParams.get("leaveApplicationIn"));
	workflowService.performUserTask(TravelServiceConstants.TRAVEL_APPLICATION_DEPLOYMENT_ID, taskId, user, outParams);
	return new Message("Task (id = " + taskId + ") has been completed by " + user);
    }

}
