package nl.qien.taxi.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Path("test")
@Component
public class TestEndpoint {
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEvenementen() {
		return Response.ok("Hello World").build();
	}
	
}
