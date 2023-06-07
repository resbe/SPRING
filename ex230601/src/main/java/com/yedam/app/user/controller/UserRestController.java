package com.yedam.app.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.user.service.UserVO;

// @Controller
@RestController // 해당 컨트롤러의 모든 메서드는 데이터를 반환한다.
public class UserRestController {
	
	@PostMapping("insertUser")
	//@ResponseBody // 데이터를 반환하는 메서드 / @RestController를 사용시 없어도됨.
	public UserVO insertUser(UserVO userVO) {
		System.out.println("name : " + userVO.getName());
		System.out.println("age : " + userVO.getAge());
		return userVO;
	}
	
	@GetMapping("getHome")
	public String getHome() {
		return "home";
	}
}
