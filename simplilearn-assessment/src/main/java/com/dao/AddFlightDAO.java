package com.dao;

import java.io.IOException;
import java.io.PrintWriter;

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


@WebServlet("/AddFlightDAO")
public class AddFlightDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String airlines = request.getParameter("airlines");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String departOn = request.getParameter("departOn");
		String arriveOn = request.getParameter("arriveOn");
		int numberOfSeats = Integer.parseInt(request.getParameter("numberOfSeats"));
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(com.entity.Flight.class);
		StandardServiceRegistryBuilder ssr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(ssr.build());
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Flight flight = new Flight();
		flight.setAirlines(airlines);
		flight.setArriveOn(arriveOn);
		flight.setDepartOn(departOn);
		flight.setFrom(from);
		flight.setNumberOfSeatsAvailable(numberOfSeats);
		flight.setTo(to);
		session.save(flight);
		t.commit();
		session.close();
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("addFlight.jsp").include(request, response);
		out.print("<script>");
		out.print("window.alert('Flight added successfully..!!')");
		out.print("</script>");
	}

}
