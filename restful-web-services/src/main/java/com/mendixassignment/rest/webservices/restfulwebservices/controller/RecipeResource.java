package com.mendixassignment.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mendixassignment.rest.webservices.restfulwebservices.Repository.CatRepository;

import com.mendixassignment.rest.webservices.restfulwebservices.Repository.HeadRepository;
import com.mendixassignment.rest.webservices.restfulwebservices.Repository.RecipeRepository;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Cat;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Categories;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Head;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Recipe;
import com.mendixassignment.rest.webservices.restfulwebservices.exception.ExceptionResponse;
import com.mendixassignment.rest.webservices.restfulwebservices.exception.RecipeNotFoundException;


@RestController
public class RecipeResource {

	/*@Autowired
	private RecipeDaoService service;*/


	@Autowired
	private RecipeRepository recipeRepository;
	@Autowired
	private CatRepository catRepository;
	@Autowired
	private HeadRepository headRepository;
	@Autowired



	//retrieve all recipes
	@GetMapping("/rest/get/recipes")
	public List<Recipe> retrieveAllRecipes(){

		return recipeRepository.findAll();

	}

	//retrieve all categories
	@GetMapping("/rest/get/recipes/categories")
	public List<Cat> retrieveAllRecipeCategories(){

		List<Cat> cat=catRepository.findAllCategories();
		
		if(cat==null)
			throw new RecipeNotFoundException("Categories Not Found");
		
		
		
		return cat;

	}
	//retrieve all recipe names in database with yield
	@GetMapping("/rest/get/recipes/names")
	public List<Head> retrieveAllRecipeNames(){

		return headRepository.findAllRecipeNames();

	}


	//retrieve recipe of selected category
	@GetMapping("/rest/get/recipe/{category}")
	public Recipe retrieveAllRecipebyCategory(@PathVariable String category){


		Cat C=  catRepository.findCatbyContent(category);
		if(C==null)
			throw new RecipeNotFoundException("Selected Category "+category+" Not Found");
		Categories cat=C.getCategories();
		Head h = cat.getHead();
		Recipe recipe = h.getRecipe();
		
		
		
		/*Resource<Recipe> resource = new Resource<Recipe>(recipe);
		ControllerLinkBuilder linkTo =
		linkTo(methodOn(this.getClass()).retrieveAllRecipes());
		resource.add(linkTo.withRel("all-recipes"));
		//HATEOAS
*/		
		return recipe;


	}

	//creates recipes
	@PostMapping("/rest/post/recipes")
	public ResponseEntity<Object> createRecipe(@Valid @RequestBody Recipe recipe){


		Head titleExists= headRepository.findbyName(recipe.getHead().getTitle());

		if (titleExists != null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),"Record Exists","Record with a title "+recipe.getHead().getTitle()+" already exists");
			return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
		}

		else {
			Recipe savedRecipe = recipeRepository.save(recipe);
			URI location =ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(savedRecipe.getId()).toUri();

			return ResponseEntity.created(location).build();
		}



	}


	//delete recipe by title
	@DeleteMapping("/rest/delete/recipe/{title}")
	public ResponseEntity<Object> deleteRecipe(@PathVariable String title) {
		
		
		
		Head h = headRepository.findbyName(title);
		if(h==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),"Record Not Found","Record with a title "+title+" not found in database to delete.");
			return new ResponseEntity<Object>(exceptionResponse,HttpStatus.NOT_FOUND);
		}else {
			Recipe recipe=h.getRecipe();
			recipeRepository.deleteById(recipe.getId());
		}

		return ResponseEntity.ok().build();

	}

	/*//static service for testing purpose only
	@GetMapping("/recipes")
	public List<Recipe> retrieveAllRecipe(){

		return service.findAll();
	}*/
}
