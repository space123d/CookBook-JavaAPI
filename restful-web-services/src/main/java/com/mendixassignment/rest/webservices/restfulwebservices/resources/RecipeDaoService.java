package com.mendixassignment.rest.webservices.restfulwebservices.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mendixassignment.rest.webservices.restfulwebservices.bean.Cat;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Head;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Recipe;
@Component
public interface RecipeDaoService {

	public List<Recipe> findAll();
	
	public List<Cat> findAllRecipeCategories() ;
	
	public List<Head> finaAllRecipeNames();
	
	public Recipe findAllRecipebyCategory(String category);
	
	public Recipe getRecipebySearch(String title) ;
	
	public ResponseEntity<Object> createNewRecipe(@Valid Recipe recipe);
	
	public ResponseEntity<Recipe> updateRecipeDetails(String title,Recipe recipe) ;
	
	public ResponseEntity<Object> deleteRecipe(String title);
	public List<Recipe> findAlldummyrecipes();
}
