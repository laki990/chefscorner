package com.lnikolic.chefscorner.mapper;

import com.lnikolic.chefscorner.dto.IngredientDto;
import com.lnikolic.chefscorner.entity.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IngredientMapper {
    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    Ingredient ingredientDtoToIngredient(IngredientDto ingredientDto);

    List<IngredientDto> ingredientsToIngredientsDto(List<Ingredient> ingredient);

}
