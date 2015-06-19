package coza.opencollab.backbone.workflow.service.jbpm;

import java.util.Map;

import javax.inject.Inject;

import org.drools.core.command.impl.GenericCommand;
import org.drools.core.command.impl.KnowledgeCommandContext;
import org.jbpm.process.core.context.variable.VariableScope;
import org.jbpm.process.instance.context.variable.VariableScopeInstance;
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
import org.kie.internal.command.Context;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;

import coza.opencollab.backbone.workflow.service.WorkflowService;

/**
 * Jbpm implementation of the workflow service.
 * 
 * All Backbone/Jbpm interaction should be behind this service layer.
 * 
 * @author SW Genis
 * 
 */
public class WorkflowServiceJbpmImpl implements WorkflowService {

    @Inject
    @Kjar
    private DeploymentService deploymentService;
    
    @Inject
    private UserTaskService userTaskService;

    @Override
    public Long startProcess(String deploymentId, String processId, Map<String, Object> params) {
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

    public Map<String, Object> getProcessParams(String deploymentId, final Long processId) {
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

	Map<String, Object> variables = ksession.execute(new GenericCommand<Map<String, Object>>() {

	    public Map<String, Object> execute(Context context) {
		KieSession ksession = ((KnowledgeCommandContext) context).getKieSession();
		org.jbpm.process.instance.ProcessInstance processInstance = (org.jbpm.process.instance.ProcessInstance) ksession
			.getProcessInstance(processId);
		VariableScopeInstance variableScope = (VariableScopeInstance) processInstance
			.getContextInstance(VariableScope.VARIABLE_SCOPE);
		Map<String, Object> variables = variableScope.getVariables();
		return variables;
	    }
	});
	return variables;
    }
    
    public Map<String, Object> getTaskParams(Long taskId){
	return userTaskService.getTaskInputContentByTaskId(taskId);
    }

    public void performUserTask(String deploymentId, Long taskId, String user, Map<String, Object> outParams) {
	CompositeCommand compositeCommand = new CompositeCommand(new CompleteTaskCommand(taskId, user, null),
		new StartTaskCommand(taskId, user));

	userTaskService.execute(deploymentId, compositeCommand);
    }

}
