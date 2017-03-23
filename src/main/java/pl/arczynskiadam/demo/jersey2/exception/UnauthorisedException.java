package pl.arczynskiadam.demo.jersey2.exception;

import pl.arczynskiadam.demo.jersey2.dto.ErrorDTO;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

public class UnauthorisedException extends WebApplicationException {
    public UnauthorisedException(String msg) {
        super(Response
                .status(UNAUTHORIZED)
                .entity(new ErrorDTO(msg, Integer.toString(UNAUTHORIZED.getStatusCode()))).type(MediaType.APPLICATION_JSON)
                .build()
        );
    }
}
