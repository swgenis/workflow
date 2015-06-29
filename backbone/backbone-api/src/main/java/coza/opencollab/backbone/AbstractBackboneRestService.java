package coza.opencollab.backbone;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractBackboneRestService {

    private static final Logger logger = LoggerFactory.getLogger(AbstractBackboneRestService.class);

    @GET
    @Path("/html/{file}")
    @Produces("text/html")
    public Response getHtmlTemplate(@PathParam("file") String htmlFile, @Context UriInfo uriInfo) {
	
	logger.info(uriInfo.getPath());
	logger.info(uriInfo.getAbsolutePath().toString());
	
	// Get file from resources folder
	InputStream is = AbstractBackboneRestService.class.getResourceAsStream(htmlFile);
	byte[] bytes;
	try {
	    bytes = IOUtils.toByteArray(is);
	    ResponseBuilder response = Response.ok((Object) bytes);
	    return response.build();
	} catch (IOException e) {
	    logger.error("Unable to load resoure.", e);
	}
	return null;
    }

}
