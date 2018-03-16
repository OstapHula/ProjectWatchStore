package ua.springboot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.springboot.web.domain.LoginRequest;
import ua.springboot.web.domain.RegisterRequest;
import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.mapper.UserMapper;
import ua.springboot.web.service.UserService;

@Controller
public class BaseController {
	
	@Autowired private UserService userService;
	
	@GetMapping({"/", "/home"})
	public String shoHome() {
		return "home";
	}
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("loginModel", new LoginRequest());
		return "login";
	}
	
	@PostMapping("/login")
	public String loginUser(@ModelAttribute("loginModel") UserEntity entity){
		userService.saveUser(entity);
		return "redirect:/";
	}
		
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("registerModel", new RegisterRequest());
		return "register";
	}
	
	@PostMapping("/register")
	public String createUser(@ModelAttribute("registerModel") @Valid RegisterRequest registerRequest,
			BindingResult result){
		if(result.hasErrors()) return "register";
		UserEntity entity = UserMapper.RegisterToUser(registerRequest);	
		userService.saveUser(entity);
		return "redirect:/";
	}
	
	
}
