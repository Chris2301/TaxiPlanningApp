package nl.qien.taxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.qien.taxi.domain.Taxi;

@Service
@Transactional
public class TaxiService {
	
	@Autowired
	private TaxiRepository taxiRepository;
	
	public Taxi save(Taxi t) {
		return taxiRepository.save(t);
	}
	public Taxi findById(long id) {
		return taxiRepository.findOne(id);	
	}
	public Iterable <Taxi> findAll() {
		Iterable <Taxi> result = taxiRepository.findAll();
		return result;
	}
	

}
