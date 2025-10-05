package com.example.demo.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class Review {
	
	private int reviewId; 
	private int restaurantId;
	private String userId;
	private Date visitDate;
	private int rating;
	private String comment;

}
