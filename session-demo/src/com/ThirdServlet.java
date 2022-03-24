package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;

public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ThirdServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = null;
		HttpSession session = request.getSession(false);
		if(session != null) {
			user = (User)session.getAttribute("User");
			user.setCountry(request.getParameter("country"));
			user.setCity(request.getParameter("city"));
			
			PrintWriter out = response.getWriter();
			out.print("<h2>Hello, "+user.getFname()+" "+user.getLname()+"</h2>");
			out.print("<h3>Details: "+user+"</h3>");
			out.print("<h4>Session ID: "+session.getId()+"</h4>");
			out.print("<h4>Session created at: "+session.getCreationTime()+"</h4>");
			session.invalidate();
		}
	}

}
