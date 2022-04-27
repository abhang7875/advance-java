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

@WebFilter(urlPatterns = { "/RegisterFilter" }, servletNames = { "com.dao.RegisterDAO" })
public class RegisterFilter extends HttpFilter implements Filter {
	
	private static final long serialVersionUID = 1L;
	
	public void retainValues(PrintWriter out, String email,String password,String name,String country,String address,int age) {
		System.out.println("Retaining all the values");
		out.print("<script>");
		out.print("document.getElementById('registeremail').value = '"+email+"'");
		out.print("</script>");out.print("<script>");
		out.print("document.getElementById('name').value = '"+name+"'");
		out.print("</script>");out.print("<script>");
		out.print("document.getElementById('address').value = '"+address+"'");
		out.print("</script>");out.print("<script>");
		out.print("document.getElementById('age').value = '"+age+"'");
		out.print("</script>");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String email = request.getParameter("registeremail");
		String emailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		String password = request.getParameter("registerpassword");
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		int age = Integer.parseInt(request.getParameter("age"));
		if(email == null || !email.matches(emailRegex)) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("register.html").include(request,response);
			out.print("<script>");
			out.print("document.getElementById('error').innerHTML = 'Invalid Email'");
			out.print("</script>");
			retainValues(out, email, password, name, country, address, age);
		}else if(password == null || !password.matches(passwordRegex)) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("register.html").include(request,response);
			out.print("<script>");
			out.print("document.getElementById('error').innerHTML = 'Password must satisfy below criteria<br>"
					+ "*One Lowercase + Uppercase<br>"
					+ "*One digit<br>"
					+ "*One special character<br>'");
			out.print("</script>");
			retainValues(out, email, password, name, country, address, age);
		}else if(name == null || name.length() > 20 || name.length() < 3 || name.contains("[^A-Za-z]")) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("register.html").include(request,response);
			out.print("<script>");
			out.print("document.getElementById('error').innerHTML = 'Invalid Name<br>"
					+ "*Name must be consists of alphabets only and length of 3-20'");
			out.print("</script>");
			retainValues(out, email, password, name, country, address, age);
		}else if(country == null || country.equals("None")) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("register.html").include(request,response);
			out.print("<script>");
			out.print("document.getElementById('error').innerHTML = 'Please select your country'");
			out.print("</script>");
			retainValues(out, email, password, name, country, address, age);
		} else if(address == null || address.length() > 50) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("register.html").include(request,response);
			out.print("<script>");
			out.print("document.getElementById('error').innerHTML = 'Please Enter address and must be less that 50 characters'");
			out.print("</script>");
			retainValues(out, email, password, name, country, address, age);
		}else if(age <= 0 || age > 100) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("register.html").include(request,response);
			out.print("<script>");
			out.print("document.getElementById('error').innerHTML = 'Please enter valid age'");
			out.print("</script>");
			retainValues(out, email, password, name, country, address, age);
		}else {
			chain.doFilter(request, response);			
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
