package com.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Membercontroller {
	@GetMapping("/member/mypage")
	public String member() {

		return "/member/mypage";
	}
	
	@GetMapping("/member/createForm")
	public String createForm() {

		return "/member/createForm";
	}
}
