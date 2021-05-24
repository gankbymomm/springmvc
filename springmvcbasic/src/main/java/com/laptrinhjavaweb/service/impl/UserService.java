package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.SetPassWordAndStatus;
import com.laptrinhjavaweb.converter.UserConveter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConveter userConverter;
	
	@Autowired
	private SetPassWordAndStatus setPassWordAndStatus;
	 
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUserName(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (RoleEntity role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassWord(),
				grantedAuthorities);
	}
	
	@Override
	@Transactional
	public UserDTO save(UserDTO user) {
		UserEntity userEntity = new UserEntity();
		userEntity = userConverter.toEntityv2(user);
		userEntity = setPassWordAndStatus.setFieldForNewRegistration(userEntity);
		return userConverter.toDtov2(userRepository.save(userEntity));
	}

	@Override
	public UserDTO findByUserName(String name) {
		return userConverter.toDto(userRepository.findByUserName(name));
	}

	@Override
	@Transactional
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> userDto = new ArrayList<>();
		List<UserEntity> userEntity = userRepository.findAll(pageable).getContent();
		for (UserEntity item : userEntity) {
			UserDTO user = userConverter.toDtov2(item);
			userDto.add(user);
		}
		return userDto;
	}

	@Override
	public int getTotalUser() {
		return (int) userRepository.count();
	}

}
