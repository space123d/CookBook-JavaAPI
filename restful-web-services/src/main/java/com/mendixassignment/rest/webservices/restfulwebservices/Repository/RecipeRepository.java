package com.mendixassignment.rest.webservices.restfulwebservices.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mendixassignment.rest.webservices.restfulwebservices.bean.Head;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>{
	
	
	
	@Query("SELECT r FROM Recipe r where r.head/id = ?1")
	List<Recipe> findRecipebyHeadidName(Integer id);

	
}
