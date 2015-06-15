package za.ac.nwu.workflow.pay.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.ac.nwu.workflow.pay.PayAdvice;
import coza.opencollab.backbone.Message;

/**
 * Handles requests for the application home page.
 */
@Path("/pay")
public class PayRestServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(PayRestServiceImpl.class);

    @GET
    @Path("/show")
    @Produces({ "application/json" })
    public Message getPayAdvice(PayAdvice leaveApplication) {
	return new Message("You have succesfully applied for leave");
    }

}
