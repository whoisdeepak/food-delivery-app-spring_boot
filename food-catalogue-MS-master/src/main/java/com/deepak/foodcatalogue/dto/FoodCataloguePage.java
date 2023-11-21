package com.deepak.foodcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.deepak.foodcatalogue.entity.FoodItem;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCataloguePage {

    private List<FoodItem> foodItemsList;
    private Restaurant restaurant;
}
