package nl.qien.taxi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.qien.taxi.domain.Rit;

@Component
public interface RitRepository extends CrudRepository <Rit, Long>{

}