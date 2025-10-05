package com.example.demo.form;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class ReviewEditForm {
	@NotNull(message="Please enter a value")
	@Min(value=1, message="Please enter a positive integer.")
	private int reviewId;
	
	@NotNull(message="Please enter a value")
	@Min(value=1, message="Please enter a positive integer.")
	private int restaurantId;
	
	private String restaurantName;
	
	@Size(min=4, max=16, message="Please enter between 4 and 16 characters.")
	private String userId;
	
	@Past(message="Please enter a date before today.")
	private Date visitDate;
	
	@NotNull(message="Please enter a value")
	@Min(value=1, message="Please enter a value between 1 and 5.")
	@Max(value=5, message="Please enter a value between 1 and 5.")
	private int rating;
	
	@Size(min=1, max=128, message="Please enter between 1 and 128 characters.")
	private String comment;

}