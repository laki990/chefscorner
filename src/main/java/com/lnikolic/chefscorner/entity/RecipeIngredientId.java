package com.lnikolic.chefscorner.entity;

import jakarta.persistence.Embeddable;
import lombok.Data; // Lombok annotation

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
public class RecipeIngredientId implements Serializable {

    private Long recipeId;
    private Long ingredientId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredientId that = (RecipeIngredientId) o;
        return Objects.equals(recipeId, that.recipeId) && Objects.equals(ingredientId, that.ingredientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, ingredientId);
    }
}
