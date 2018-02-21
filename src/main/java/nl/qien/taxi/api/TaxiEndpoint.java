package nl.qien.taxi.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import nl.qien.taxi.domain.MailMail;
import nl.qien.taxi.domain.Taxi;
import nl.qien.taxi.service.TaxiService;

@Path("taxi")
@RestController
public class TaxiEndpoint {
	
	@Autowired
	private TaxiService taxiService;


//	@POST
//	@Path("/send/{id}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response mailInfo() {
//		Taxi taxi = 
//		return Response.
//	}
	
	// Get ALL
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		Iterable<Taxi> taxis=taxiService.findAll();
		return Response.ok(taxis).build();
	}
	
	// Get ONE
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listOne(@PathParam("id")final long id) {
		Taxi taxi = taxiService.findById(id);
		return Response.ok(taxi).build();
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postTaxi(Taxi taxi){
		Taxi result = taxiService.save(taxi);
		return Response.accepted(result.getId()).build();	
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTaxi(final Taxi taxi, @PathParam("id")final long id) {
		taxiService.update(taxi, id);
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteTaxi(@PathParam("id") final long id) {
		taxiService.delete(id);
		return Response.noContent().build();
	}
	
	@GET
	@Path("/chauffeur/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupByName(@PathParam("name") final String name) {
		return Response.ok(taxiService.lookupByName(name)).build();
	}
	
}
