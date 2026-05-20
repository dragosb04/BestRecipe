package com.recipe.bestrecipe.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    public String saveProfileImage(MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));

        String newFileName = UUID.randomUUID() + extension;

        String uploadDir = "uploads/profile-pics/";
        Path path = Paths.get(uploadDir + newFileName);

        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());

        return path.toString();
    }
}