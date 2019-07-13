package com.mendixassignment.rest.webservices.restfulwebservices.bean;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	
	
	
	@OneToOne(fetch = FetchType.LAZY)
	
	private Amount amt;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	

	public Amount getAmt() {
		return amt;
	}

	public void setAmt(Amount amt) {
		this.amt = amt;
	}

	public Ing(Integer id, String item, Amount amt) {
		super();
		this.id = id;
		this.item = item;
		
		this.amt = amt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Ing [id=%s, item=%s, amt=%s]", id, item, amt);
	}
	
	
	
}
