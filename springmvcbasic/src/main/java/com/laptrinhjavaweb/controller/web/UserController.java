package com.laptrinhjavaweb.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.MessageUtils;

@Controller
public class UserController {

//	@Autowired 
//	private UserValidator userValidator;
	 
	@Autowired
	private MessageUtils messageUtils;
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("sign-up");
		mav.addObject("user", new UserDTO());
		return mav;
	}

	
	  @RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	  public ModelAndView registration(@Valid @ModelAttribute("user") UserDTO user,Errors result, Model model,
			  								HttpServletRequest request, HttpServletResponse response) { 
//		  userValidator.validate(user, result); 	
		  ModelAndView mav = new ModelAndView("sign-up");
		  if (result.hasErrors()) {
			  return mav;
		  }
		  if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtils.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		  userService.save(user); 
		  mav.addObject("user", user);
		  return mav; 
	  }
	  
//	  @RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
//	  public String registration(@Valid @ModelAttribute("user") UserDTO user,Errors result, Model model,
//			  								HttpServletRequest request, HttpServletResponse response) { 
////		  userValidator.validate(user, result);
//		  if (result.hasErrors()) {
//			  return "redirect:/dang-ky?fail";
//		  }
//		  userService.save(user); 
//		  return "redirect:/dang-nhap?"; 
//	  }
	 
}
