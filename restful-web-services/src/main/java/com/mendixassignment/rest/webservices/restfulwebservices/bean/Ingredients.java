package com.mendixassignment.rest.webservices.restfulwebservices.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ingredients {

	@Id
	@JsonIgnore
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	
	
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<IngDiv> ingdiv;

	
	   @OneToOne(mappedBy ="ingredients")
	   @JsonBackReference
	   @JoinColumn(name = "idrecipe", insertable = false, updatable = false)
	    private Recipe recipe;


	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public List<IngDiv> getIngdiv() {
		return ingdiv;
	}

	public void setIngdiv(List<IngDiv> ingdiv) {
		this.ingdiv = ingdiv;
	}

	public Ingredients(Integer id, List<IngDiv> ingdiv) {
		super();
		this.id = id;
		
		this.ingdiv = ingdiv;
	}

	public Ingredients() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Ingredients [id=%s, ingdiv=%s]", id, ingdiv);
	}

	
	
	
}
