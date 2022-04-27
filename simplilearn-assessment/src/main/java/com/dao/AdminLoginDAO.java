package com.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.entity.Admin;

@WebServlet("/AdminLoginDAO")
public class AdminLoginDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(com.entity.Admin.class);
		StandardServiceRegistryBuilder ssr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(ssr.build());
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		PrintWriter out = response.getWriter();
		Admin admin = session.get(com.entity.Admin.class, email);
		if(admin == null) {
			request.getRequestDispatcher("index.html").include(request, response);
			out.print("<script>");
			out.print("window.alert('User does not exists')");
			out.print("</script>");
		}else if (!password.equals(admin.getPassword())) {
			request.getRequestDispatcher("index.html").include(request, response);
			out.print("<script>");
			out.print("window.alert('Incorrect Password')");
			out.print("</script>");
		}else {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("admin", admin);
			request.getRequestDispatcher("addFlight.jsp").forward(request, response);
		}
		t.commit();
		session.close();
	}

}
