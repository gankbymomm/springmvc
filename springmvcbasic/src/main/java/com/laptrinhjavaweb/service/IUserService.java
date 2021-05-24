package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.laptrinhjavaweb.dto.UserDTO;

public interface IUserService extends UserDetailsService {
	List<UserDTO> findAll(Pageable pageable);
    UserDTO save(UserDTO user);
    UserDTO findByUserName(String name);
    int getTotalUser();
}
