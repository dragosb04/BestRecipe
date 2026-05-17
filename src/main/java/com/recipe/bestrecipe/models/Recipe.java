package com.recipe.bestrecipe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    @JsonIgnore
    private User creator;

    @JsonProperty("creator_id")
    public Long getCreatorId() {
        return creator != null ? creator.getId() : null;
    }

    @OneToMany(mappedBy = "recipe")
    @JsonIgnore
    private List<Favorite> favorites;
}
