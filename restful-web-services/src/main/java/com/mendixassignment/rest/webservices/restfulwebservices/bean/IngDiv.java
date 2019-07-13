package com.mendixassignment.rest.webservices.restfulwebservices.bean;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class IngDiv {

	@Id
	@JsonIgnore
	@GeneratedValue
	private Integer id;
	
	private String title;
	
	
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Ing> ing;
	
	


	public IngDiv() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	

	public List<Ing> getIng() {
		return ing;
	}

	public void setIng(List<Ing> ing) {
		this.ing = ing;
	}

	public IngDiv(Integer id, String title, List<Ing> ing) {
		super();
		this.id = id;
		this.title = title;
		
		this.ing = ing;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("IngDiv [id=%s, title=%s, ing=%s]", id, title, ing);
	}

	
	
	
	
	

}
