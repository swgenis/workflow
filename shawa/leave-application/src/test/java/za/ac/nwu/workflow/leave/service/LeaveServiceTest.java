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

import com.google.common.collect.ImmutableSet;

import za.ac.nwu.workflow.leave.LeaveRecord;
import za.ac.nwu.workflow.leave.service.impl.LeaveMockDataLoader;
import za.ac.nwu.workflow.leave.service.impl.LeaveServiceMapImpl;

@RunWith(Arquillian.class)
public class LeaveServiceTest {

    @Inject
    private LeaveService leaveService;

    @Deployment
    public static JavaArchive createDeployment() {
	return ShrinkWrap.create(JavaArchive.class).addClass(LeaveServiceMapImpl.class)
		.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testGetLeaveApplicationById() {
	LeaveRecord record = leaveService.getLeaveRecordById(LeaveMockDataLoader.RECORD1_ID);
	assertNotNull(record);
    }

    @Test
    public void testInsertLeaveApplication() throws Exception {
	LeaveRecord record = new LeaveRecord();
	record.setId("application.test");
	record.setApplicantId("test");
	leaveService.insertLeaveRecord(record);
	LeaveRecord insertRecord = leaveService.getLeaveRecordById("application.test");
	assertNotNull(insertRecord);
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
