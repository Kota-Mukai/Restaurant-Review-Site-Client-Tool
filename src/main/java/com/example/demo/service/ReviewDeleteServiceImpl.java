package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.ReviewRepository;
import com.example.demo.entity.Review;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewDeleteServiceImpl implements ReviewDeleteService {
	
	private final ReviewRepository repository;

	@Override
	public void delete(Review review) {
		
		repository.remove(review);

	}

}