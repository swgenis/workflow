package za.ac.nwu.workflow.leave.service;

import javax.inject.Inject;

import org.junit.Test;

import za.ac.nwu.workflow.leave.LeaveApplication;

public class LeaveServiceTest {
	
	@Inject
	private LeaveService leaveService;
	
	@Test
	public void testGetLeaveApplicationById(){
		LeaveApplication application = leaveService.getLeaveApplicattionById("leave.application.1");
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
