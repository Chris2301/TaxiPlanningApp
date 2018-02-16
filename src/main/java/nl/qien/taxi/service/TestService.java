package nl.qien.taxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.qien.taxi.domain.Test;
import nl.qien.taxi.repository.TestRepository;



@Service
@Transactional
public class TestService {
	
	@Autowired
	private TestRepository testRepository;

	public Test save(Test test){
		return testRepository.save(test);
	}
	
	public Test findById(Long id) {
		return testRepository.findOne(id);
	}

	public Iterable <Test> findAll(){
		Iterable <Test> result = testRepository.findAll();
		return result;
	}
}
