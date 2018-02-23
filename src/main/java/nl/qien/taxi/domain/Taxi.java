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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;

import org.hibernate.annotations.Where;



@Entity
@Where(clause="deleted='false'")
public class Taxi {
	
	//Many to one Join
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@Where(clause="deleted='false'")
	@JoinTable(
			name = "taxi_x_rit",
			joinColumns = @JoinColumn(name = "taxi_id"),
			inverseJoinColumns = @JoinColumn(name = "rit_id")
			)
	
	private List<Rit> ritten;
	
	//Fields
	@Id
	@Column(name= "taxi_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name= "naam_chauffeur")
	private String chauffeurNaam;
	
	@Column(name= "type_auto")
	private String typeAuto;
	
	@Column(name = "email_chauffeur")
	private String emailChauffeur;
	
	//SOFT DELETE STATUS COLUMN
	@Column(name = "deleted")
	private boolean deleteFlag;
	
	//Getters-Setters
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
	
	public boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public String getEmailChauffeur() {
		return emailChauffeur;
	}
	public void setEmail(String emailChauffeur) {
		this.emailChauffeur = emailChauffeur;
	}
}
