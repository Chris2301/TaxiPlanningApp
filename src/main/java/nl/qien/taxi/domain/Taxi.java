package nl.qien.taxi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Taxi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String chauffeurNaam;
	private String typeAuto;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}
	public String getChauffeurNaam() {
		return chauffeurNaam;
	}
	public void setChauffeurNaam(String chauffeurNaam) {
		this.chauffeurNaam=chauffeurNaam;
	}
	public String getTypeAuto() {
		return typeAuto;
	}
	public void setTypeAuto(String type) {
		this.typeAuto=type;
	}
	
}
