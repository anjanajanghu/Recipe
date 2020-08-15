package com.example.Recipe.Recipe.services;

import java.util.Set;

import com.example.Recipe.Recipe.command.RecipeCommand;
import com.example.Recipe.Recipe.domain.Recipe;


public interface RecipeService {
	Set<Recipe> getRecipes();

    Recipe findById(Long l);

    void deleteById(Long idToDelete);
    
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    
    RecipeCommand findCommandById(Long l);


}
