package com.laptrinhjavaweb.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface ICategoryService {
	Map<String, String> findAll();
}
