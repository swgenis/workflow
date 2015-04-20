package za.ac.nwu.workflow.leave.service;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.ac.nwu.workflow.leave.LeaveApplication;
import za.ac.nwu.workflow.leave.service.impl.LeaveMockDataLoader;

@RunWith(Arquillian.class)
public class LeaveServiceTest {
	
	@Inject
	private LeaveService leaveService;
	
	@Test
	public void testGetLeaveApplicationById(){
		//LeaveApplication application = leaveService.getLeaveApplicationById(LeaveMockDataLoader.APPLICATION1_ID);
		//assertNotNull(application);
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
