package nl.qien.taxi.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.qien.taxi.domain.Test;

@Component
public interface TestRepository extends CrudRepository <Test, Long>{

}
