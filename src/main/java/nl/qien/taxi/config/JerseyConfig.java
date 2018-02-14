package nl.qien.taxi.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;


@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig(){
		
		// scan the resources package for our resources
        packages(getClass().getPackage().getName().replace("config", "api"));

	}
}
