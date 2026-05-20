package com.recipe.bestrecipe.repositories;

import com.recipe.bestrecipe.models.RecipeCollection;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CollectionRepository extends JpaRepository<RecipeCollection, Long> {
}
