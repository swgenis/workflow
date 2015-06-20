package coza.opencollab.backbone.workflow.service;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import coza.opencollab.backbone.authorization.service.impl.AuthorizationServiceMapImpl;
import coza.opencollab.backbone.organization.service.impl.OrganizationServiceMapImpl;
import coza.opencollab.backbone.workflow.service.jbpm.BackboneIdentityProvider;
import coza.opencollab.backbone.workflow.service.jbpm.BackboneUserGroupCallback;
import coza.opencollab.backbone.workflow.service.jbpm.EnvironmentProducer;
import coza.opencollab.backbone.workflow.service.jbpm.WorkflowServiceJbpmImpl;

@RunWith(Arquillian.class)
public class WorkflowServiceTest {

    @Inject
    private WorkflowService workflowService;

    @Deployment
    public static JavaArchive createDeployment() {
	return ShrinkWrap.create(JavaArchive.class).addClass(WorkflowServiceJbpmImpl.class)
		.addClass(EnvironmentProducer.class).addClass(BackboneUserGroupCallback.class)
		.addClass(BackboneIdentityProvider.class).addClass(AuthorizationServiceMapImpl.class)
		.addClass(OrganizationServiceMapImpl.class).addPackage("org.jbpm.services.cdi.impl")
		.addPackage("org.jbpm.services.cdi.impl.manager").addPackage("org.jbpm.services.task")
		.addPackage("org.kie.internal.task.api").addPackage("org.kie.internal.task.service")
		.addPackage("org.kie.api.runtime.manager").addPackage("org.kie.internal.runtime.manager")
		.addPackage("org.jbpm.runtime.manager.impl").addPackage("org.jbpm.shared.services.impl")
		.addPackage("org.jbpm.services.cdi.producer").addPackage("org.jbpm.kie.services.cdi.producer")
		.addPackage("org.jbpm.kie.services.api.bpmn2")
		.addAsManifestResource("META-INF/beans.xml", ArchivePaths.create("beans.xml"));

    }

    @Test
    public void testWorkflowProcess() {
	assertNotNull(workflowService);
    }

}
