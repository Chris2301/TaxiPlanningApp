package nl.qien.taxi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	
	private String testTitel;
	
	public long getId() {
		return id;
	}

	public Test setId(long id) {
		this.id = id;
		return this;
	}

	public String getTestTitel() {
		return testTitel;
	}

	public void setTestTitel(String testTitel) {
		this.testTitel = testTitel;
	}
}
