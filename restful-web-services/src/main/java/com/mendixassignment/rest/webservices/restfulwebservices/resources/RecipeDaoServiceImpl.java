package com.mendixassignment.rest.webservices.restfulwebservices.resources;



import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mendixassignment.rest.webservices.restfulwebservices.Repository.CatRepository;
import com.mendixassignment.rest.webservices.restfulwebservices.Repository.HeadRepository;
import com.mendixassignment.rest.webservices.restfulwebservices.Repository.RecipeRepository;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Amount;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Cat;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Categories;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Directions;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Head;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Ing;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.IngDiv;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Ingredients;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Recipe;
import com.mendixassignment.rest.webservices.restfulwebservices.exception.ExceptionResponse;
import com.mendixassignment.rest.webservices.restfulwebservices.exception.RecipeNotFoundException;




@Service
public class RecipeDaoServiceImpl implements RecipeDaoService {
	
private static List<Recipe> recipeList = new ArrayList<>();


@Autowired
private RecipeRepository recipeRepository;
@Autowired
private CatRepository catRepository;
@Autowired
private HeadRepository headRepository;



static {
	
	
	List<Cat> listcat= new ArrayList<>();
	Cat cat = new Cat(5, "liquor");
	listcat.add(cat);
	Cat cat1 = new Cat(5, "cake");
	listcat.add(cat1);
	Categories categories = new Categories(45, listcat);
	Head head= new Head(3, "Amaretto Cake", 66, categories);
	
	Amount amt=new Amount(3, "2", "33");
	Ing ing = new Ing(2,"ing",amt);
	List<Ing> inglist=new ArrayList<>();
	inglist.add(ing);
	IngDiv ingdiv= new IngDiv(1, "ing1", inglist);
	List<IngDiv> ingdivlist=new ArrayList<>();
	ingdivlist.add(ingdiv);
	Ingredients ingre= new Ingredients(12, ingdivlist);
	
	Directions direc= new Directions(2,"stepssss");
	
	Recipe recipe1= new Recipe(200,head,ingre,direc);
	recipeList.add(recipe1);
	
	
}


	 public List<Recipe> findAll() {
		// TODO Auto-generated method stub
		return recipeRepository.findAll();
	}


	public List<Cat> findAllRecipeCategories() {
		List<Cat> cat=catRepository.findAll();
		
		if(cat==null)
			throw new RecipeNotFoundException("Categories Not Found");
		
		return cat;
	}

	public List<Head> finaAllRecipeNames(){
		return headRepository.findAll();
		}


	public Recipe findAllRecipebyCategory(String category) {
		Cat C=  catRepository.findAllCatbyContent(category);
		if(C==null)
			throw new RecipeNotFoundException("Selected Category "+category+" Not Found");
		Categories cat=C.getCategories();
		Head h = cat.getHead();
		Recipe recipe = h.getRecipe();
		
		return recipe;
	}


	public Recipe getRecipebySearch(String title) {
		Head h = headRepository.findAllRecipebySearchingName(title);
		if(h==null) 
			throw new RecipeNotFoundException("Record with a title "+title+" not found in database ");
		
		Recipe recipe=h.getRecipe();
		
		if(recipe==null ) 
			throw new RecipeNotFoundException("Record with a title "+title+" not found in database ");
		
		return recipe;
	}


	public ResponseEntity<Object> createNewRecipe(@Valid Recipe recipe) {

		Head titleExists= headRepository.findbyName(recipe.getHead().getTitle());

		if (titleExists != null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),HttpStatus.BAD_REQUEST,"Bad Request","Record Exists","Record with a title "+recipe.getHead().getTitle()+" already exists");
			return new ResponseEntity<Object>(exceptionResponse,HttpStatus.CONFLICT);
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


	public ResponseEntity<Recipe> updateRecipeDetails(String title,Recipe recipe) {
		Head h = headRepository.findAllRecipebySearchingName(title);
		if(h==null) 
			throw new RecipeNotFoundException("Record with a title "+title+" not found in database ");
		Recipe flushRecipe=h.getRecipe();
		recipeRepository.delete(flushRecipe);
		
		recipeRepository.save(recipe);
	  
	    return ResponseEntity.ok(recipe);
	}


	public ResponseEntity<Object> deleteRecipe(String title) {
		Head h = headRepository.findbyName(title);
		if(h==null) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),HttpStatus.NOT_FOUND,"Not Found","Record Not Found","Record with a title "+title+" not found in database to delete.");
			return new ResponseEntity<Object>(exceptionResponse,HttpStatus.NOT_FOUND);
		}else {
			Recipe recipe=h.getRecipe();
			recipeRepository.deleteById(recipe.getId());
		}

		return ResponseEntity.ok().build();
		
	}


	public List<Recipe> findAlldummyrecipes() {
		// TODO Auto-generated method stub
		return recipeList;
	}
}
