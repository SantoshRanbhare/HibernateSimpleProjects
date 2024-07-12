package com.jsp.ads.loginandregister;

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

@WebServlet("/registerUser")
public class ServiceClass extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName = req.getParameter("userName");
		String userMail = req.getParameter("userMail");
		String userPassword = req.getParameter("userPassword");
		
		Register register = new Register();
		register.setUserName(userName);
		register.setUserMail(userMail);
		register.setUserPassword(userPassword);
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Register.class);
		SessionFactory sf = cfg.buildSessionFactory();
	
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
	
		session.save(register);
		
		tran.commit();
		sf.close();
	}
}
