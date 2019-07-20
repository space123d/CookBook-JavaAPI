package com.mendixassignment.rest.webservices.restfulwebservices.unittest.unittestController;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mendixassignment.rest.webservices.restfulwebservices.bean.Amount;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Cat;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Categories;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Directions;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Head;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Ing;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.IngDiv;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Ingredients;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Recipe;
import com.mendixassignment.rest.webservices.restfulwebservices.resources.RecipeDaoServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RecipeControllertest {

	private static List<Recipe> recipeList = new ArrayList<>();
	
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private RecipeDaoServiceImpl recipeDaoservice;
	
	@Test
	public void recipeFromBusinessService_basicTest() throws
	Exception {
		Recipe recipe1 = getRecipeData();
		recipeList.add(recipe1);
		
		when(recipeDaoservice.findAlldummyrecipes()).thenReturn(
				recipeList);
				RequestBuilder request =
				MockMvcRequestBuilders
				.get("/dummy-recipes")
				.accept(MediaType.APPLICATION_JSON);
				MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{head:{title:\"Amaretto Cake\"}}]"))
				.andReturn();
				//JSONAssert.assertEquals(expected,
				//result.getResponse().getContentAsString(), false);
				
	}
	
	@Test
	public void getRecipebyCategoryTest() throws
	Exception {
		Recipe recipe = getRecipeData();
		
		
		
		when(recipeDaoservice.findAllRecipebyCategory("Liquor")).thenReturn(
				recipe);
				RequestBuilder request =
				MockMvcRequestBuilders
				.get("/rest/get/recipe/Liquor")
				.accept(MediaType.APPLICATION_JSON);
				MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{head:{title:\"Amaretto Cake\"}}"))
				.andReturn();
		
	}

	

	@Test
	public void getAvailableCategoriesTest() throws
	Exception {
		List<Cat> listcat= new ArrayList<>();
		Cat cat = new Cat(5, "Liquor");
		listcat.add(cat);
		Cat cat1 = new Cat(5, "cake");
		listcat.add(cat1);
		
		
		when(recipeDaoservice.findAllRecipeCategories()).thenReturn(
				listcat);
				RequestBuilder request =
				MockMvcRequestBuilders
				.get("/rest/get/recipes/categories")
				.accept(MediaType.APPLICATION_JSON);
				MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{content:\"Liquor\"},{content:\"cake\"}]"))
				.andReturn();
		
	}
	
	@Test
	public void postRecipeTest() throws
	Exception {
		
	String json ="{" + 
			"      \"head\": {" + 
			"        \"title\": \"30 Minute Chili34\"," + 
			"        \"categories\": {" + 
			"          \"cat\": [" + 
			"                   {" + 
			"                        \"content\": \"Main dish1\"" + 
			"                    }," + 
			"                    {" + 
			"                        \"content\": \"Chilli\"" + 
			"                    }" + 
			"                    " + 
			"                ]" + 
			"        }," + 
			"        \"yield\": \"6\"" + 
			"      }," + 
			"      \"ingredients\": {" + 
			"        \"ingdiv\": [{" + 
			"          \"ing\": [" + 
			"            {" + 
			"              \"amount\": {" + 
			"                \"quantity\": \"1\"," + 
			"                \"unit\": \"pound\"" + 
			"              }," + 
			"              \"item\": \"Ground chuck or lean ground; beef\"" + 
			"            }," + 
			"            {" + 
			"              \"amount\": { \"quantity\": \"1\" }," + 
			"              \"item\": \"Onion; large, chopped\"" + 
			"            }," + 
			"            {" + 
			"              \"amount\": {" + 
			"                \"quantity\": \"1\"," + 
			"                \"unit\": \"can\"" + 
			"              }," + 
			"              \"item\": \"Kidney beans; (12 oz)\"" + 
			"            }," + 
			"            {" + 
			"              \"amount\": {" + 
			"                \"quantity\": \"1\"," + 
			"                \"unit\": \"can\"" + 
			"              }," + 
			"              \"item\": \"Tomato soup; undiluted\"" + 
			"            }," + 
			"            {" + 
			"              \"amount\": {" + 
			"                \"quantity\": \"1\"," + 
			"                \"unit\": \"teaspoon\"" + 
			"              }," + 
			"              \"item\": \"Salt\"" + 
			"            }," + 
			"            {" + 
			"              \"amount\": {" + 
			"                \"quantity\": \"1\"," + 
			"                \"unit\": \"tablespoon\"" + 
			"              }," + 
			"              \"item\": \"Chili pheadowder; (or to taste)\"" + 
			"            }," + 
			"            {" + 
			"              \"amount\": {" + 
			"                " + 
			"              }," + 
			"              \"item\": \"Hot pepper sauce; to taste\"" + 
			"            }" + 
			"          ]" + 
			"        }]" + 
			"      }," + 
			"      \"directions\": {" + 
			"        \"step\": \"  Brown the meat in a little butter and cook until the meat is brown -- about 10 minutes. Add all other ingredients and let simmer for 30 minutes. Your choice of hot sauce may be added to taste. Recipe by: MasterCook Archives Posted to recipelu-digest Volume 01 Number 577 by Rodeo46898 <Rodeo46898@aol.com> on Jan 22, 1998\"" + 
			"     }" + 
			"    }" + 
			"  ";
		//Recipe newRecipe = new Recipe();
		
		MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
	
				RequestBuilder request =
				MockMvcRequestBuilders
				.post("/rest/post/recipes").content(json)
				.accept(MEDIA_TYPE_JSON_UTF8).contentType(MEDIA_TYPE_JSON_UTF8);
				MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andReturn();
				//JSONAssert.assertEquals(expected,
				//result.getResponse().getContentAsString(), false);
				
	
	}
	
	@Test
	public void ExceptionTest() throws
	Exception {
		Recipe recipe = getRecipeData();
		when(recipeDaoservice.findAllRecipebyCategory("abc")).thenReturn(
				recipe);
				RequestBuilder request =
				MockMvcRequestBuilders
				.get("/rest/get/recipe/abcd")
				.accept(MediaType.APPLICATION_JSON);
				MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
//				.andExpect(content().json("{head:{title:\"Amaretto Cake\"}}"))
				.andReturn();
		
	}
	
	private Recipe getRecipeData() {
		List<Cat> listcat= new ArrayList<>();
		Cat cat = new Cat(5, "Liquor");
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
		
		Recipe recipe= new Recipe(200,head,ingre,direc);
		return recipe;
	}
	
	
}
