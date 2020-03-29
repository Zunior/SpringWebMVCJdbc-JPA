package rs.engineering.javacourse.myspringmvcapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.DynamicUpdate;
//import org.hibernate.annotations.Table;

//@DynamicUpdate
//@Table(appliesTo = "city")
@Entity
@Table(name = "city")
public class City implements Serializable {
	private static final long serialVersionUID = 2151959395889955260L;
	
	@Id
	@Column(name = "NUMBER")
	private Long number;
	private String name;
	
	public City() {
	}
	
	public City(Long number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [number=" + number + ", name=" + name + "]";
	}
	
}
