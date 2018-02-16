package nl.qien.taxi.api;

	import javax.ws.rs.Consumes;
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.Path;
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

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response listAll() {
			Iterable<Rit> ritten=ritService.findAll();
			return Response.ok(ritten).build();
		}
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public Response postRit(Rit rit){
			Rit result = ritService.save(rit);
			return Response.accepted(result.getId()).build();	
		}

}
