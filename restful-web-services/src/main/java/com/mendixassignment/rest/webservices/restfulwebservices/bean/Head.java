package com.mendixassignment.rest.webservices.restfulwebservices.bean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Head {
	@Id
	@JsonIgnore
	@GeneratedValue
	private Integer id;
	
	private String title;
	private Integer yield;
	
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Categories categories;

	
	public Head(Integer id, String title, Integer yield, Categories categories) {
		super();
		this.id = id;
		this.title = title;
		this.yield = yield;
		
		this.categories = categories;
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
