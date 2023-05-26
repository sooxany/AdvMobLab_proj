package com.example.demo.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MemberController {
	// 생성자 주입
	private final UserService userService;  
	
	//회원가입 페이지 출력 요청
	@GetMapping("member/save")
	public String saveForm() {
		return "save";
	}
	
	@PostMapping("/member/save")
	public String save(@ModelAttribute UserDto userDto) {
		System.out.println("MemberController.save");
		System.out.println("userDto = " + userDto);
		userService.save(userDto);
		
		return "login";
	}
	
	@GetMapping("/member/login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("/member/login")
	public String login(@ModelAttribute UserDto userDto, HttpSession session) {
		UserDto loginResult = userService.login(userDto);
		if (loginResult != null) {
			// login 성공
			session.setAttribute("loginID", loginResult.getUserID());
			return "home";
			
		} else {
			// login 실패
			return "로그인 실패하셨습니다";
		}
	}

}
