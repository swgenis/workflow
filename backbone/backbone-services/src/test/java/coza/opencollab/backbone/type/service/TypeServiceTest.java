package coza.opencollab.backbone.type.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import coza.opencollab.backbone.organization.service.OrganizationServiceConstants;
import coza.opencollab.backbone.type.Type;
import coza.opencollab.backbone.type.service.TypeService;
import coza.opencollab.backbone.type.service.impl.TypeServiceMapImpl;

@RunWith(Arquillian.class)
public class TypeServiceTest {

    @Inject
    private TypeService typeService;

    @Deployment
    public static JavaArchive createDeployment() {
	return ShrinkWrap.create(JavaArchive.class).addClass(TypeServiceMapImpl.class)
		.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testGetTypeByKey() {
	Type type = typeService.getTypeByKey(OrganizationServiceConstants.TYPE_ORGUNIT_CAMPUS);
	assertNotNull(type);
    }

    @Test
    public void testGetTypeByCategory() throws Exception {
	List<Type> types = typeService.getTypesByCategory(OrganizationServiceConstants.CATEGORY_ORGUNIT_TYPES);
	assertNotNull(types);
    }

    @Test
    public void testInsertType() {

    }

    @Test
    public void testUpdateType() {

    }

    @Test
    public void testDeleteType() {

    }

}
