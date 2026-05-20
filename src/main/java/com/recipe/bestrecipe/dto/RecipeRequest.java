package com.recipe.bestrecipe.dto;

import lombok.Data;

@Data
public class RecipeRequest {
    private String recipeName;
    private String recipeDescription;
    private long recipeCreatorId;
}
