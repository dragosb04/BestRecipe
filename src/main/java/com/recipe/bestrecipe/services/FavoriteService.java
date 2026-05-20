package com.recipe.bestrecipe.services;

import com.recipe.bestrecipe.dto.FavoriteRequest;

public interface FavoriteService {
    boolean addFavorite(FavoriteRequest favoriteRequest);
}
