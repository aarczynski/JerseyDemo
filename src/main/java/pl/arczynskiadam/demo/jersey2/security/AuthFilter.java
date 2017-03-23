package pl.arczynskiadam.demo.jersey2.security;

import pl.arczynskiadam.demo.jersey2.dao.FakeUserDao;
import pl.arczynskiadam.demo.jersey2.exception.UnauthorisedException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class AuthFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext request) throws WebApplicationException {

        String method = request.getMethod();
        String path = request.getUriInfo().getPath(true);

        if(method.equals("GET") && (path.equals("application.wadl") || path.equals("application.wadl/xsd0.xsd"))) {
            return;
        }

        String auth = request.getHeaderString("authorization");
        if(auth == null) {
            throw new UnauthorisedException("Missing credentials");
        }

        String[] loginAndPassword = BasicAuth.decode(auth);
        if(loginAndPassword == null || loginAndPassword.length != 2){
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }

        User currentUser = FakeUserDao.findUserByName(loginAndPassword[0]);
        if(currentUser == null) {
            throw new UnauthorisedException("Invalid credentials");
        }

        String scheme = request.getUriInfo().getRequestUri().getScheme();
        request.setSecurityContext(new CustomSecurityContext(currentUser, scheme));
    }
}