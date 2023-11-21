package com.deepak.foodcatalogue.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepak.foodcatalogue.entity.FoodItem;

import java.util.List;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Integer> {
    List<FoodItem> findByRestaurantId(Integer restaurantId);
}
