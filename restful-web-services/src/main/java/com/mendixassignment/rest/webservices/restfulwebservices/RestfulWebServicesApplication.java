package com.mendixassignment.rest.webservices.restfulwebservices;





import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mendixassignment.rest.webservices.restfulwebservices.Repository.RecipeRepository;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Recipe;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;





@SpringBootApplication
@EnableJpaRepositories(basePackages= {"com.mendixassignment.rest.webservices.restfulwebservices.Repository"})
@EntityScan(basePackages= {"com.mendixassignment.rest.webservices.restfulwebservices.bean"})
public class RestfulWebServicesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
		
	}
	
	
	@Bean
	CommandLineRunner runner( RecipeRepository recipeRepository) {
		return args -> {
			// reading json file and writing to inMemory db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Recipe>> typeReference = new TypeReference<List<Recipe>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Initialdata.json");
			try {
				List<Recipe> recipe = mapper.readValue(inputStream,typeReference);
				recipeRepository.saveAll(recipe);
				System.out.println("Recipes created with Initial Data...");
			} catch (IOException e){
				System.out.println("Unable to save recipes: " + e.getMessage());
			}
		};
	}


	    
	    
}
