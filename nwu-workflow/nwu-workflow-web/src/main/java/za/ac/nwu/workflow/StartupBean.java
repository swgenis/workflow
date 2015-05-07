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

package za.ac.nwu.workflow;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import za.ac.nwu.workflow.backbone.person.service.PersonService;

/**
 * 
 * @author SW Genis
 * 
 */
@ApplicationScoped
public class StartupBean {

    @PostConstruct
    public void init() throws NamingException {
	// Get the Weld BeanManager
	InitialContext initialContext = new InitialContext();
	BeanManager bm = (BeanManager) initialContext.lookup("java:comp/BeanManager");

	// List all CDI Managed Beans and their EL-accessible name
	Set<Bean<?>> beans = bm.getBeans(PersonService.class, new AnnotationLiteral<Any>() {
	});

    }

}
