package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.ReviewRepository;
import com.example.demo.entity.Review;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewRegistServiceImpl implements ReviewRegistService {

	private final ReviewRepository repository;
	
	@Override
	public void regist(Review review) {
		
		repository.add(review);

	}

}