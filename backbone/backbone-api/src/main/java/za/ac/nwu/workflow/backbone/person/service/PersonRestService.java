package za.ac.nwu.workflow.backbone.person.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import za.ac.nwu.workflow.backbone.person.Person;

/**
 * 
 * @author SW Genis
 * 
 */
public interface PersonRestService {

    @GET
    @Path("/search")
    @Produces({ "application/json" })
    public List<Person> search(@QueryParam("name") String name, @QueryParam("surname") String surname) throws Exception;

    @GET
    @Path("/lookup")
    @Produces({ "application/json" })
    public Person getPerson(@QueryParam("personLookupId") String personLookupId);

}
