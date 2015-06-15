package za.ac.nwu.workflow.backbone.type.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.ac.nwu.workflow.backbone.type.Type;
import za.ac.nwu.workflow.backbone.type.service.TypeRestService;
import za.ac.nwu.workflow.backbone.type.service.TypeService;

/**
 * A REST service to retrieve types
 */
@Path("/type")
public class TypeRestServiceImpl implements TypeRestService {

	private static final Logger LOG = LoggerFactory.getLogger(TypeRestServiceImpl.class);

	@Inject
	private TypeService typeService;

	@GET
	@Path("/category/{category}")
	@Produces({ "application/json" })
	public List<Type> search(@PathParam("category") String category) throws Exception {
		LOG.info("Retrieving types for " + category);
		return typeService.getTypesByCategory(category);
	}

	@GET
	@Path("/{key}")
	@Produces({ "application/json" })
	public Type getType(@PathParam("key") String key) {
		LOG.info("Retrieving type: " + key);
		return typeService.getTypeByKey(key);
	}

}
