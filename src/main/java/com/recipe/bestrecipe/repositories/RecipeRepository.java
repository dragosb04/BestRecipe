package com.recipe.bestrecipe.repositories;

import com.recipe.bestrecipe.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
