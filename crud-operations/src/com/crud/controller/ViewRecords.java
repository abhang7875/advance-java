package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.model.Employee;
import com.crud.service.EmployeeDAO;

@WebServlet("/ViewRecords")
public class ViewRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		ArrayList<Employee> data = employeeDAO.getRecords();
		PrintWriter out = response.getWriter();
		out.print("<table border=1 style='border-collapse: collapse;'><thead><tr>"
				+ "<th>ID</th>"
				+ "<th>Name</th>"
				+ "</tr></thead>"
				+ "<tbody>");
		for(Employee e: data) {
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td></tr>");
		}
		out.print("</tbody></table><br><br>");
		out.print(data.size() +" rows selected.");
	}

}
