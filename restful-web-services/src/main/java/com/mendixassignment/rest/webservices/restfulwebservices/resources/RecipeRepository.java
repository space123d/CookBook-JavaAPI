package com.mendixassignment.rest.webservices.restfulwebservices.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mendixassignment.rest.webservices.restfulwebservices.bean.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>{

}
