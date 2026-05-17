package com.recipe.bestrecipe.repositories;

import com.recipe.bestrecipe.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    boolean existsByUserIdAndRecipeId(Long userId, Long recipeId);
}
