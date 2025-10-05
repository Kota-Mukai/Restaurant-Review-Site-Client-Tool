package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.RestaurantSearchForm;

@Controller
public class CommonController {

	@GetMapping("/top")
	private String restaurantList(@ModelAttribute RestaurantSearchForm form) {
		return "restaurant-list";
	}
	
	@GetMapping("/complete")
	private String complete() {
		return "complete";
	}

}