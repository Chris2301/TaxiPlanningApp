package nl.qien.taxi.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Rit {

	@Id
	@Column( name="rit_id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	private String plaats;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
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
}
