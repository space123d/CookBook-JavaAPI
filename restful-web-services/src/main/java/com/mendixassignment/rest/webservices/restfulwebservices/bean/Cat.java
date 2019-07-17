package com.mendixassignment.rest.webservices.restfulwebservices.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="Cat")

public class Cat {
	@Id
	@JsonIgnore
	@GeneratedValue
	private Integer id;
	
	@NotNull(message = "Category Name cannot be null")
	private String content;
	
	@ManyToOne
	 @JsonBackReference
	private Categories categories;
	 


	public Cat(Integer id, String content) {
		super();
		this.id = id;
		this.content = content;
		
	}


	public Categories getCategories() {
		return categories;
	}


	public void setCategories(Categories categories) {
		this.categories = categories;
	}


	public Cat() {
		super();
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return String.format("Cat [id=%s, content=%s]", id, content);
	}

}
