package coza.intelichem.workflow.travel.service.impl;

import javax.inject.Inject;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import coza.intelichem.workflow.travel.TravelRequest;
import coza.intelichem.workflow.travel.Itinerary;
import coza.intelichem.workflow.travel.service.TravelService;

/**
 * 
 * @author SW Genis
 * 
 */
public class TravelRequestWorkItem implements WorkItemHandler {

    private static final Logger logger = LoggerFactory.getLogger(TravelRequestWorkItem.class);

    @Inject
    private TravelService travelService;

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
	logger.info("Submitting an approved leave application");
	try {
	    Itinerary record = new Itinerary();
	    TravelRequest application = (TravelRequest) workItem.getParameter("travelRequestIn");
	    record.setApplicantId(application.getApplicantId());
	    record.setState(application.getState());
	    travelService.insertItinerary(record);
	} catch (Exception e) {
	    throw new RuntimeException("Unable to submit leave applicaiton.", e);
	}
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
	logger.info("Leave Application was aborted.");
    }

}
