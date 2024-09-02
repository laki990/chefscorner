package com.lnikolic.chefscorner.controller;

import com.lnikolic.chefscorner.dto.IngredientDto;
import com.lnikolic.chefscorner.entity.Ingredient;
import com.lnikolic.chefscorner.mapper.IngredientMapper;
import com.lnikolic.chefscorner.service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public void addIngredient(@RequestBody IngredientDto ingredientDto) {
        Ingredient ingredient = IngredientMapper.INSTANCE.ingredientDtoToIngredient(ingredientDto);
        ingredientService.addIngredient(ingredient);
    }

    @GetMapping
    public ResponseEntity<List<IngredientDto>> getIngredients() {
        List<Ingredient> ingredients = this.ingredientService.getIngredients();
        List<IngredientDto> ingredientDtos = IngredientMapper.INSTANCE.ingredientsToIngredientsDto(ingredients);
        return new ResponseEntity<>(ingredientDtos, HttpStatus.OK);
    }
}
