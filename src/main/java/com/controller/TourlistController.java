package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.controller.plan.AddTourlistAction;
import com.controller.plan.ActionForward;

@Controller
@WebServlet("/tour/lib.to")
public class TourlistController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("???");
		String requestURI = req.getRequestURI();
		ActionForward forward = null;
		
		String command = req.getParameter("command");
		
		if( command.equals("list") ) {
			resp.sendRedirect("/tour/tourlist.jsp");
		} else if( command.equals("tourlistdb") ) {
			forward = new AddTourlistAction().execute(req, resp);			
		}
		System.out.println("여까진 왓나?");
		if( forward != null ) {
			if( forward.isRedirect() ) {	// redirect
				resp.sendRedirect(forward.getPath());
			} else {						// forward
				RequestDispatcher disp = req.getRequestDispatcher(forward.getPath());
				disp.forward(req, resp);
			}
		}
	}
	
}
