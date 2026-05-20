package com.recipe.bestrecipe.controllers;

import com.recipe.bestrecipe.models.User;
import com.recipe.bestrecipe.repositories.UserRepository;
import com.recipe.bestrecipe.services.FileStorageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final FileStorageService fileStorageService;

    public UserController(UserRepository userRepository, FileStorageService fileStorageService) {
        this.userRepository = userRepository;
        this.fileStorageService = fileStorageService;
    }

    @PutMapping(value = "/{id}/profile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateProfile(
            @PathVariable Long id,
            @RequestPart("bio") String bio,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setBio(bio);

        if (image != null && !image.isEmpty()) {
            String path = fileStorageService.saveProfileImage(image);
            user.setProfileImagePath(path);
        }

        userRepository.save(user);

        return ResponseEntity.ok(user);
    }
}