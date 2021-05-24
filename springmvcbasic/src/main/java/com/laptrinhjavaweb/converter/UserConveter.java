package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

@Component
public class UserConveter {
	
	public UserDTO toDto(UserEntity userEntity) {
		UserDTO user = new UserDTO();
		user.setFullName(userEntity.getFullName());
		user.setUserName(userEntity.getUserName());
		user.setPassWord(userEntity.getPassWord());
		user.setPassWordConfirm(userEntity.getPassWordConfirm());
		user.setStatus(userEntity.getStatus());
		return user;
	}
	
	public UserDTO toDtov2(UserEntity userEntity) {
		ModelMapper modelMapper = new ModelMapper();
		UserDTO user = modelMapper.map(userEntity, UserDTO.class);
		return user;
	}
	
	public UserEntity toEntity(UserDTO userDto) {
		UserEntity user = new UserEntity();
		user.setFullName(userDto.getFullName());
		user.setUserName(userDto.getUserName());
		user.setPassWord(userDto.getPassWord());
		user.setPassWordConfirm(userDto.getPassWordConfirm());
		user.setStatus(userDto.getStatus());
		return user;
	}
	
	public UserEntity toEntityv2(UserDTO userDto) {
		ModelMapper modelMapper = new ModelMapper();
		UserEntity user = modelMapper.map(userDto, UserEntity.class);
		return user;
	}
}
