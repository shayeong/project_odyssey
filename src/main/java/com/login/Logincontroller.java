package com.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Logincontroller {
	@GetMapping("/login/findPw")
	public String findPw() {

		return "/login/findPw";
	}

}
