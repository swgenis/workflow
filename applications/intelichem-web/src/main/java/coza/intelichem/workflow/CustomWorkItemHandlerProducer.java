package coza.intelichem.workflow;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.internal.runtime.manager.WorkItemHandlerProducer;

/**
 * Allows to register custom work item handlers for every session that will be
 * build by the RuntimeManager.
 * 
 */
@ApplicationScoped
public class CustomWorkItemHandlerProducer implements WorkItemHandlerProducer {

    public Map<String, WorkItemHandler> getWorkItemHandlers(String identifier, Map<String, Object> params) {
	Map<String, WorkItemHandler> handlers = new HashMap<String, WorkItemHandler>();
	return handlers;
    }

}
