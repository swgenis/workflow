package coza.opencollab.backbone.message.service.impl;

import java.util.Map;

import javax.inject.Singleton;

import coza.opencollab.backbone.message.MessageTemplate;
import coza.opencollab.backbone.message.service.MessageService;
import coza.opencollab.backbone.qualifiers.MapService;

@MapService
@Singleton
public class MessageServiceImpl implements MessageService {

    @Override
    public MessageTemplate getMessageTemplate(String templateId) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void insertMessageTemplate(MessageTemplate template) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void updateMessageTemplate(MessageTemplate template) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void deleteMessageTemplate(String templateId) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void sendMessage(String templateId, Map<String, String> parameters) {
	// TODO Auto-generated method stub
	
    }

}
