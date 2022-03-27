package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.Connector;

@WebServlet("/DataLoader")
public class DataLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DataLoader() {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection con=Connector.getConnection();
			Statement stmt=con.createStatement(); 
			ResultSet rs=stmt.executeQuery("select * from EMPLOYEE");
			int count = 0;
			PrintWriter out = response.getWriter();
			out.print("<table border=1 style='border-collapse: collapse;'><thead><tr>"
					+ "<th>ID</th>"
					+ "<th>Name</th>"
					+ "</tr></thead>"
					+ "<tbody>");
			while(rs.next()) {
				out.print("<tr><td>"+rs.getString("ID")+"</td><td>"+rs.getString("Name")+"</td></tr>");
				count++;
			}
			out.print("</tbody></table><br><br>");
			out.print(count+" rows selected.");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
