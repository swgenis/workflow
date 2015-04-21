package za.ac.nwu.workflow.backbone.type;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.ac.nwu.workflow.backbone.type.service.Type;
import za.ac.nwu.workflow.backbone.type.service.TypeService;

@Stateless
@Path("/type")
public class TypeRestServiceImpl {

	private static final Logger logger = LoggerFactory
			.getLogger(TypeRestServiceImpl.class);

	@Inject
	private TypeService typeService;

	@GET
	@Path("/category/{category}")
	@Produces({ "application/json" })
	public List<Type> search(@PathParam("category") String category)
			throws Exception {
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
