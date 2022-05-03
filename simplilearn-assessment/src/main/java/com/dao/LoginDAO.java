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

import com.entity.User;

@WebServlet("/LoginDAO")
public class LoginDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession();
		if(s.getAttribute("flightID")!=null) {
			request.getRequestDispatcher("booking.jsp").forward(request, response);
			return;
		}
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(com.entity.User.class);
		StandardServiceRegistryBuilder ssr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(ssr.build());
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		PrintWriter out = response.getWriter();
		User user = session.get(com.entity.User.class, email);
		if(user == null) {
			request.getRequestDispatcher("login.html").include(request, response);
			out.print("<script>");
			out.print("document.getElementById('error').innerHTML = 'User does not exists'");
			out.print("</script>");
			out.print("<script>");
			out.print("document.getElementById('email').value = '"+email+"'");
			out.print("</script>");
			out.print("<script>");
			out.print("document.getElementById('password').value = '"+password+"'");
			out.print("</script>");
		}else if (!password.equals(user.getPassword())) {
			request.getRequestDispatcher("login.html").include(request, response);
			out.print("<script>");
			out.print("document.getElementById('error').innerHTML = 'Incorrect Password'");
			out.print("</script>");
			out.print("<script>");
			out.print("document.getElementById('email').value = '"+email+"'");
			out.print("</script>");
			out.print("<script>");
			out.print("document.getElementById('password').value = '"+password+"'");
			out.print("</script>");
		}else {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", user);
			request.getRequestDispatcher("searchflights.jsp").forward(request, response);
		}
		t.commit();
		session.close();
	}

}
