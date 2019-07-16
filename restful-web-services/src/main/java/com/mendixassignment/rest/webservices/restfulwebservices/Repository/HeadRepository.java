package com.mendixassignment.rest.webservices.restfulwebservices.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mendixassignment.rest.webservices.restfulwebservices.bean.Head;


@Repository
public interface HeadRepository extends JpaRepository<Head, Integer>{



	@Query("SELECT h FROM Head h where h.title=?1")
	Head findbyName(String title);

	
	@Query("SELECT h FROM Head h")
	List<Head> findAllRecipeNames();
	


	
	
}
