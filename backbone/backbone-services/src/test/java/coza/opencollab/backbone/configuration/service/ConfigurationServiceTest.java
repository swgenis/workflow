package coza.opencollab.backbone.configuration.service;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import coza.opencollab.backbone.configuration.service.impl.ConfigurationServiceMapImpl;
import coza.opencollab.backbone.qualifiers.MapService;

@RunWith(Arquillian.class)
public class ConfigurationServiceTest {

    @Inject
    @MapService
    private ConfigurationService configurationService;

    @Deployment
    public static JavaArchive createDeployment() {
	return ShrinkWrap.create(JavaArchive.class).addClass(ConfigurationServiceMapImpl.class)
		.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testregister(Deployment deployment) {
	assertNotNull(configurationService);
	// TODO: implement test
    }

    @Test
    public void testgetDeployment(String id) {
	// TODO: implement test
    }

    @Test
    public void testgetDeploymentCategories() {
	// TODO: implement test
    }

    @Test
    public void testgetDeploymentsByCategory(String category) {
	// TODO: implement test
    }

}
