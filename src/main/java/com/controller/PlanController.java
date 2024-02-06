package com.controller;

import com.model.plan.PlanDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.plan.PlanService;

@Controller
public class PlanController {

	@Autowired
	@Qualifier("com.model.plan.PlanServiceImpl")
	private PlanService service;

    @GetMapping("/PlanMakeAction.pl")
    public String makePlan(HttpServletRequest request) {
        
		// return "make_plan"; // 뷰 이름 반환
		
		List<PlanDTO> planmakelist = null;
		String region = request.getParameter("region");
		System.out.println("region : " + region);
		
		int areacode = 0;
		int sigungucode = 0;

		Map map = new HashMap();
		
		switch (region) {
			case "chuncheon":
				areacode = 32;
				sigungucode = 13;
				map.put("areacode", areacode);
				map.put("sigungucode", sigungucode);
				planmakelist = service.planMakelist(map);
				break;
				
			case "busan":
				areacode = 6;
				planmakelist = service.planMakelist_a(areacode);
				break;
				
			case "daegu":
				areacode = 4;
				planmakelist = service.planMakelist_a(areacode);
				break;
				
			case "gangneung":
				areacode = 32;
				sigungucode = 1;
				map.put("areacode", areacode);
				map.put("sigungucode", sigungucode);
				planmakelist = service.planMakelist(map);
				break;
				
			case "gyeongju":
				areacode = 35;
				sigungucode = 2;
				map.put("areacode", areacode);
				map.put("sigungucode", sigungucode);
				planmakelist = service.planMakelist(map);
				break;
				
			case "incheon":
				areacode = 2;
				planmakelist = service.planMakelist_a(areacode);
				break;
				
			case "jeju":
				areacode = 39;
				planmakelist = service.planMakelist_a(areacode);
				break;
				
			case "jeonju":
				areacode = 37;
				sigungucode = 12;
				map.put("areacode", areacode);
				map.put("sigungucode", sigungucode);
				planmakelist = service.planMakelist(map);
				break;
				
			case "seoul":
				areacode = 1;
				planmakelist = service.planMakelist_a(areacode);
				break;
				
			case "sokcho":
				areacode = 32;
				sigungucode = 5;
				map.put("areacode", areacode);
				map.put("sigungucode", sigungucode);
				planmakelist = service.planMakelist(map);
				break;
				
			case "yeongwol":
				areacode = 32;
				sigungucode = 8;
				map.put("areacode", areacode);
				map.put("sigungucode", sigungucode);
				planmakelist = service.planMakelist(map);
				break;
				
			case "yeosu":
				areacode = 38;
				sigungucode = 13;
				map.put("areacode", areacode);
				map.put("sigungucode", sigungucode);
				planmakelist = service.planMakelist(map);
				break;
		}
		
		System.out.println("areacode : " + areacode);
		System.out.println("sigungucode : " + sigungucode);
		
		request.setAttribute("planmakelist", planmakelist);
		
		return "/plan/make";
	}

	@GetMapping("/PlanSave.pl")
    public String savePlan(HttpServletRequest request) {

		System.out.println("PlanSaveAction 도착");
		String test = request.getParameter("li4");
		System.out.println("test : " + test);

		return "redirect:/plan/make";
	}

    // 다른 메서드 및 기능들을 추가할 수 있습니다.
}
