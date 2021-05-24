package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

@Component
public class NewConverter {
	
	public NewDTO toDTO(NewEntity entity) {
		NewDTO newDto = new NewDTO();
		newDto.setId(entity.getId());
		newDto.setTitle(entity.getTitle());
		newDto.setShortDescription(entity.getShortDescription());
		newDto.setContent(entity.getContent());
		newDto.setThumbNail(entity.getThumbNail());
		newDto.setCategoryCode(entity.getCategory().getCode());
		return newDto;
	}
	
	public NewDTO toDTOv2(NewEntity entity) {
		ModelMapper modelMapper = new ModelMapper();
		NewDTO newDto = modelMapper.map(entity, NewDTO.class);
		return newDto;
	}
	
	public NewEntity toEntity(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		newEntity.setContent(newDTO.getContent());
		newEntity.setTitle(newDTO.getTitle());
		newEntity.setThumbNail(newDTO.getThumbNail());
		newEntity.setShortDescription(newDTO.getShortDescription());
		return newEntity;
	}
	
	public NewEntity toEntityv2(NewDTO newDTO) {
		ModelMapper modelMapper = new ModelMapper();
		NewEntity newEntity = modelMapper.map(newDTO, NewEntity.class);
		return newEntity;
	}
	
	public NewEntity toEntity(NewEntity newEntity, NewDTO newDTO) {
		newEntity.setContent(newDTO.getContent());
		newEntity.setTitle(newDTO.getTitle());
		newEntity.setThumbNail(newDTO.getThumbNail());
		newEntity.setShortDescription(newDTO.getShortDescription());
		return newEntity;
	}

}
