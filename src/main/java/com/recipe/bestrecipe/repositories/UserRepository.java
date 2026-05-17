package com.recipe.bestrecipe.repositories;

import com.recipe.bestrecipe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
