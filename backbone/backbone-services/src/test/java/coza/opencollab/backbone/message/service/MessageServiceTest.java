package coza.opencollab.backbone.message.service;

import java.util.Map;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import coza.opencollab.backbone.message.MessageTemplate;
import coza.opencollab.backbone.message.service.impl.MessageServiceMapImpl;
import coza.opencollab.backbone.qualifiers.MapService;

@RunWith(Arquillian.class)
public class MessageServiceTest {

    @Inject
    @MapService
    private MessageService messageService;

    @Deployment
    public static JavaArchive createDeployment() {
	return ShrinkWrap.create(JavaArchive.class).addClass(MessageServiceMapImpl.class)
		.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testgetMessageTemplate(String templateId) {
	// TODO: implement test
    }

    @Test
    public void testinsertMessageTemplate(MessageTemplate template) {
	// TODO: implement test
    }

    @Test
    public void testupdateMessageTemplate(MessageTemplate template) {
	// TODO: implement test
    }

    @Test
    public void testdeleteMessageTemplate(String templateId) {
	// TODO: implement test
    }

    @Test
    public void testsendMessage(String templateId, Map<String, String> parameters) {
	// TODO: implement test
    }

}
