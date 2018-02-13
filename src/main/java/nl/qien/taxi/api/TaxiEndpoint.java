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
import org.springframework.stereotype.Controller;

import nl.qien.taxi.domain.Taxi;
import nl.qien.taxi.service.TaxiService;

@Path("taxi")
@Controller
public class TaxiEndpoint {
	
	@Autowired
	private TaxiService taxiService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		Iterable<Taxi> taxis=taxiService.findAll();
		return Response.ok(taxis).build();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postTrein(Taxi taxi){
		Taxi result = taxiService.save(taxi);
		return Response.accepted(result.getId()).build();	
	}

	
}
