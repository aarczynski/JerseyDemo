package pl.arczynskiadam.jersey.rest;

import pl.arczynskiadam.jersey.dto.ItemDTO;
import pl.arczynskiadam.jersey.exception.MyIllegalArgumentException;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class JSONService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTrackInJSON2(@Valid @QueryParam("p") Param p) throws MyIllegalArgumentException {

		if (p == null) {
			throw new MyIllegalArgumentException("p param is mandatory");
		}

		ItemDTO item = new ItemDTO();
		item.setValue(p.getVal());

		return Response.status(200).entity(item).build();
	}
}