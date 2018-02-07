package nl.qien.taxi.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.qien.taxi.domain.Test;
import nl.qien.taxi.service.TestService;

@Path("test")
@Component
public class TestEndpoint {
		
	@Autowired
	private TestService testService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Test> treinen = testService.findAll();
		return Response.ok(treinen).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postTrein(Test trein){
		Test result = testService.save(trein);
		return Response.accepted(result.getId()).build();	
	}
	
}
