package com.recipe.bestrecipe.dto;

import lombok.Data;

import jakarta.validation.constraints.*;

@Data
public class RateRequest {

    @NotNull
    private Long user;

    @NotNull
    private Long recipe;

    @NotNull
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private Double rating;
}
