package com.recipe.bestrecipe.dto;

import lombok.Data;

@Data
public class FavoriteRequest {
    private Long recipeId;
    private Long userId;
}
