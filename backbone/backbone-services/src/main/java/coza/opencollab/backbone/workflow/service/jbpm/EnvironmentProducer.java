/**
 * Copyright 2015, Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package coza.opencollab.backbone.workflow.service.jbpm;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.cdi.Kjar;
import org.jbpm.services.task.audit.JPATaskLifeCycleEventListener;
import org.kie.api.task.TaskLifeCycleEventListener;
import org.kie.api.task.UserGroupCallback;

import coza.opencollab.backbone.qualifiers.BackboneQualifier;

@ApplicationScoped
public class EnvironmentProducer {

    @PersistenceUnit(unitName = "org.jbpm.domain")
    private EntityManagerFactory emf;

    @Inject
    @BackboneQualifier
    private UserGroupCallback userGroupCallback;

    @Inject
    @Kjar
    private Instance<DeploymentService> deploymentService;

    @Produces
    public EntityManagerFactory produceEntityManagerFactory() {
	if (this.emf == null) {
	    this.emf = Persistence.createEntityManagerFactory("org.jbpm.domain");
	}
	return this.emf;
    }

    @Produces
    public UserGroupCallback produceSelectedUserGroupCalback() {
	return userGroupCallback;
    }

    @Produces
    public DeploymentService produceDeploymentService() {
	return deploymentService.select(new AnnotationLiteral<Kjar>() {
	}).get();
    }

    @Produces
    public TaskLifeCycleEventListener produceAuditListener() {
	return new JPATaskLifeCycleEventListener(true);
    }

}
