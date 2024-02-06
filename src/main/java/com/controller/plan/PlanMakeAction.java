package com.controller.plan;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.controller.plan.Action;
import com.controller.plan.ActionForward;
import com.model.plan.PlanMakeService;
import com.model.plan.PlanMakeDTO;

public class PlanMakeAction implements Action {

	@Autowired
	@Qualifier("com.model.plan.PlanServiceImpl")
	private PlanMakeService service;

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("PlanMakeAction 도착");
		ActionForward forward = new ActionForward();
		List<PlanMakeDTO> planmakelist = null;
		
		String region = req.getParameter("region");
		System.out.println("region : " + region);
		
		int areacode = 0;
		int sigungucode = 0;
		
		switch (region) {
			case "chuncheon":
				areacode = 32;
				sigungucode = 13;
				planmakelist = service.getPlanMakeList(areacode, sigungucode);
				break;
				
			case "busan":
				areacode = 6;
				planmakelist = service.getPlanMakeListByAreaCode(areacode);
				break;
				
			case "daegu":
				areacode = 4;
				planmakelist = service.getPlanMakeListByAreaCode(areacode);
				break;
				
			case "gangneung":
				areacode = 32;
				sigungucode = 1;
				planmakelist = service.getPlanMakeList(areacode, sigungucode);
				break;
				
			case "gyeongju":
				areacode = 35;
				sigungucode = 2;
				planmakelist = service.getPlanMakeList(areacode, sigungucode);
				break;
				
			case "incheon":
				areacode = 2;
				planmakelist = service.getPlanMakeListByAreaCode(areacode);
				break;
				
			case "jeju":
				areacode = 39;
				planmakelist = service.getPlanMakeListByAreaCode(areacode);
				break;
				
			case "jeonju":
				areacode = 37;
				sigungucode = 12;
				planmakelist = service.getPlanMakeList(areacode, sigungucode);
				break;
				
			case "seoul":
				areacode = 1;
				planmakelist = service.getPlanMakeListByAreaCode(areacode);
				break;
				
			case "sokcho":
				areacode = 32;
				sigungucode = 5;
				planmakelist = service.getPlanMakeList(areacode, sigungucode);
				break;
				
			case "yeongwol":
				areacode = 32;
				sigungucode = 8;
				planmakelist = service.getPlanMakeList(areacode, sigungucode);
				break;
				
			case "yeosu":
				areacode = 38;
				sigungucode = 13;
				planmakelist = service.getPlanMakeList(areacode, sigungucode);
				break;
		}
		
		System.out.println("areacode : " + areacode);
		System.out.println("sigungucode : " + sigungucode);
		
		
		req.setAttribute("planmakelist", planmakelist);
		forward.setRedirect(false);
		forward.setPath( req.getContextPath() + "plan/make_plan.jsp");
		
		return forward;
	}
}
