package com.example.Recipe.Recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.Recipe.Recipe.domain.Recipe;

public interface RecipeRepository  extends CrudRepository<Recipe, Long>{

}
