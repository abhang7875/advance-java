package com.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.entity.Flight;

@WebServlet("/SearchFlightsDAO")
public class SearchFlightsDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String departOn = request.getParameter("depart");
		int nop = Integer.parseInt(request.getParameter("persons"));
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(com.entity.Flight.class);
		StandardServiceRegistryBuilder ssr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(ssr.build());
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from Flight as f where f.from =:from and f.to=:to and f.numberOfSeatsAvailable >=:persons");
		query.setParameter("from", from);
		query.setParameter("to", to);
		query.setParameter("persons", nop);
		List<Flight> data = query.getResultList(); 
		t.commit();
		request.getSession().setAttribute("data", data);
		request.getSession().setAttribute("noOfSeats", nop);
		request.getRequestDispatcher("showResults.jsp").forward(request, response);
	}

}
