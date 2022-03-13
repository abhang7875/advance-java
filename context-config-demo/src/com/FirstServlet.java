package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		PrintWriter out = response.getWriter();
		out.print("<h1>Acessing Config parameter</h1><br>");
		out.print("SQL = "+config.getInitParameter("sql"));
		out.print("<br>Message: "+config.getInitParameter("message"));

		out.print("<br><br><h1>Acessing Context parameter</h1><br>");
		ServletContext context = getServletContext();
		out.print("Driver = "+context.getInitParameter("driver"));
		out.print("<br>URL: "+context.getInitParameter("url"));
	}

}
