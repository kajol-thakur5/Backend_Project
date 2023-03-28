package com.learner_Acad;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.learner_Acad.entity.student;

@WebServlet("/student")
public class addstudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    
		PrintWriter out= resp.getWriter();
		
		String fname=req.getParameter("fname");
		String  lname= req.getParameter("lname");
		String  gender= req.getParameter("gender");
		String dob = req.getParameter("dob");
		String doj = req.getParameter("doj");
		String address = req.getParameter("sadd");
		String  std= req.getParameter("aclass");
		String fees =req.getParameter("fees");
		
		StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metadata= new MetadataSources(registry).getMetadataBuilder().build();
		
	    SessionFactory factory= metadata.getSessionFactoryBuilder().build();
		
	    student st1=new student(fname, lname, gender, dob, doj, address, std, new BigDecimal(fees));
		
         Session session=factory.openSession();
		
		Transaction tx= session.beginTransaction();
		session.save(st1);
		
		tx.commit();
		out.print("Student Record Enter Successfully");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
