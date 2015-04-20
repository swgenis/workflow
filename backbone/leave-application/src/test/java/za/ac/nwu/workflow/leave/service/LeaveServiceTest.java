package za.ac.nwu.workflow.leave.service;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import za.ac.nwu.workflow.leave.LeaveApplication;
import za.ac.nwu.workflow.leave.service.impl.LeaveMockDataLoader;
import za.ac.nwu.workflow.leave.service.impl.LeaveServiceMapImpl;

@RunWith(Arquillian.class)
public class LeaveServiceTest {

	@Inject
	private LeaveService leaveService;

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(LeaveServiceMapImpl.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	public void testGetLeaveApplicationById() {
		LeaveApplication application = leaveService
				.getLeaveApplicationById(LeaveMockDataLoader.APPLICATION1_ID);
		assertNotNull(application);
	}

	@Test
	public void testInsertLeaveApplication() throws Exception {
		LeaveApplication application = new LeaveApplication();
		application.setId("application.test");
		application.setApplicantId("test");
		leaveService.insertLeaveApplication(application);
		LeaveApplication insertApplication = leaveService
				.getLeaveApplicationById("application.test");
		assertNotNull(insertApplication);
	}

	@Test
	public void testUpdateLeaveApplication() {

	}

	@Test
	public void testDeleteLeaveApplication() {

	}

	@Test
	public void testSearchApplication() {

	}
}
