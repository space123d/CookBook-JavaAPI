package com.mendixassignment.rest.webservices.restfulwebservices.bean;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cat {
	@Id
	@JsonIgnore
	@GeneratedValue
	private Integer id;
	
	private String content;
	
	
	 


	public Cat(Integer id, String content) {
		super();
		this.id = id;
		this.content = content;
		
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
