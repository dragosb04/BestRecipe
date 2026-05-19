package com.recipe.bestrecipe.repositories;

import com.recipe.bestrecipe.models.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<Rate, Long> {
    boolean existsByUserIdAndRecipeId(Long userId, Long recipeId);
}
