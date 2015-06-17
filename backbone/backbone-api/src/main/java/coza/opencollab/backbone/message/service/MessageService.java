package coza.opencollab.backbone.message.service;

import java.util.Map;

import coza.opencollab.backbone.message.MessageTemplate;

/**
 * 
 * @author SW Genis
 *
 */
public interface MessageService {
    
    /**
     * 
     * @param templateId
     * @return
     */
    public MessageTemplate getMessageTemplate(String templateId);
    
    /**
     * 
     * @param template
     */
    public void insertMessageTemplate(MessageTemplate template);
    
    /**
     * 
     * @param template
     */
    public void updateMessageTemplate(MessageTemplate template);
    
    /**
     * 
     * @param templateId
     */
    public void deleteMessageTemplate(String templateId);
    
    /**
     * 
     * @param templateId
     * @param parameters
     */
    public void sendMessage(String templateId, Map<String, String> parameters);

}
