package com.recipe.bestrecipe.services;

import com.recipe.bestrecipe.models.Recipe;
import com.recipe.bestrecipe.models.RecipeCollection;
import com.recipe.bestrecipe.models.User;
import com.recipe.bestrecipe.repositories.CollectionRepository;
import com.recipe.bestrecipe.repositories.RecipeRepository;
import com.recipe.bestrecipe.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CollectionService {

    private final CollectionRepository collectionRepository;
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    public CollectionService(CollectionRepository collectionRepository,
                             UserRepository userRepository,
                             RecipeRepository recipeRepository) {
        this.collectionRepository = collectionRepository;
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
    }

    public RecipeCollection createCollection(Long userId, String name) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        RecipeCollection collection = new RecipeCollection();
        collection.setName(name);
        collection.setOwner(user);

        return collectionRepository.save(collection);
    }

    public RecipeCollection addRecipe(Long collectionId, Long recipeId) {

        RecipeCollection collection = collectionRepository.findById(collectionId)
                .orElseThrow(() -> new RuntimeException("Collection not found"));

        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        collection.getRecipes().add(recipe);

        return collectionRepository.save(collection);
    }

}
