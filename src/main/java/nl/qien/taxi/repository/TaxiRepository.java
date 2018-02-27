package nl.qien.taxi.repository;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nl.qien.taxi.customSelection.TaxiNaamPlusRitInfo;
import nl.qien.taxi.domain.Taxi;

@Repository
public interface TaxiRepository extends CrudRepository <Taxi, Long>{

	
	//show alle ritten findByAutoType
	Collection<Taxi> findByTypeAuto(final String typeAuto);
	
	Collection<TaxiNaamPlusRitInfo> findByChauffeurNaam(final String naam);
	
	@Query(value="SELECT taxi_id FROM taxi_x_rit WHERE rit_id = :rit_id", nativeQuery=true)
	Long getTaxiIdFromJoinTable(@Param("rit_id") final long ritId);
	
	
	
}
