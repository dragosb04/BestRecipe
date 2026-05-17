package com.recipe.bestrecipe.services;

import com.recipe.bestrecipe.dto.FavoriteRequest;
import com.recipe.bestrecipe.models.Favorite;
import com.recipe.bestrecipe.models.Recipe;
import com.recipe.bestrecipe.models.User;
import com.recipe.bestrecipe.repositories.FavoriteRepository;
import com.recipe.bestrecipe.repositories.RecipeRepository;
import com.recipe.bestrecipe.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    public FavoriteServiceImpl(FavoriteRepository favoriteRepository,  UserRepository userRepository,  RecipeRepository recipeRepository) {
        this.favoriteRepository = favoriteRepository;
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
    }

    public boolean addFavorite(FavoriteRequest favoriteRequest) {
        User user = userRepository.findById(favoriteRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Recipe recipe = recipeRepository.findById(favoriteRequest.getRecipeId()).orElseThrow(() -> new RuntimeException("Recipe not found"));

        if (favoriteRepository.existsByUserIdAndRecipeId(user.getId(), recipe.getId())) {
            throw new RuntimeException("Favorite already exists");
        }

        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setRecipe(recipe);

        return favoriteRepository.save(favorite).equals(favorite);
    }
}
