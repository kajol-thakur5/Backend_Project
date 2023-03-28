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
import com.learner_Acad.entity.subject;

@WebServlet("/listsubject")
public class listsubject extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out= resp.getWriter();
		StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				
				Metadata metadata= new MetadataSources(registry).getMetadataBuilder().build();
				
			    SessionFactory factory= metadata.getSessionFactoryBuilder().build();
			    
			    Session session=factory.openSession();
			    resp.setContentType("text/html");
			    List<subject> St=session.createQuery("from subject").list();
			    out.print("<br><br><h1>Subject List</h1><br><br>");
			    out.print("<br>------------------------------------------------------------<br>");
				   
			    for(subject s:St) {
			    	out.print("<br>Subject id :"+s.getSubid()+" <br>");
			    	out.print("<br>Subject Name :"+s.getName()+"<br>");
			    	out.print("<br>Subject Class :"+s.getStd()+"<br>");
			    	out.print("<br>Subject Code :"+s.getSub_code()+"<br>");
			    	out.print("<br>------------------------------------------------------------<br>");
			    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
