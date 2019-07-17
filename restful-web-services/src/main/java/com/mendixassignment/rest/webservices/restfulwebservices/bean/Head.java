package com.mendixassignment.rest.webservices.restfulwebservices.bean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="Head")

public class Head {
	@Id
	@JsonIgnore
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Size(min=2)
	@NotNull(message = "title cannot be null")
    private String title;
	
	@NotNull(message = "Yield cannot be null")
	@Min(value = 1, message = "Yield should not be less than 1")
	private Integer yield;
	
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 @JoinColumn(name = "categories_id", referencedColumnName = "id")
	@JsonManagedReference
	private Categories categories;


	   @OneToOne(mappedBy ="head")
	   @JsonBackReference
	   @JoinColumn(name = "idrecipe", insertable = false, updatable = false)
	   private Recipe recipe;
	
	public Head(Integer id, String title, Integer yield, Categories categories) {
		super();
		this.id = id;
		this.title = title;
		this.yield = yield;
		
		this.categories = categories;
	}
	
	
	public Recipe getRecipe() {
		return recipe;
	}


	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}


	public Head() {
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYield() {
		return yield;
	}

	public void setYield(Integer yield) {
		this.yield = yield;
	}

	

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return String.format("Head [id=%s, title=%s, yield=%s, categories=%s]", id, title, yield,
				categories);
	}
	

	
	
	
	
}
