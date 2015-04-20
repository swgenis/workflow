package za.ac.nwu.workflow.backbone.type.service;

import javax.inject.Inject;

import org.junit.Test;

public class TypeServiceTest {
	
	@Inject
	private TypeService typeService;
	
	@Test
	public void testGetTypeById(){
		Type type = typeService.getTypeByKey("type.1");
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
