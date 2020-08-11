package com.example.Recipe.Recipe.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Recipe.Recipe.command.RecipeCommand;
import com.example.Recipe.Recipe.converters.RecipeCommandToRecipe;
import com.example.Recipe.Recipe.converters.RecipeToRecipeCommand;
import com.example.Recipe.Recipe.domain.Recipe;
import com.example.Recipe.Recipe.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService{
	private RecipeRepository recipeRepository;
	private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

	@Override
	public Set<Recipe> getRecipes() {
		
		log.debug("I'm in the service");
		Set<Recipe> recipeSet = new HashSet<Recipe>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
	    return recipeSet;
	}

	@Override
	public Recipe findById(Long l) {

	        Optional<Recipe> recipeOptional = recipeRepository.findById(l);

	        if (!recipeOptional.isPresent()) {
	        	throw new RuntimeException("Recipe Not Found!");
	        }

	        return recipeOptional.get();
	 }

	 @Override
	    public void deleteById(Long idToDelete) {
	        recipeRepository.deleteById(idToDelete);
	    }

	 @Override
	    @Transactional
	    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
	        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

	        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
	        log.debug("Saved RecipeId:" + savedRecipe.getId());
	        return recipeToRecipeCommand.convert(savedRecipe);
	    }

}
