package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Restaurant;
import com.example.demo.form.RestaurantSearchForm;
import com.example.demo.service.RestaurantSearchService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RestaurantSearchController {
	
	private final RestaurantSearchService service;
	
	@PostMapping("/restaurant-search")
	private String restaurantSearch(
			@ModelAttribute RestaurantSearchForm form,
			Model model) {
		
		List<Restaurant> list
		   = service.findByNameWildCard(form.getRestaurantName());
		
		model.addAttribute("restaurantList", list);
		
		return "restaurant-list";
		
	}
	
}