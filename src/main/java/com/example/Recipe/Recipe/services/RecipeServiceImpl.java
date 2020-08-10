package com.example.Recipe.Recipe.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.Recipe.Recipe.domain.Recipe;
import com.example.Recipe.Recipe.repositories.RecipeRepository;
@Service
public class RecipeServiceImpl implements RecipeService{
	private RecipeRepository recipeRepository;
	
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {
		Set<Recipe> recipeSet = new HashSet<Recipe>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
	    return recipeSet;
	}

	 @Override
	    public Recipe findById(Long l) {

	        Optional<Recipe> recipeOptional = recipeRepository.findById(l);

	        if (!recipeOptional.isPresent()) {
	           
	        }

	        return recipeOptional.get();
	    }

	 @Override
	    public void deleteById(Long idToDelete) {
	        recipeRepository.deleteById(idToDelete);
	    }

}
