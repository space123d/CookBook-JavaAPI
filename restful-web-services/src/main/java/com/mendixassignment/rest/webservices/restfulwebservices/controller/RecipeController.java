package com.mendixassignment.rest.webservices.restfulwebservices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mendixassignment.rest.webservices.restfulwebservices.bean.Cat;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Head;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Recipe;
import com.mendixassignment.rest.webservices.restfulwebservices.resources.RecipeDaoService;
import com.mendixassignment.rest.webservices.restfulwebservices.resources.RecipeDaoServiceImpl;


@RestController
public class RecipeController {

	/*@Autowired
	private RecipeDaoService service;*/



	@Autowired
	private RecipeDaoService service;


	//retrieve all recipes
	@GetMapping("/rest/get/recipes")
	public List<Recipe> retrieveAllRecipes(){

		return service.findAll() ;

	}

	//retrieve all categories
	@GetMapping("/rest/get/recipes/categories")
	public List<Cat> retrieveAllRecipeCategories(){



		return service.findAllRecipeCategories();

	}
	//retrieve all recipe names in database with yield
	@GetMapping("/rest/get/recipes/names")
	public List<Head> retrieveAllRecipeNames(){



		return service.finaAllRecipeNames();

	}


	//retrieve recipe of selected category
	@GetMapping("/rest/get/recipe/{category}")
	public Recipe retrieveAllRecipebyCategory(@PathVariable String category){


		/*Resource<Recipe> resource = new Resource<Recipe>(recipe);
		ControllerLinkBuilder linkTo =
		linkTo(methodOn(this.getClass()).retrieveAllRecipes());
		resource.add(linkTo.withRel("all-recipes"));
		//HATEOAS
		 */		
		return service.findAllRecipebyCategory(category);


	}

	//get recipe by title
	@GetMapping("/rest/get/recipe/search/{title}")
	public Recipe retrieveRecipebySearch(@PathVariable String title) {


		return service.getRecipebySearch(title);

	}

	//creates recipes
	@PostMapping("/rest/post/recipes")
	public ResponseEntity<Object> createRecipe(@Valid @RequestBody Recipe recipe){

		return service.createNewRecipe(recipe);


	}

	//updates recipe with the input title
	@PutMapping(path="/rest/put/recipe/{title}")
	public ResponseEntity<Recipe> updateRecipe(@PathVariable String title,@RequestBody Recipe recipe) {

		return service.updateRecipeDetails(title,recipe);
	}


	//delete recipe by title
	@DeleteMapping("/rest/delete/recipe/{title}")
	public ResponseEntity<Object> deleteRecipe(@PathVariable String title) {



		return service.deleteRecipe(title);

	}
		//static service for testing purpose only
	@GetMapping("/dummy-recipes")
	public List<Recipe> retrieveAllRecipe(){

		return service.findAlldummyrecipes();
	}

}
