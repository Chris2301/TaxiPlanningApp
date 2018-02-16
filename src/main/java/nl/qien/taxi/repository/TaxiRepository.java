package nl.qien.taxi.repository;


import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.qien.taxi.customSelection.TaxiNaamPlusRitInfo;
import nl.qien.taxi.domain.Taxi;

@Component
public interface TaxiRepository extends CrudRepository <Taxi, Long>{

	
	//show alle ritten findByAutoType
	Collection<Taxi> findByTypeAuto(final String typeAuto);
	
	Collection<TaxiNaamPlusRitInfo> findByChauffeurNaam(final String naam);
	
}
