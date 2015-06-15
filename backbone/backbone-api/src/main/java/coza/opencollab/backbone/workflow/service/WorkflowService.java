package coza.opencollab.backbone.workflow.service;

import java.util.Map;

/**
 * 
 * @author SW Genis
 *
 */
public interface WorkflowService {
    
    /**
     * This method is responsible for initiating a new process instance.
     * 
     * @param deploymentId
     * @param processId
     * @param params
     * @return
     */
    public Long startProcess(String deploymentId, String processId, Map<String, Object> params);
    
    public Map<String, Object> getProcessParams(String deploymentId, Long processId);

}
