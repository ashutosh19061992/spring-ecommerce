package com.example.demo.jparepository.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	@Query("Select c FROM Category c WHERE c.name= :name")
	Category findByName(@Param("name") String name) throws ResourceNotFoundException;
}
