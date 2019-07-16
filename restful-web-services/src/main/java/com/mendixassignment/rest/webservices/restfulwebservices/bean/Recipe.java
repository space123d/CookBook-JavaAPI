package com.mendixassignment.rest.webservices.restfulwebservices.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;





@Entity
@ApiModel(description="All the recipes information")

public class Recipe {

	
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrecipe", unique = true, nullable = false)
	private Integer id;
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "head_id", referencedColumnName = "id")
	@JsonManagedReference
	private Head head;
	
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "ingredients_id", referencedColumnName = "id")
	@JsonManagedReference
	private Ingredients ingredients;
	
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "directions_id", referencedColumnName = "id")
	@JsonManagedReference
	private Directions directions;



	public Recipe() {
		super();
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public Ingredients getIngredients() {
		return ingredients;
	}

	public void setIngredients(Ingredients ingredients) {
		this.ingredients = ingredients;
	}

	public Directions getDirections() {
		return directions;
	}

	public void setDirections(Directions directions) {
		this.directions = directions;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

	public Recipe(Integer id, Head head, Ingredients ingredients, Directions directions) {
		super();
		this.id = id;
		this.head = head;
		this.ingredients = ingredients;
		this.directions = directions;
	}

	@Override
	public String toString() {
		return String.format("Recipe [id=%s, head=%s, ingredients=%s, directions=%s]", id, head, ingredients,
				directions);
	}

	


	

	


	
}
