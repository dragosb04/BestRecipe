package com.recipe.bestrecipe.controllers;

import com.recipe.bestrecipe.dto.RateRequest;
import com.recipe.bestrecipe.services.RatingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class RateController {

    private final RatingService ratingService;
    public RateController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<String> addRating(@Valid @RequestBody RateRequest request) {
        System.out.println(request.getRecipe());
        String rateResponse = ratingService.rateRecipe(
                request.getRecipe(),
                request.getUser(),
                request.getRating()
        );

        return ResponseEntity.ok(rateResponse);
    }

}
