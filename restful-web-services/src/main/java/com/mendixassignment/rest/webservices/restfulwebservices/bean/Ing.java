package com.mendixassignment.rest.webservices.restfulwebservices.bean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ing {
	@Id
	@JsonIgnore
	@GeneratedValue
	private Integer id;
	
	private String item;
	
	
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "amount_id", referencedColumnName = "id")
	private Amount amount;

	
	
	
	public Ing() {
		super();
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	

	

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public Ing(Integer id, String item, Amount amt) {
		super();
		this.id = id;
		this.item = item;
		
		this.amount = amt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Ing [id=%s, item=%s, amount=%s]", id, item, amount);
	}
	
	
	
}
