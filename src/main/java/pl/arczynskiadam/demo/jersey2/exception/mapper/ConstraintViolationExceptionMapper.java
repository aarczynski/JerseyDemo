package pl.arczynskiadam.demo.jersey2.exception.mapper;

import pl.arczynskiadam.demo.jersey2.dto.ErrorDTO;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException ex) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new ErrorDTO(
                        ex.getConstraintViolations().stream().findFirst().get().getMessage(),
                        Integer.toString(Response.Status.BAD_REQUEST.getStatusCode()))
                )
                .build();
    }
}
