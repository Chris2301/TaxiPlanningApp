package nl.qien.taxi.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.qien.taxi.customSelection.TaxiNaamPlusRitInfo;
import nl.qien.taxi.domain.Taxi;
import nl.qien.taxi.repository.TaxiRepository;

@Service
@Transactional
public class TaxiService {
	
	@Autowired
	private TaxiRepository taxiRepository;
	
	//CRUD//////////////////////////////////////////////////////
	
	//CREATE/UPDATE
	public Taxi save(Taxi t) {
		return taxiRepository.save(t);
	}
	
	public void update(Taxi taxi, final long id) {
		taxi.setId(id);
		taxiRepository.save(taxi);
	}
	
	//SOFT DELETE
	public void delete(final long id) {
		Taxi taxi = findById(id);
		taxi.setDeleteFlag(true);
		taxiRepository.save(taxi);
	}
	
	//READ (GET ONE/ALL)
	public Taxi findById(Long id) {
		Taxi taxi = taxiRepository.findOne(id);
		return taxi;
	}
	public Iterable <Taxi> findAll() {
		Iterable <Taxi> result = taxiRepository.findAll();
		return result;
	}
	
	public Collection<Taxi> findByAutoType(String typeAuto) {
		return taxiRepository.findByTypeAuto(typeAuto);
	}

	public Collection<TaxiNaamPlusRitInfo> lookupByName(final String name) {
		return taxiRepository.findByChauffeurNaam(name);
	}
	

}
