package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.Connector;

@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			if(id == null || id.isEmpty()) {
				out.print("<span style='color:red'>Please enter ID</span>");
			}else if(name == null || name.isEmpty()) {
				out.print("<span style='color:red'>Please enter Name</span>");
			}else {
				Connection con=Connector.getConnection();
				Statement stmt= con.createStatement();
				stmt.executeQuery("Insert Into Employee values ("+id+",'"+name+"');");
				RequestDispatcher rd = request.getRequestDispatcher("DataLoader");
				rd.forward(request, response);
			}
		}catch(Exception e) {
			out.print("<span style='color:red'>Something went wrong..!! Please check your data once</span>");
		}
	}

}
