package org.kzac.core.person.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import org.kzac.core.person.dto.PersonInfo;
import org.kzac.exceptions.DoesNotExistException;
import org.kzac.exceptions.InvalidParameterException;
import org.kzac.exceptions.MissingParameterException;
import org.kzac.exceptions.OperationFailedException;
import org.kzac.exceptions.PermissionDeniedException;

/**
 * 
 * @author SW Genis
 * 
 */
@Path("/person")
public interface PersonRestService {

    @GET
    @Path("/search")
    @Produces({ "application/json" })
    public List<PersonInfo> search(@QueryParam("name") String name, @QueryParam("surname") String surname,
	    @Context SecurityContext context) throws DoesNotExistException, InvalidParameterException,
	    MissingParameterException, OperationFailedException, PermissionDeniedException;

    @GET
    @Path("/lookup")
    @Produces({ "application/json" })
    public PersonInfo getPerson(@QueryParam("personId") String personId, @Context SecurityContext context)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException;

}
