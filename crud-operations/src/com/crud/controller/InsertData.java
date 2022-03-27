package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.model.Employee;
import com.crud.service.EmployeeDAO;


@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read data
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");

		PrintWriter out = response.getWriter();
		Employee employee = new Employee(id, name);
		EmployeeDAO dao = new EmployeeDAO();
		int result = dao.insertData(employee);
		if(result > 0) {
			out.print("<span style='color:green'>Data inserted successfully..!!</span>");
		}else {
			out.print("<span style='color:red'>Something went wrong..!!</span>");
			
		}
	}

}
