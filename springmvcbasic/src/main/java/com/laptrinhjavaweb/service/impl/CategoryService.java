package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.ICategoryService;

@Service("categoryService")
public class CategoryService implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Map<String, String> findAll() {
		Map<String, String> resutl = new HashMap<>();
		List<CategoryEntity> categories = categoryRepository.findAll();
		for (CategoryEntity items : categories) {
			resutl.put(items.getCode(), items.getName());
		}
		return resutl;
	}

}
