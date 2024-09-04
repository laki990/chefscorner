package com.lnikolic.chefscorner.entity;

import jakarta.persistence.Embeddable;
import lombok.Data; // Lombok annotation

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class RecipeIngredientId implements Serializable {

    private Long recipeId;
    private Long ingredientId;
}
