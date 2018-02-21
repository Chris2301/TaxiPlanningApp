package nl.qien.taxi.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.qien.taxi.domain.Rit;
import nl.qien.taxi.service.RitService;

@Path("rit")
@Component
public class RitEndpoint {

	@Autowired
	private RitService ritService;

	//GET ALL
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		Iterable<Rit> ritten = ritService.findAll();
		return Response.ok(ritten).build();
	}
	
	// Get ONE
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listOne(@PathParam("id")final long id) {
		Rit rit = ritService.findById(id);
		return Response.ok(rit).build();
	}

	// Create
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postRit(Rit rit) {
		Rit result = ritService.save(rit);
		return Response.accepted(result.getId()).build();
	}

	// Update
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTaxi(final Rit rit, @PathParam("id") final long id) {
		ritService.update(rit, id);
		return Response.noContent().build();
	}

	// DELETE
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteTaxi(@PathParam("id") final long id) {
		ritService.delete(id);
		return Response.noContent().build();
	}

}
