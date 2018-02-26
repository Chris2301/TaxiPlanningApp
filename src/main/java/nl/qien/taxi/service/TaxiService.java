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
	private EntityManager em;
	
	//CRUD//////////////////////////////////////////////////////
	
	//CREATE/UPDATE
	
//	Save uitleg
//	1. Hij krijgt info binnen voor Hester (nieuwe plaats en tijd) met 't' 
//	2. lokale NewTaxi object krijgt de waarden uit de database op de positie (id) van het binnenkomende object
//	3. if functie zet de binnenkomende null waarde om  naar Hester, want de naam blijft hetzelfde in de database, maar wat er binnenkomt is null
//	4. Nu maak je een rittenlijst object aan van de bestaande waarde in de oude lijst
//	5. je voegt daar de nieuwe ritinfo aan het lokale object
//	6. je set het dan voor de uitgaande info (t)
//	7. je slaat de uitgaande info op (t)

	public Taxi save(Taxi t) {	
		final Taxi newTaxi = taxiRepository.findOne(t.getId());
		if(t.getChauffeurNaam() == null || t.getChauffeurNaam().equalsIgnoreCase("")) {
			t.setChauffeurNaam(newTaxi.getChauffeurNaam());
		}
		List<Rit> ritten = newTaxi.getRitten();
		ritten.add(t.getRitten().get(0));
		t.setRitten(ritten);
		return taxiRepository.save(t);
	}
	
	public void update(Taxi taxi, final long id) {
		final Rit rit = taxi.getRitten().get(0);
		final Taxi newTaxi = taxiRepository.findOne(taxi.getId());
		final long oldTaxiId = taxiRepository.getTaxiIdFromJoinTable(rit.getId());
		if (oldTaxiId != newTaxi.getId()) {
			deleteRit(oldTaxiId, rit.getId());
			em.flush();
			updateNewRit(newTaxi, rit);
		}
		taxiRepository.save(newTaxi);
	}
	
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
