package com.recipe.bestrecipe.services;

import com.recipe.bestrecipe.models.Recipe;
import com.recipe.bestrecipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}
