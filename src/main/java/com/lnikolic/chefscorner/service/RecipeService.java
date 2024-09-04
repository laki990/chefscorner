package com.lnikolic.chefscorner.service;

import com.lnikolic.chefscorner.entity.Ingredient;
import com.lnikolic.chefscorner.entity.Recipe;
import com.lnikolic.chefscorner.entity.RecipeIngredient;
import com.lnikolic.chefscorner.entity.Unit;
import com.lnikolic.chefscorner.repository.IngredientRepository;
import com.lnikolic.chefscorner.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Transactional
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElseThrow();
    }


    @Transactional
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    @Transactional
    public Recipe addIngredientToRecipe(Long recipeId, Long ingredientId, BigDecimal amount, Unit unit) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        Ingredient ingredient = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));

        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setRecipe(recipe);
        recipeIngredient.setIngredient(ingredient);
        recipeIngredient.setAmount(amount);
        recipeIngredient.setUnit(unit);

        recipe.getRecipeIngredients().add(recipeIngredient);
        return recipeRepository.save(recipe);
    }
}
