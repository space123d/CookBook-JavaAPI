package com.mendixassignment.rest.webservices.restfulwebservices.bean;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Categories {
	
	@Id
	@JsonIgnore
	@GeneratedValue
	private Integer id;
	
	
	
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Cat> cat;
	

	
	
	public Categories(Integer id, List<Cat> cat) {
		super();
		this.id = id;
		this.cat = cat;
	}



	

	public Categories() {
		super();
	}





	public List<Cat> getCat() {
		return cat;
	}





	public void setCat(List<Cat> cat) {
		this.cat = cat;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Categories [id=%s, catlist=%s]", id, cat);
	}

	
	
	
}
