package za.ac.nwu.workflow.leave.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.cdi.Kjar;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeEnvironment;
import org.kie.api.runtime.manager.RuntimeEnvironmentBuilder;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.manager.RuntimeManagerFactory;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.internal.runtime.manager.cdi.qualifier.Singleton;
import org.kie.internal.runtime.manager.context.EmptyContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.ac.nwu.workflow.backbone.Message;
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
    @Kjar
    DeploymentService deploymentService;
	
	@Inject
    @Singleton
    private RuntimeManager singletonManager;

	@Path("/apply")
	@POST
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Message apply(LeaveApplication leaveApplication) {
		
		RuntimeEngine runtime = singletonManager.getRuntimeEngine(EmptyContext.get());
        KieSession ksession = runtime.getKieSession();        
        
        Map<String, Object> params = new HashMap<String, Object>();
		params.put("applicantId", leaveApplication.getApplicantId());
        ProcessInstance processInstance = ksession.startProcess("ac.za.nwu.workflow.leave-application", params);
        singletonManager.disposeRuntimeEngine(runtime);

		logger.info("Process instance " + processInstance.getId()
				+ " has been successfully started.");

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
