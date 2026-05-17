package com.recipe.bestrecipe.controllers;

import com.recipe.bestrecipe.dto.RecipeRequest;
import com.recipe.bestrecipe.models.Recipe;
import com.recipe.bestrecipe.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class RecipeController {
    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping
    public ResponseEntity<Recipe> addRecipe(@RequestBody RecipeRequest request) {
        Recipe savedRecipe = recipeService.createRecipe(request);
        return ResponseEntity.ok().body(savedRecipe);
    }


}
