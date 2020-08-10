package com.example.Recipe.Recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.Recipe.Recipe.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

	Optional<Category> findByDescription(String descriptionString);
	
}
