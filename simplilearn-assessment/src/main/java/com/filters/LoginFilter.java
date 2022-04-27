package com.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter(urlPatterns = { "/LoginFilter" }, servletNames = { "com.dao.LoginDAO" })
public class LoginFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String email = request.getParameter("email");
		String emailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		String password = request.getParameter("password");
		if(!email.matches(emailRegex)) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("login.html").include(request,response);
			out.print("<script>");
			out.print("document.getElementById('error').innerHTML = 'Invalid Email'");
			out.print("</script>");
			out.print("<script>");
			out.print("document.getElementById('email').value = '"+email+"'");
			out.print("</script>");
			out.print("<script>");
			out.print("document.getElementById('password').value = '"+password+"'");
			out.print("</script>");
		} else {
			chain.doFilter(request, response);			
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}
