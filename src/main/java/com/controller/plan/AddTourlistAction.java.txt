package com.controller.plan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.controller.plan.Action;
import com.controller.plan.ActionForward;
import com.model.plan.PlanMakeService;
import com.model.tour.TourlistDTO;
import com.model.tour.TourlistService;

public class AddTourlistAction implements Action {

	@Autowired
	@Qualifier("com.model.tour.TourlistServiceImpl")
	private TourlistService service;

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("AddTourlistAction 도착");
		ActionForward forward = new ActionForward();
		
//		tdao.delete();
		String[] Tourlist = req.getParameterValues("list");
		
		List<TourlistDTO> tdtos = new ArrayList<TourlistDTO>();
		
		for( int i = 0; i < Tourlist.length; i++ ) {
			String[] tmp = Tourlist[i].split(";");
			System.out.println(Arrays.toString(tmp));
			
			TourlistDTO tdto = new TourlistDTO(tmp[0], Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]), tmp[3], Integer.parseInt(tmp[4]), tmp[5]);
			
			tdtos.add(tdto);
			int cnt= service.addTourlist(tdto);
			System.out.println(cnt);
		}
		// int cnt = service.addTourlist(tdtos);
		// AddTourlist(tdtos);
		
		forward.setRedirect(true);
		forward.setPath( req.getContextPath() + "/tour/tourlist.jsp");
		
		return forward;
	}
}
