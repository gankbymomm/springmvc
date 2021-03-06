package com.laptrinhjavaweb.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.laptrinhjavaweb.dto.MyUser;

public class SecurityUtils {

	public static MyUser getPrincipal() {
		MyUser myUser = (MyUser) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		return myUser;
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities(){
		List<String> results = new ArrayList<>();
		List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		for (GrantedAuthority grantedAuthority : grantedAuthorities) {
			results.add(grantedAuthority.getAuthority());
		}
		return results;
	}
}
