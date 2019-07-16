package com.mendixassignment.rest.webservices.restfulwebservices.bean;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name= "Categories")
public class Categories {
	
	@Id
	@JsonIgnore
	@GeneratedValue
	private Integer id;
	
	
	
	@OneToMany(mappedBy="categories",cascade=CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	 @JsonManagedReference
	
	private List<Cat> cat;
	

	   @OneToOne(mappedBy = "categories")
	   @JsonBackReference
	    private Head head;
	
	public Categories(Integer id, List<Cat> cat) {
		super();
		this.id = id;
		this.cat = cat;
	}



	

	public Head getHead() {
		return head;
	}





	public void setHead(Head head) {
		this.head = head;
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
