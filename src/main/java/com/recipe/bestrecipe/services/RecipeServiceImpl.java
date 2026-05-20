package com.recipe.bestrecipe.services;

import com.recipe.bestrecipe.dto.RecipeRequest;
import com.recipe.bestrecipe.models.Recipe;
import com.recipe.bestrecipe.models.User;
import com.recipe.bestrecipe.repositories.RecipeRepository;
import com.recipe.bestrecipe.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    public RecipeServiceImpl(RecipeRepository recipeRepository, UserRepository userRepository) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe createRecipe (RecipeRequest recipeRequest) {
        User user = userRepository.findById(recipeRequest.getRecipeCreatorId()).orElseThrow(() -> new RuntimeException("recipe creator not found with this id: " + recipeRequest.getRecipeCreatorId()));

        Recipe recipe = new Recipe();
        recipe.setTitle(recipeRequest.getRecipeName());
        recipe.setDescription(recipeRequest.getRecipeDescription());
        recipe.setCreator(user);

        return recipeRepository.save(recipe);
    }


}
