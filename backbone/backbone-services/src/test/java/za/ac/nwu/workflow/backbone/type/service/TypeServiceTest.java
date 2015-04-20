package za.ac.nwu.workflow.backbone.type.service;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.ac.nwu.workflow.backbone.type.service.impl.TypeServiceMapImpl;

@RunWith(Arquillian.class)
public class TypeServiceTest {
	
	@Inject
	private TypeService typeService;
	
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClass(TypeServiceMapImpl.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
	
	@Test
	public void testGetTypeById(){
		Type type = typeService.getTypeByKey("type.1");
		Assert.assertNotNull(type);
	}
	
	@Test
	public void testInsertLeaveApplication(){
		
	}
	
	@Test
	public void testUpdateLeaveApplication(){
		
	}
	
	@Test
	public void testDeleteLeaveApplication(){
		
	}

	@Test
	public void testSearchApplication(){
		
	}
}
