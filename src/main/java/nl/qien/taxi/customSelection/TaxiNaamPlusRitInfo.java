package nl.qien.taxi.customSelection;

import java.util.Date;

public interface TaxiNaamPlusRitInfo {

	// Hier hebben we op de Hibernate manier een selectie gemaakt, de eerste getter
	// bepaald uit welke class je gaat kiezen en dan zul je voor andere classes een
	// subinterface moeten maken om de getters aan te roepen...
	
	// dit implementeer je daarna in de repository en trek je door naar de service en endpoint
	
	String getChauffeurNaam();
	Rit getRitten();

	interface Rit {
		
		Date getDate();
		String getPlaats();
	}
}
