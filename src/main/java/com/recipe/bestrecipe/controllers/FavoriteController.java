package com.recipe.bestrecipe.controllers;

import com.recipe.bestrecipe.dto.FavoriteRequest;
import com.recipe.bestrecipe.services.FavoriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping
    public ResponseEntity<String> addFavorite(@RequestBody FavoriteRequest request) {

        boolean favorite = favoriteService.addFavorite(request);

        if (favorite)
            return ResponseEntity.ok("Favorite added successfully");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or Recipe not found");
    }
}
