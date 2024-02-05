package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlanController {
	@GetMapping("/plan/create")
	public String create() {

		return "/plan/create";
	}

	@GetMapping("/PlanMakeAction.pl")
    public String planMakeAction() {
        // PlanMakeAction의 execute 메서드 역할을 수행
        // 해당 메서드에서 로직을 수행하고 결과에 따라 다른 뷰를 반환하도록 구현
        return "plan/make_plan";
    }

    @GetMapping("/PlanSave.pl")
    public String planSaveAction() {
        // PlanSaveAction의 execute 메서드 역할을 수행
        // 해당 메서드에서 로직을 수행하고 결과에 따라 다른 뷰를 반환하도록 구현
        return "plan/save_plan";
    }
}
