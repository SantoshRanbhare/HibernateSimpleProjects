package com.jsp.ads.javaquestions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	
    	Question question = new Question();
    	question.setQuestionId(101);
    	question.setQuestionName("What is Java");
    	
    	Answer answer = new Answer();
    	answer.setAnswerId(1);
    	answer.setAnswerName("Java is a High level ,object oriented ,platform independent programming language");
    	
    	// Adding Answer Object into Question Object
    	question.setAnswer(answer);
    	
//    	// Adding Question Object into Answer Object
//    	answer.setQuestion(question);
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class);
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tran = session.beginTransaction();
    	
    	session.save(question);
    	session.save(answer);
    	
    	tran.commit();
    	sf.close();
    	session.close();
    }
}
