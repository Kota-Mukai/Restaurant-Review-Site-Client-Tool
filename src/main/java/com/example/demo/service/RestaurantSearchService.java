package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Restaurant;

public interface RestaurantSearchService {
	
	List<Restaurant> findByNameWildCard(String restaurantName);

}