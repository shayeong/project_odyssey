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

public class PlanSaveAction implements Action {

	@Autowired
	@Qualifier("com.model.plan.PlanServiceImpl")
	private PlanMakeService service;

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("PlanSaveAction 도착");
		ActionForward forward = new ActionForward();
		// PlanMakeDAO pdao = new PlanMakeDAO();
		
		String test = req.getParameter("li4");
		System.out.println("test : " + test);
		
		
		forward.setRedirect(false);
//		forward.setPath( req.getContextPath() + "plan/make_plan.jsp");
		
		return forward;
	}
}
