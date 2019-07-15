package com.mendixassignment.rest.webservices.restfulwebservices.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Directions {
	
	@Id
	@JsonIgnore
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(length=10485760)
	private String step;
	
	

	   @OneToOne(mappedBy ="directions")
	   @JsonBackReference
	   @JoinColumn(name = "idrecipe", insertable = false, updatable = false)
	    private Recipe recipe;
	
	public Directions(Integer id, String step) {
		super();
		this.id = id;
		this.step = step;
		
	}
	
	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
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
