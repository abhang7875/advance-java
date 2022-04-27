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

@WebFilter(urlPatterns = { "/SearchFlightsFilter" }, servletNames = { "com.dao.SearchFlightsDAO" })
public class SearchFlightsFilter extends HttpFilter implements Filter {
	
	private static final long serialVersionUID = 1L;
	
	public void retainValues(PrintWriter out, String from,String to,String departOn,int nop) {
		System.out.println("Retaining all the values");
		out.print("<script>");
		out.print("document.getElementById('from').value = '"+from+"'");
		out.print("</script>");out.print("<script>");
		out.print("document.getElementById('to').value = '"+to+"'");
		out.print("</script>");out.print("<script>");
		out.print("document.getElementById('departOn').value = '"+departOn+"'");
		out.print("</script>");out.print("<script>");
		out.print("document.getElementById('numberofPersons').value = '"+nop+"'");
		out.print("</script>");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String departOn = request.getParameter("depart");
		int nop = Integer.parseInt(request.getParameter("persons"));
		if(from == null || from.isEmpty()) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("index.html").include(request,response);
			out.print("<script>");
			out.print("document.getElementById('error').innerHTML = 'Please Enter From'");
			out.print("</script>");
			retainValues(out, from, to, departOn, nop);
		}else if(to == null || to.isEmpty()) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("index.html").include(request,response);
			out.print("<script>");
			out.print("document.getElementById('error').innerHTML = 'Please Enter To'");
			out.print("</script>");
			retainValues(out, from, to, departOn, nop);
		}else if(departOn == null || departOn.isEmpty()) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("index.html").include(request,response);
			out.print("<script>");
			out.print("document.getElementById('error').innerHTML = 'Please select valid date for depart on'");
			out.print("</script>");
			retainValues(out, from, to, departOn, nop);
		}else if(nop <= 0 || nop > 10) {
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("index.html").include(request,response);
			out.print("<script>");
			out.print("document.getElementById('error').innerHTML = 'Please enter valid number of persons (1-10)'");
			out.print("</script>");
			retainValues(out, from, to, departOn, nop);
		}else {
			chain.doFilter(request, response);			
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
