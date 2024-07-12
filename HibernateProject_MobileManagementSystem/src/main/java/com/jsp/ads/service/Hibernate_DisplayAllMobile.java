package com.jsp.ads.service;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.ads.entity.Mobile;

@WebServlet("/DisplayAllMobile")
public class Hibernate_DisplayAllMobile extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		Configuration cfg = new Configuration().configure().addAnnotatedClass(Mobile.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction(); 


		Iterator<Mobile> mobileList = session.createQuery("from Mobile", Mobile.class).list().iterator();

		req.setAttribute("mobileList", mobileList);
		RequestDispatcher rd = req.getRequestDispatcher("DisplayAllMobile.jsp");
		rd.forward(req, resp);

		tran.commit();
		sf.close();
	}
}
