package com.mendixassignment.rest.webservices.restfulwebservices.unittest.unittestController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import java.util.List;

import com.mendixassignment.rest.webservices.restfulwebservices.Repository.CatRepository;
import com.mendixassignment.rest.webservices.restfulwebservices.Repository.HeadRepository;
import com.mendixassignment.rest.webservices.restfulwebservices.Repository.RecipeRepository;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Cat;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Head;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Recipe;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Repository_basictest {

	
	@Autowired
	private RecipeRepository recipeRepository;
	@Autowired
	private CatRepository catRepository;
	@Autowired
	private HeadRepository headRepository;
	
	
	@Test
	public void testFindAll_recipeRepository() throws Exception {
		List<Recipe> recipelistAll = recipeRepository.findAll();
		assertEquals(3,recipelistAll.size());
	}
	@Test
	public void testfindRecipebyHeadidName_recipeRepository() throws Exception {
		List<Recipe> recipelist = recipeRepository.findRecipebyHeadidName(2);
		assertEquals(2,recipelist.get(0).getHead().getId().intValue());
	}
	
	@Test
	public void testfindAll_catRepository() throws Exception {
		List<Cat> catlist = catRepository.findAll();
		assertEquals(7,catlist.size());
	}
	
	@Test
	public void testfindCatbyContent_catRepository() throws Exception {
		Cat cat = catRepository.findCatbyContent("Liquor");
		assertEquals("Liquor",cat.getCategories().getCat().get(0).getContent());
	}
	
	
	@Test
	public void testfindAll_headRepository() throws Exception {
		List<Head> headlistfindall = headRepository.findAll();
		assertEquals(3,headlistfindall.size());
	}
	@Test
	public void testfindbyName_headRepository() throws Exception {
		 Head headfindbyName = headRepository.findbyName("Amaretto Cake");
		assertEquals(6,headfindbyName.getYield().intValue());
	}
	
	@Test
	public void testfindAllRecipebySearchingName_headRepository() throws Exception {
		 Head headfindAllRecipebySearchingName = headRepository.findAllRecipebySearchingName("Cake");
		assertEquals("Amaretto Cake",headfindAllRecipebySearchingName.getTitle());
	}
}
