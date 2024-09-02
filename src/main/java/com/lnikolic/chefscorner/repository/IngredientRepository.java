package com.lnikolic.chefscorner.repository;

import com.lnikolic.chefscorner.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
