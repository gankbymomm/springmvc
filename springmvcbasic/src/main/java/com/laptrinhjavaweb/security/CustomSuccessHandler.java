package com.laptrinhjavaweb.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.utils.SecurityUtils;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	protected void handle(HttpServletRequest request,HttpServletResponse response, 
	        					Authentication authentication) throws IOException {

	    String targetUrl = determineTargetUrl(authentication);
	    if (response.isCommitted()) {
	    	return;
	    }

	    redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		List<String> role = SecurityUtils.getAuthorities();
		if (isAdmin(role)) {
			url = "/quan-tri/trang-chu";
		} else if (isUser(role)) {
			url = "/trang-chu";
		}
		return url;
	}
	
	public boolean isAdmin(List<String> role) {
		if (role.contains("ADMIN")) {
			return true;
		}
		return false;
	}
	
	public boolean isUser(List<String> role) {
		if (role.contains("USER")) {
			return true;
		}
		return false;
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
	
}
