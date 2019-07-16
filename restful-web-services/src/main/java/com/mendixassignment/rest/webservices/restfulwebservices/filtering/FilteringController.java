package com.mendixassignment.rest.webservices.restfulwebservices.filtering;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.mendixassignment.rest.webservices.restfulwebservices.Repository.RecipeRepository;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Recipe;



@RestController
public class FilteringController {
	@Autowired
	private RecipeRepository recipeRepository;
	@GetMapping("/rest/get/recipes/filter/categories")
	public MappingJacksonValue retrieveRecipeCategory() {
		List<Recipe> recipe = recipeRepository.findAll();
		MappingJacksonValue mapping = new MappingJacksonValue(recipe);
		
	SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.serializeAllExcept("content");
		FilterProvider filters =new SimpleFilterProvider().addFilter("recipeFilter", filter);
		
		mapping.setFilters(filters);
		
		
		return mapping;
	}
	
}
