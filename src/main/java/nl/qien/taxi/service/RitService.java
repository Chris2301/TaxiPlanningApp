package nl.qien.taxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.qien.taxi.domain.Rit;

@Service
@Transactional
public class RitService {
	
	@Autowired
	private RitRepository ritRepository;
	
	public Rit save(Rit rit) {
		return ritRepository.save(rit);
	}
	public Rit findById(long id) {
		return ritRepository.findOne(id);
	}
	public Iterable<Rit> findAll(){
		Iterable<Rit> result = ritRepository.findAll();
		return result;
	}
	

}
