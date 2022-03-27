package com.crud.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.connection.Connector;
import com.crud.model.Employee;

public class EmployeeDAO {
	public int insertData(Employee employee) {
		int result = 0;
		try {
			Connection conn = Connector.getConnection();
			PreparedStatement stmt = conn.prepareStatement("Insert Into Employee values (?,?)");
			stmt.setInt(1, employee.getId());
			stmt.setString(2, employee.getName());
			result = stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Employee> getRecords(){
		ArrayList<Employee> output = new ArrayList<>();
		try {
			Connection conn = Connector.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet data = stmt.executeQuery("select * from Employee");
			while(data.next()) {
				output.add(new Employee(data.getInt("ID"),data.getString("Name")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return output;
	}
}
