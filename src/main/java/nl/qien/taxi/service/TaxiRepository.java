package nl.qien.taxi.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.qien.taxi.domain.Taxi;

@Component
public interface TaxiRepository extends CrudRepository <Taxi, Long>{

}
