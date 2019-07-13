package com.mendixassignment.rest.webservices.restfulwebservices.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mendixassignment.rest.webservices.restfulwebservices.bean.Recipe;
import com.mendixassignment.rest.webservices.restfulwebservices.resources.HelloWorldBean;
import com.mendixassignment.rest.webservices.restfulwebservices.resources.RecipeDaoService;
import com.mendixassignment.rest.webservices.restfulwebservices.resources.RecipeRepository;


@RestController
public class RecipeResource {

	
	@Autowired
	private RecipeDaoService service;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@GetMapping("/recipes")
	public List<Recipe> retrieveAllRecipes(){
		  
		return recipeRepository.findAll();
	}
	

	@GetMapping("/hello-world")
	public HelloWorldBean helloWorld() {
		return new HelloWorldBean("Hello World");
	}
}
