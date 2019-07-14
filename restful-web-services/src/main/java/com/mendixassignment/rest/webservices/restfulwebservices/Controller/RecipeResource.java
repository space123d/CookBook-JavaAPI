package com.mendixassignment.rest.webservices.restfulwebservices.Controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mendixassignment.rest.webservices.restfulwebservices.bean.Recipe;
import com.mendixassignment.rest.webservices.restfulwebservices.resources.RecipeDaoService;
import com.mendixassignment.rest.webservices.restfulwebservices.resources.RecipeRepository;


@RestController
public class RecipeResource {

	@Autowired
	private RecipeDaoService service;
	
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@GetMapping("/recipes")
	public List<Recipe> retrieveAllRecipe(){
		  
		return service.findAll();
	}
	
	@GetMapping("/rest/get/recipes")
	public List<Recipe> retrieveAllRecipes(){
		  
		return recipeRepository.findAll();
	}
	
	@PostMapping("/rest/post/recipes")
	public ResponseEntity<Object> createRecipe(@Valid @RequestBody Recipe recipe){
	
	Recipe savedRecipe = recipeRepository.save(recipe);
	
	URI location =ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedRecipe.getId()).toUri();
	
	return ResponseEntity.created(location).build();
}

}
