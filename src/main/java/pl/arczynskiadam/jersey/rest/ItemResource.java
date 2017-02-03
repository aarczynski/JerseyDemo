package pl.arczynskiadam.jersey.rest;

import pl.arczynskiadam.jersey.dto.ItemDTO;
import pl.arczynskiadam.jersey.exception.MyIllegalArgumentException;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/")
public class ItemResource {

	@GET
	@RolesAllowed("admin")
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItem(@Valid @QueryParam("p") Param p) throws MyIllegalArgumentException {

		if (p == null) {
			throw new MyIllegalArgumentException("p param is mandatory");
		}

		ItemDTO item = new ItemDTO();
		item.setValue(p.getVal());

		return Response.status(OK.getStatusCode()).entity(item).build();
	}
}