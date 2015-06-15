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

package coza.opencollab.backbone;

import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.jbpm.kie.services.impl.KModuleDeploymentUnit;
import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.api.model.DeploymentUnit;
import org.jbpm.services.cdi.Kjar;
import org.kie.internal.runtime.cdi.BootOnLoad;

import coza.opencollab.backbone.configuration.Backbone;
import coza.opencollab.backbone.configuration.Deployment;
import coza.opencollab.backbone.configuration.service.ConfigurationService;
import coza.opencollab.backbone.data.DataLoaderCallback;
import coza.opencollab.backbone.data.JsonDataLoader;
import coza.opencollab.backbone.type.Type;
import coza.opencollab.backbone.type.service.TypeService;

/**
 * 
 * @author SW Genis
 * 
 */
@ApplicationScoped
@BootOnLoad
public class StartupBean {

    @Inject
    @Kjar
    DeploymentService deploymentService;

    @Inject
    private TypeService typeService;
    
    @Inject 
    private ConfigurationService configurationService;

    private JsonDataLoader<Type> typeDataLoader;

    @PostConstruct
    public void init() {
	try {

	    // Read the main configuration file.
	    InputStream is = StartupBean.class.getClassLoader().getResourceAsStream("backbone.xml");
	    JAXBContext jaxbContext = JAXBContext.newInstance(Backbone.class);

	    // Unmarshall xml to java object.
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    Backbone backbone = (Backbone) jaxbUnmarshaller.unmarshal(is);

	    // Deploy.
	    for (Deployment deployment : backbone.getDeployments()) {

		// Deploy the deployment unit if workflow is enabled.
		if(deployment.isWorkflowEnabled()){		    
		    DeploymentUnit deploymentUnit = new KModuleDeploymentUnit(deployment.getGroupId(),
			    deployment.getArtifactId(), deployment.getVersion());
		    deploymentService.deploy(deploymentUnit);
		}

		// Load types from source file.
		if (deployment.getTypeSourceFile() != null) {
		    try {
			getTypeDataLoader().loadData(deployment.getTypeSourceFile());
		    } catch (Exception e) {
			throw new RuntimeException("Unable to load types for source file "
				+ deployment.getTypeSourceFile(), e);
		    }
		}

		configurationService.register(deployment);

	    }

	} catch (JAXBException e) {
	    e.printStackTrace();
	}

    }

    private JsonDataLoader<Type> getTypeDataLoader() {
	if (typeDataLoader == null) {
	    typeDataLoader = new JsonDataLoader<Type>(Type.class);
	    typeDataLoader.setCallback(new DataLoaderCallback<Type>() {

		@Override
		public void loadElement(Type t) {
		    try {
			typeService.insertType(t);
		    } catch (Exception e) {
			throw new RuntimeException("Unable to load types for sub deployment.", e);
		    }

		}
	    });

	}
	return typeDataLoader;
    }

}
