package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.MessageUtils;

@Controller
public class NewController {

	@Autowired
	private INewService newService;

	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IUserService userService;

	@Autowired
	private MessageUtils messageUtil;

	@RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	public ModelAndView listPage(@RequestParam("page") int page, @RequestParam("limit") int limit,
			HttpServletRequest request) {
		NewDTO model = new NewDTO();
		model.setPage(page);
		model.setLimit(limit);
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		ModelAndView mav = new ModelAndView("admin/news/list");
		model.setListResult(newService.findAll(pageable));
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editPage(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/news/edit");
		NewDTO model = new NewDTO();
		if (id != null) {
			model = newService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("model", model);
		return mav;
	}

	@RequestMapping(value = "/quan-tri/quan-ly-nguoi-dung", method = RequestMethod.GET)
	public ModelAndView listUser(@RequestParam("page") int page,@RequestParam("limit") int limit,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/listuser");
		UserDTO user = new UserDTO();
		user.setPage(page);
		user.setLimit(limit);
		Pageable pageable = new PageRequest(page - 1, limit);
		user.setTotalItem(userService.getTotalUser());
		user.setTotalPage((int) Math.ceil((double)user.getTotalItem() / user.getLimit()));
		user.setListResult(userService.findAll(pageable));
		mav.addObject("user", user);
		return mav;
	}
}
