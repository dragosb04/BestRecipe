package com.recipe.bestrecipe.services;

public interface RatingService {
    String rateRecipe(long recipe, long user, Double rating);
}
