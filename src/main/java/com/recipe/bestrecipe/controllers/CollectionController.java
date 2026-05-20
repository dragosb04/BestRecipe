package com.recipe.bestrecipe.controllers;

import com.recipe.bestrecipe.dto.AddRecipeRequest;
import com.recipe.bestrecipe.dto.CreateCollectionRequest;
import com.recipe.bestrecipe.models.RecipeCollection;
import com.recipe.bestrecipe.services.CollectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collections")
public class CollectionController {

    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<RecipeCollection> createCollection(
            @PathVariable Long userId,
            @RequestBody CreateCollectionRequest request
    ) {
        return ResponseEntity.ok(
                collectionService.createCollection(userId, request.getName())
        );
    }

    @PostMapping("/{collectionId}/recipes")
    public ResponseEntity<RecipeCollection> addRecipe(
            @PathVariable Long collectionId,
            @RequestBody AddRecipeRequest request
    ) {
        return ResponseEntity.ok(
                collectionService.addRecipe(collectionId, request.getRecipeId())
        );
    }
}
