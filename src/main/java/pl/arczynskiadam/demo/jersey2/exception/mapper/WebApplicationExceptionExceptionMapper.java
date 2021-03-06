package pl.arczynskiadam.demo.jersey2.exception.mapper;

import pl.arczynskiadam.demo.jersey2.dto.ErrorDTO;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.FORBIDDEN;

@Provider
public class WebApplicationExceptionExceptionMapper implements ExceptionMapper<ForbiddenException> {

    @Override
    public Response toResponse(ForbiddenException  ex) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new ErrorDTO(FORBIDDEN.getReasonPhrase(), Integer.toString(FORBIDDEN.getStatusCode())))
                .build();
    }
}
