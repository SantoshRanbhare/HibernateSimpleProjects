package com.jsp.ads.service;

import java.io.IOException;

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

@WebServlet("/updateMobile")
public class Hibernate_UpdateMobileOnId extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		   int mobileId =  Integer.parseInt(req.getParameter("mobileId"));
		   
		   Configuration cfg = new Configuration().configure().addAnnotatedClass(Mobile.class);
		   SessionFactory sf = cfg.buildSessionFactory();
		   Session session = sf.openSession();
		   Transaction tran = session.beginTransaction();
				   
		   Mobile mobile = session.get(Mobile.class, mobileId);
		   
		   req.setAttribute("mobile", mobile);
		   RequestDispatcher rd = req.getRequestDispatcher("UpdateMobile.jsp");
		   rd.include(req, resp);
		   
		   tran.commit();
		   sf.close();
	}
}
