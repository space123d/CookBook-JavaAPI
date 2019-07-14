package com.mendixassignment.rest.webservices.restfulwebservices.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Directions {
	
	@Id
	@JsonIgnore
	@GeneratedValue
	private Integer id;
	
	@Column(length=10485760)
	private String step;
	
	

	
	
	public Directions(Integer id, String step) {
		super();
		this.id = id;
		this.step = step;
		
	}
	
	public Directions() {
		// TODO Auto-generated constructor stub
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Directions [id=%s, step=%s]", id, step);
	}

	
	
	
}
