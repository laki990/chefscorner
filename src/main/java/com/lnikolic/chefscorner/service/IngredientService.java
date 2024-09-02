package com.lnikolic.chefscorner.service;

import com.lnikolic.chefscorner.entity.Ingredient;
import com.lnikolic.chefscorner.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredientRepository.save(ingredient);
    }

    public List<Ingredient> getIngredients() {
        return this.ingredientRepository.findAll();
    }
}
