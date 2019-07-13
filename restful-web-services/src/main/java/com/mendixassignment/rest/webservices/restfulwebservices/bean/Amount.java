package com.mendixassignment.rest.webservices.restfulwebservices.bean;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Amount {
	@Id
	@JsonIgnore
	@GeneratedValue
	private Integer id;
	
	private String quantity;
	private String Unit;
	
	@OneToOne(mappedBy="amount")
	@JsonIgnore
	private Ing ing;
	

	public Amount(Integer id, String quantity, String unit) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.Unit = unit;
		
	}


	public Amount() {
		super();
	}


	public Ing getIng() {
		return ing;
	}


	public void setIng(Ing ing) {
		this.ing = ing;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getUnit() {
		return Unit;
	}


	public void setUnit(String unit) {
		Unit = unit;
	}


	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return String.format("Amount [id=%s, quantity=%s, Unit=%s]", id, quantity, Unit);
	}
	
	
}
