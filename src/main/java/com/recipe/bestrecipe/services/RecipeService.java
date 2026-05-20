package com.recipe.bestrecipe.services;

import com.recipe.bestrecipe.dto.RecipeRequest;
import com.recipe.bestrecipe.models.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();
    // Trebuie sa primeasca {recipeTitle: x; recipeDescription: x; recipeCreatorId: x}
    Recipe createRecipe(RecipeRequest recipeRequest);
}
