package za.ac.nwu.workflow.pay.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.ac.nwu.workflow.pay.PayAdviceForm;
import coza.opencollab.backbone.Message;

/**
 * Handles requests for the pay advice home page.
 */
@Path("/pay")
public class PayRestServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(PayRestServiceImpl.class);

    @GET
    @Path("/email")
    @Produces({ "application/json" })
    public Message emailPayAdvice(PayAdviceForm form) {
	logger.info("Emailing pay advice.");
	return new Message("Your pay advice has been emailed.");
    }

    @GET
    @Path("/form")
    @Produces({ "application/json" })
    public Message getPayAdvice(PayAdviceForm form) {
	logger.info("Retrieving pay advice.");
	return new Message("You have succesfully applied for leave");
    }

    @GET
    @Path("/pdf")
    @Produces({ "application/pdf" })
    public Response getPayAdvicePdf(PayAdviceForm form) {
	byte[] pdf = new byte[0];
	ResponseBuilder response = Response.ok((Object) pdf);
	return response.build();
    }

}
