package com.mendixassignment.rest.webservices.restfulwebservices.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mendixassignment.rest.webservices.restfulwebservices.bean.Head;


@Repository
public interface HeadRepository extends JpaRepository<Head, Integer>{



	@Query("SELECT h FROM Head h where h.title=?1")
	Head findbyName(String title);

	
	@Query("SELECT h FROM Head h where h.title LIKE %?1%")
	Head findAllRecipebySearchingName(String title);
	


	
	
}
