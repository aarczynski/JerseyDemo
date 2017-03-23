package pl.arczynskiadam.demo.jersey2.exception;

import pl.arczynskiadam.demo.jersey2.dto.ErrorDTO;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

public class MyIllegalArgumentException extends WebApplicationException {
    public MyIllegalArgumentException(String msg) {
        super(Response
                .status(BAD_REQUEST)
                .entity(new ErrorDTO(msg, Integer.toString(BAD_REQUEST.getStatusCode())))
                .type(MediaType.APPLICATION_JSON)
                .build()
        );
    }
}
