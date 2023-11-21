package com.deepak.foodcatalogue.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.deepak.foodcatalogue.dto.FoodItemDTO;
import com.deepak.foodcatalogue.entity.FoodItem;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

    FoodItemDTO mapFoodItemToFoodItemDto(FoodItem foodItem);


}
