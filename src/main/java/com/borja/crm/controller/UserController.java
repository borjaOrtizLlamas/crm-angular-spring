package com.borja.crm.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.borja.crm.dto.UserLoginForm;

@Controller
@RequestMapping("login")
public class UserController {
	

	@RequestMapping(method = RequestMethod.GET)
	public String login(Map<String, Object> model){
		model.put("loginUser",new UserLoginForm()); 
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String loginPost(
			@ModelAttribute("loginUser") UserLoginForm user,
			Map<String, Object> model){

		return "login";
	}


}
