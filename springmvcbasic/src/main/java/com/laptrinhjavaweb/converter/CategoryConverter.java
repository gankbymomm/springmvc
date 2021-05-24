package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;

@Component
public class CategoryConverter {
	
	public CategoryDTO toDto(CategoryEntity entities) {
		ModelMapper modelMapper = new ModelMapper();
		CategoryDTO categoryDTO = modelMapper.map(entities, CategoryDTO.class);
		return categoryDTO;
	}

	public CategoryEntity toEntity(CategoryDTO categoryDto) {
		ModelMapper modelMapper = new ModelMapper();
		CategoryEntity categoryEntity = modelMapper.map(categoryDto, CategoryEntity.class);
		return categoryEntity;
	}
}
