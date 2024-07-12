package com.jsp.ads.service;

import java.io.IOException;

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

@WebServlet("/saveUpdateMobile")
public class Hibernate_SaveUpdateMobile extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int mobileId = Integer.parseInt(req.getParameter("mobileId"));
		String mobileModel = req.getParameter("mobileModel");
		String mobileBrand = req.getParameter("mobileBrand");
		String mobileRam = req.getParameter("mobileRam");
		String mobileRom = req.getParameter("mobileRom");
		int mobilePrice = Integer.parseInt(req.getParameter("mobilePrice"));
		
		Mobile mobile = new Mobile();
		mobile.setMobileId(mobileId);
		mobile.setMobileModel(mobileModel);
		mobile.setMobileBrand(mobileBrand);
		mobile.setMobileRam(mobileRam);
		mobile.setMobileRom(mobileRom);
		mobile.setMobilePrice(mobilePrice);
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Mobile.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		session.update(mobile);
		
		tran.commit();
		sf.close();
		
		resp.sendRedirect("DisplayAllMobile");
	}
}
