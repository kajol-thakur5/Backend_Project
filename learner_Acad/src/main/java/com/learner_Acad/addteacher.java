package com.learner_Acad;

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
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.learner_Acad.entity.teacher;

@WebServlet("/addteacher")
public class addteacher  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out= resp.getWriter();
		
		String tname= req.getParameter("tname");
		String email= req.getParameter("email");
		String pass= req.getParameter("pass");
		String gender= req.getParameter("gender");
		String dob=req.getParameter("dob");
		String mob=req.getParameter("mob");
		String address=req.getParameter("tadd");
		
        StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metadata= new MetadataSources(registry).getMetadataBuilder().build();
		
	    SessionFactory factory= metadata.getSessionFactoryBuilder().build();
	    
	    teacher t1= new teacher(tname, email, pass, gender, dob, mob, address);
	    
        Session session=factory.openSession();
		
		Transaction tx= session.beginTransaction();
		session.save(t1);
		
		tx.commit();
		out.print("Teacher Record Enter Successfully");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
