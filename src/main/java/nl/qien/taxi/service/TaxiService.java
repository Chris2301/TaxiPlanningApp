package nl.qien.taxi.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.qien.taxi.customSelection.TaxiNaamPlusRitInfo;
import nl.qien.taxi.domain.Rit;
import nl.qien.taxi.domain.Taxi;
import nl.qien.taxi.repository.TaxiRepository;

@Service
@Transactional
public class TaxiService {
	
	@Autowired
	private TaxiRepository taxiRepository;
	
	@Autowired
	private RitService ritService;
	
	@Autowired
	private EntityManager em;
	
	//CRUD//////////////////////////////////////////////////////
	
	//CREATE/UPDATE
	

	public Taxi saveChauf(Taxi t) {
		return taxiRepository.save(t);
	}
	
	public Taxi saveRit(Taxi t) {	
		final Taxi newTaxi = taxiRepository.findOne(t.getId());
		if(t.getChauffeurNaam() == null || t.getChauffeurNaam().equalsIgnoreCase("")) {
			t.setChauffeurNaam(newTaxi.getChauffeurNaam());
		}
		List<Rit> ritten = newTaxi.getRitten();
		ritten.add(t.getRitten().get(0));
		t.setRitten(ritten);
		return taxiRepository.save(t);
	}
	
	//UPDATE TAXI INFO
	public void updateTaxi(Taxi taxi, final long id) {
		Taxi newTaxi = taxiRepository.findOne(id);
		newTaxi = validateTaxi(newTaxi, taxi);
		
		if (taxi.getRitten() != null && taxi.getRitten().size() > 0) {
			final Rit rit = taxi.getRitten().get(0);
			final long oldTaxiId = taxiRepository.getTaxiIdFromJoinTable(rit.getId());
			if (oldTaxiId != newTaxi.getId()) {
				deleteRit(oldTaxiId, rit.getId());
				em.flush();
				updateNewRit(newTaxi, rit);
			} else {
				ritService.save(rit);
			}
		}
		taxiRepository.save(newTaxi);
	}
	
	private Taxi validateTaxi(Taxi newTaxi, final Taxi inputTaxi) {
		if (inputTaxi.getChauffeurNaam() != null) {
			newTaxi.setChauffeurNaam(inputTaxi.getChauffeurNaam());
		}
		
		if (inputTaxi.getTypeAuto() != null) {
			newTaxi.setTypeAuto(inputTaxi.getTypeAuto());
		}
		
		if (inputTaxi.getEmailChauffeur() != null) {
			newTaxi.setEmail(inputTaxi.getEmailChauffeur());
		}
		return newTaxi;
	}
	
	
//	// UPDATE CHAUFFEUR VS RIT
//	public void updateTaxiVsRit(Taxi taxi, final long id) {
//		final Rit rit = taxi.getRitten().get(0);
//		final Taxi newTaxi = taxiRepository.findOne(taxi.getId());
//		final long oldTaxiId = taxiRepository.getTaxiIdFromJoinTable(rit.getId());
//		if (oldTaxiId != newTaxi.getId()) {
//			deleteRit(oldTaxiId, rit.getId());
//			em.flush();
//			updateNewRit(newTaxi, rit);
//		}
//		taxiRepository.save(newTaxi);
//	}
	
	public void updateNewRit(Taxi newTaxi, final Rit rit) {
		List<Rit> newRitten = newTaxi.getRitten();
		newRitten.add(rit);
		newTaxi.setRitten(newRitten);
	}
	
	
	public void deleteRit(final long oldTaxiId, final long ritId) {
		Taxi oldTaxi = taxiRepository.findOne(oldTaxiId);
		List<Rit> ritten = oldTaxi.getRitten();
		ritten.removeIf(el -> ritId == el.getId());
		oldTaxi.setRitten(ritten);
		taxiRepository.save(oldTaxi);
	}
	
	//SOFT DELETE
	public void delete(final long id) {
		Taxi taxi = findById(id);
		taxi.setDeleteFlag(true);
		taxiRepository.save(taxi);
	}
	
	//READ (GET ONE/ALL)
	public Taxi findById(Long id) {
		return taxiRepository.findOne(id);
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
	
	
	//Set naam to Null
	public void updateChauffeurVoorRit (final long id) {
		Taxi taxi1 = findById(id);
		taxi1.setChauffeurNaam(null);
		
	}

}
