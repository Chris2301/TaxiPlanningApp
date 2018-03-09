package nl.qien.taxi.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;



@Entity
@Where(clause="deleted='false'")
public class Rit {

	//FIELDS
	@Id
	@Column( name="rit_id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	private String plaats;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	//SOFT DELETE STATUS COLUMN
	@Column(name = "deleted")
	private boolean deleteFlag;
	
	//GETTERS / SETTERS
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPlaats() {
		return plaats;
	}
	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}
		public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
