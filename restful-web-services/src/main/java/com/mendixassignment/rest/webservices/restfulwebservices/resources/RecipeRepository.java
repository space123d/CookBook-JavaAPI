package com.mendixassignment.rest.webservices.restfulwebservices.resources;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mendixassignment.rest.webservices.restfulwebservices.bean.Cat;
import com.mendixassignment.rest.webservices.restfulwebservices.bean.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>{

	@Query("SELECT c FROM Cat c ")
    List<Cat> findAllCategories();
}
