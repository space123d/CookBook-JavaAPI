package com.mendixassignment.rest.webservices.restfulwebservices.bean;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categories {
	
	@Id
	@JsonIgnore
	@GeneratedValue
	private Integer id;
	
	
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Cat> cat;
	

	
	
	public Categories(Integer id, List<Cat> cat) {
		super();
		this.id = id;
		this.cat = cat;
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
