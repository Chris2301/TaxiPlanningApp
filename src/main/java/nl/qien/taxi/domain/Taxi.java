package nl.qien.taxi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Taxi {
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name = "Taxi-Rit",
			joinColumns = @JoinColumn(name = "taxi_id"),
			inverseJoinColumns = @JoinColumn(name = "rit_id")
			)
	
	private List<Rit> ritten;
	
	@Id
	@Column(name= "taxi_id")
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
	public List<Rit> getRitten() {
		return ritten;
	}
	public void setRitten(List<Rit> ritten) {
		this.ritten = ritten;
	}
	
}
