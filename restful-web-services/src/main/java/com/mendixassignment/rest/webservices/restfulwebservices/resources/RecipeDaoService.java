package com.mendixassignment.rest.webservices.restfulwebservices.resources;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Amount;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Cat;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Categories;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Directions;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Head;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Ing;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.IngDiv;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Ingredients;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Recipe;



@Component
public class RecipeDaoService {
	
private static List<Recipe> recipeList = new ArrayList<>();



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
		return recipeList;
	}

}
