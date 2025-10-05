package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repository.RestaurantRepository;
import com.example.demo.entity.Restaurant;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantSearchServiceImpl implements RestaurantSearchService {
	
	   private final RestaurantRepository repository;

	@Override
	public List<Restaurant> findByNameWildCard(String restaurantName) {
		List<Restaurant> list
		   = repository.selectByNameWildCard(restaurantName);

		return list;
	}

}