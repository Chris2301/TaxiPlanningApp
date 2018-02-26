package nl.qien.taxi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import nl.qien.taxi.domain.Rit;

@Repository
public interface RitRepository extends CrudRepository <Rit, Long>{

}
