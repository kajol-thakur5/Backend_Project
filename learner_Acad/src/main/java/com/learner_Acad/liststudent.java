package com.learner_Acad;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.learner_Acad.entity.student;

@WebServlet("/liststudent")
public class liststudent extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out= resp.getWriter();
StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metadata= new MetadataSources(registry).getMetadataBuilder().build();
		
	    SessionFactory factory= metadata.getSessionFactoryBuilder().build();
	    
	    Session session=factory.openSession();
	    resp.setContentType("text/html");
	    List<student> St=session.createQuery("from student").list();
	    out.print("<br><br><h1>Student List</h1><br><br>");
	    for(student s:St) {
	    	out.print("First Name: "+s.getFname()+"<br> Last Name: "+ s.getLname()+"<br> Gender :"+s.getGender());
	    	out.print("<br> Date of Birth :"+s.getDob()+"<br> Date of Joining :"+s.getDoj());
	    	out.print("<br> Address :"+s.getAddress()+"<br> Class :"+s.getStd()+"<br> Fees :"+s.getFees());
	    	out.print("<br>-------------------------------------------------------------<br>");
	    }
	    
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
	
}
