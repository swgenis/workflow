package za.ac.nwu.workflow;

import java.util.Collections;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.cdi.Kjar;
import org.jbpm.services.task.identity.DefaultUserInfo;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.manager.RuntimeEnvironment;
import org.kie.api.runtime.manager.RuntimeEnvironmentBuilder;
import org.kie.api.task.UserGroupCallback;
import org.kie.internal.identity.IdentityProvider;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.manager.cdi.qualifier.PerProcessInstance;
import org.kie.internal.runtime.manager.cdi.qualifier.PerRequest;
import org.kie.internal.runtime.manager.cdi.qualifier.Singleton;
import org.kie.internal.task.api.UserInfo;

/**
 * CDI producer that provides all required beans for the execution.
 * 
 * 
 */
@ApplicationScoped
public class EnvironmentProducer {

	@PersistenceUnit(unitName = "org.jbpm.domain")
	private EntityManagerFactory emf;

	@Inject
	@Backbone
	private UserGroupCallback userGroupCallback;

	@Inject
	@Kjar
	private DeploymentService deploymentService;

	@Produces
	public EntityManagerFactory getEntityManagerFactory() {
		return this.emf;
	}

	@Produces
	@Singleton
	@PerProcessInstance
	@PerRequest
	public RuntimeEnvironment produceEnvironment(EntityManagerFactory emf) {
		RuntimeEnvironment environment = RuntimeEnvironmentBuilder.Factory
				.get()
				.newDefaultBuilder()
				.entityManagerFactory(emf)
				.addAsset(
						ResourceFactory
								.newClassPathResource("leave-application.bpmn2"),
						ResourceType.BPMN2).get();
		return environment;
	}

	@Produces
	public UserGroupCallback produceSelectedUserGroupCalback() {
		return userGroupCallback;
	}

	@Produces
	public UserInfo produceUserInfo() {
		// default implementation will load userinfo.properties file on the
		// classpath
		return new DefaultUserInfo(true);
	}

	// @Produces
	// @Named("Logs")
	// public TaskLifeCycleEventListener produceTaskAuditListener() {
	// return new JPATaskLifeCycleEventListener(true);
	// }

	@Produces
	public DeploymentService getDeploymentService() {
		return this.deploymentService;
	}

	@Produces
	public IdentityProvider produceIdentityProvider() {
		return new IdentityProvider() {

			@Override
			public String getName() {
				return "me";
			}

			@Override
			public List<String> getRoles() {
				return Collections.emptyList();
			}

			@Override
			public boolean hasRole(String arg0) {
				return false;
			}
		};

	}

}