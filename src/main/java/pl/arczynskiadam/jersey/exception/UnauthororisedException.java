package pl.arczynskiadam.jersey.exception;

import pl.arczynskiadam.jersey.dto.ErrorDTO;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

public class UnauthororisedException extends WebApplicationException {
    public UnauthororisedException(String msg) {
        super(Response
                .status(UNAUTHORIZED)
                .entity(new ErrorDTO(msg, Integer.toString(UNAUTHORIZED.getStatusCode()))).type(MediaType.APPLICATION_JSON)
                .build()
        );
    }
}
