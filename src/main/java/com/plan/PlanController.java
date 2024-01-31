package com.plan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlanController {
	@GetMapping("/plan/create")
	public String create() {

		return "/plan/create";
	}

}
