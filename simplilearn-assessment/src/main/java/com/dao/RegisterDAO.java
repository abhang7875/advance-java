package com.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.User;

@WebServlet("/RegisterDAO")
public class RegisterDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		int age = Integer.parseInt(request.getParameter("age"));
		String country = request.getParameter("country");
		String email = request.getParameter("registeremail");
		String password = request.getParameter("registerpassword");
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources().getMetadataBuilder(ssr).build();
		SessionFactory factory = metadata.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		User user = new User();
		user.setName(name);
		user.setCountry(country);
		user.setPassword(password);
		user.setEmail(email);
		user.setAge(age);
		user.setAddress(address);
		session.save(user);
		t.commit();
		session.close();
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("user", user);
		request.getRequestDispatcher("searchflights.jsp").forward(request, response);
	}

}
