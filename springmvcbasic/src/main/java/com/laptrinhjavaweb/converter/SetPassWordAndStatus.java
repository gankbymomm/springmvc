package com.laptrinhjavaweb.converter;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.RoleRepository;

@Component
public class SetPassWordAndStatus {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public UserEntity setFieldForNewRegistration(UserEntity userEntity) {
		String password = encoder.encode(userEntity.getPassWord());
		String passwordconfirm = encoder.encode(userEntity.getPassWordConfirm());
		userEntity.setPassWord(password);
		userEntity.setPassWordConfirm(passwordconfirm);
		userEntity.setRoles(Arrays.asList(roleRepository.findByCode("USER")));
		userEntity.setStatus(SystemConstant.ACTIVE_STATUS);
		return userEntity;
	}
	
}
