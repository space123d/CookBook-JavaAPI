package com.mendixassignment.rest.webservices.restfulwebservices.Controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mendixassignment.rest.webservices.restfulwebservices.bean.Cat;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Recipe;
import com.mendixassignment.rest.webservices.restfulwebservices.resources.RecipeDaoService;
import com.mendixassignment.rest.webservices.restfulwebservices.resources.RecipeRepository;


@RestController
public class RecipeResource {

	@Autowired
	private RecipeDaoService service;


	@Autowired
	private RecipeRepository recipeRepository;



	@GetMapping("/rest/get/recipes")
	public List<Recipe> retrieveAllRecipes(){

		return recipeRepository.findAll();

	}
	
	
	@GetMapping("/rest/get/categories")
	public List<Cat> retrievebyRecipeCategory(){

		return recipeRepository.findAllCategories();

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
	
	
	@DeleteMapping("/rest/delete/recipe/{id}")
	public void deleteRecipe(@PathVariable int id) {
		recipeRepository.deleteById(id);
	}

	//static service for testing purpose only
	@GetMapping("/recipes")
	public List<Recipe> retrieveAllRecipe(){

		return service.findAll();
	}
}
