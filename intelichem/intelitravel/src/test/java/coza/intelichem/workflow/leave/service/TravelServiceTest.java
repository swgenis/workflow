package coza.intelichem.workflow.leave.service;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import coza.intelichem.workflow.travel.Itinerary;
import coza.intelichem.workflow.travel.service.TravelService;
import coza.intelichem.workflow.travel.service.impl.TravelServiceMapImpl;

@RunWith(Arquillian.class)
public class TravelServiceTest {

    @Inject
    private TravelService travelService;

    @Deployment
    public static JavaArchive createDeployment() {
	return ShrinkWrap.create(JavaArchive.class).addClass(TravelServiceMapImpl.class)
		.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testGetLeaveApplicationById() {
	Itinerary record = travelService.getItineraryById("1");
	assertNotNull(record);
    }

    @Test
    public void testInsertLeaveApplication() throws Exception {
	Itinerary record = new Itinerary();
	record.setId("application.test");
	record.setApplicantId("test");
	travelService.insertItinerary(record);
	Itinerary insertRecord = travelService.getItineraryById("application.test");
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
