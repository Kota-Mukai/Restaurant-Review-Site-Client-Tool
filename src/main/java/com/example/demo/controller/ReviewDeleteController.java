package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Review;
import com.example.demo.form.ReviewDeleteForm;
import com.example.demo.service.ReviewDeleteService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewDeleteController {
	
	private final ReviewDeleteService service;
	
	@PostMapping("/delete-review")
	public String deleteReview(
			@Validated @ModelAttribute ReviewDeleteForm form,
			BindingResult result) {
		
		if(result.hasErrors()) {
			throw new IllegalArgumentException("**deleteReview()**");
		}
		
		return "confirm-delete-review";
	}
	
	@PostMapping("/confirm-delete-review")
	public String confirmDeleteReview(
			@Validated ReviewDeleteForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			throw new IllegalArgumentException("**confirmDeleteReview()**");
		}
		
		Review r = new Review();
		r.setReviewId(form.getReviewId());
		r.setRestaurantId(form.getRestaurantId());
		r.setUserId(form.getUserId());
		r.setVisitDate(form.getVisitDate());
		r.setRating(form.getRating());
		r.setComment(form.getComment());
		
		service.delete(r);
				
		redirectAttributes.addFlashAttribute("msg", "Review Deletion");
		
		return "redirect:/complete";
	}

}