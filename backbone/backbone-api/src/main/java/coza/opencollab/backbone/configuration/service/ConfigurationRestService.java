package coza.opencollab.backbone.configuration.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.kzac.core.person.dto.PersonInfo;
import org.kzac.exceptions.DoesNotExistException;
import org.kzac.exceptions.InvalidParameterException;
import org.kzac.exceptions.MissingParameterException;
import org.kzac.exceptions.OperationFailedException;
import org.kzac.exceptions.PermissionDeniedException;

import coza.opencollab.backbone.configuration.ApplicationCategory;
import coza.opencollab.backbone.configuration.ConfigProperties;

@Path("/config")
public interface ConfigurationRestService {
    
    @GET
    @Path("/properties")
    @Produces({ "application/json" })
    public ConfigProperties getConfiguration();

    @GET
    @Path("/brand")
    @Produces("image/*")
    public Response getBrandImage();

    @GET
    @Path("/principal")
    @Produces({ "application/json" })
    public PersonInfo getPrincipal(@Context SecurityContext context) throws DoesNotExistException,
	    InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException;

    @GET
    @Path("/applications")
    @Produces({ "application/json" })
    public List<ApplicationCategory> getApplications();

}
