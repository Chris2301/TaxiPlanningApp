package nl.qien.taxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.qien.taxi.domain.Rit;
import nl.qien.taxi.repository.RitRepository;

@Service
@Transactional
public class RitService {
	
	@Autowired
	private RitRepository ritRepository;
	
	//Create/Update
	public Rit save(Rit rit) {
		return ritRepository.save(rit);
	}
	
	public void update(Rit rit, final long id) {
		rit.setId(id);
		ritRepository.save(rit);
	}
	
	// SOFT DELETE
	public void delete(final long id) {
		Rit rit = findById(id);
		rit.setDeleteFlag(true);
		ritRepository.save(rit);
	}
	
	
	//READ (GET ONE/ALL)
	public Rit findById(long id) {
		return ritRepository.findOne(id);
	}
	public Iterable<Rit> findAll(){
		Iterable<Rit> result = ritRepository.findAll();
		return result;
	}
	

}
