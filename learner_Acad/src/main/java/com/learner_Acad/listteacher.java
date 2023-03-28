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
import com.learner_Acad.entity.teacher;

@WebServlet("/listteacher")
public class listteacher extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out= resp.getWriter();
		StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				
				Metadata metadata= new MetadataSources(registry).getMetadataBuilder().build();
				
			    SessionFactory factory= metadata.getSessionFactoryBuilder().build();
			    
			    Session session=factory.openSession();
			    resp.setContentType("text/html");
			    List<teacher> tl=session.createQuery("from teacher").list();
			    out.print("<br><br><h1>----Teacher List----</h1>");
			    
			    for(teacher t:tl) {
			    	out.print("<br> Teacher Id :"+t.getId()+"<br> Teacher name :"+t.getTname()+
			    			"<br> Email :"+t.getEmail()+"<br> Password"+t.getPass()
			    			+"<br> Gender :"+t.getGender()+"<br> Date of Birth"+t.getDob()
			    			+"<br> Mobile no :"+t.getMob()+"<br> Address :"+t.getAddress());
			    	out.print("<br>------------------------------------------------------------<br>");
			    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
