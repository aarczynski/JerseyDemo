package pl.arczynskiadam.jersey.exception;

import pl.arczynskiadam.jersey.dto.ErrorDTO;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MyIllegalArgumentException extends WebApplicationException {
    public MyIllegalArgumentException(String msg) {
        super(Response.status(400).entity(new ErrorDTO(msg, "400")).type(MediaType.APPLICATION_JSON).build());
    }
}
