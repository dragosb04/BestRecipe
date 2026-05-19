package com.recipe.bestrecipe.services;

import com.recipe.bestrecipe.models.Rate;
import com.recipe.bestrecipe.models.Recipe;
import com.recipe.bestrecipe.models.User;
import com.recipe.bestrecipe.repositories.RateRepository;
import com.recipe.bestrecipe.repositories.RecipeRepository;
import com.recipe.bestrecipe.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    private final RateRepository rateRepository;
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    public RatingServiceImpl(RateRepository rateRepository,
                             UserRepository userRepository,
                             RecipeRepository recipeRepository) {
        this.rateRepository = rateRepository;
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public String rateRecipe(long recipeId, long userId, Double rating) {

        if (rateRepository.existsByUserIdAndRecipeId(userId, recipeId)) {
            return "User already rated this recipe";
        }

        if (rating < 1 || rating > 5) {
            return "Rating must be between 1 and 5";
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        Rate newRate = new Rate();
        newRate.setRate(rating);
        newRate.setUser(user);
        newRate.setRecipe(recipe);

        rateRepository.save(newRate);

        return "Rate successfully added";
    }
}
