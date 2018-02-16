package nl.qien.taxi.service;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.qien.taxi.domain.Taxi;

@Component
public interface TaxiRepository extends CrudRepository <Taxi, Long>{

	
	//show alle ritten findByAutoType
	List<Taxi> findByTypeAuto(final String typeAuto);
	
}
