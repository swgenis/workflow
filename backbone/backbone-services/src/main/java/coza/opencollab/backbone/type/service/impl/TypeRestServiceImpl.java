package coza.opencollab.backbone.type.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import coza.opencollab.backbone.type.Type;
import coza.opencollab.backbone.type.service.TypeRestService;
import coza.opencollab.backbone.type.service.TypeService;

@Path("/type")
public class TypeRestServiceImpl implements TypeRestService {

    private static final Logger logger = LoggerFactory.getLogger(TypeRestServiceImpl.class);

    @Inject
    private TypeService typeService;

    @GET
    @Path("/category/{category}")
    @Produces({ "application/json" })
    public List<Type> search(@PathParam("category") String category) throws Exception {
	logger.info("Retrieving types for " + category);
	return typeService.getTypesByCategory(category);
    }

    @GET
    @Path("/{key}")
    @Produces({ "application/json" })
    public Type getType(@PathParam("key") String key) {
	logger.info("Retrieving type: " + key);
	return typeService.getTypeByKey(key);
    }

}
