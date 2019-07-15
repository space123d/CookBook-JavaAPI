package com.mendixassignment.rest.webservices.restfulwebservices.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mendixassignment.rest.webservices.restfulwebservices.bean.Cat;


@Repository
public interface CatRepository extends JpaRepository<Cat, Integer>{

	@Query("SELECT c FROM Cat c ")
    List<Cat> findAllCategories();

	@Query("SELECT c FROM Cat c where c.content=?1")
    Cat findCatbyContent(String content);
	
}
