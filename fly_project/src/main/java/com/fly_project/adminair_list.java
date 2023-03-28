package com.fly_project;

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

import com.fly_project.entity.air;

@WebServlet("/airlistadmin")
public class adminair_list extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
        StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metadata= new MetadataSources(registry).getMetadataBuilder().build();
		
	    SessionFactory factory= metadata.getSessionFactoryBuilder().build();
	    
	    Session session=factory.openSession();
    	
	    resp.setContentType("text/html");
	    
	    List<air> St=session.createQuery("from air").list();
	    
         out.print("<h1>The List Flights Are</h1><br>");
	    out.print("<table border=1 cellSpacing=0 cellpadding=10>");
	    out.print("<tr><th>Id</th> <th>Name of Flight</th><th>Dest</th><th>Arr</th><th> D_Time</th><th>A_Time</th><th>Price</th><th>Capacity</th><th>Mode</th></tr>\r\n"
	    		+ "");
	    for(air as:St) {
	    	
	    	
	    	out.print("<tr><th>" +as.getAid()+ "</th><th>"+as.getAname()+"</th><th>"+as.getDesti()+
	    			" </th><th>"+as.getArr()+"</th><th>"+as.getD_time()+"</th><th>"+as.getA_time()
	    			+"</th><th>"+as.getPrice()+"</th><th>"+as.getCapacity()+"</th><th>"+as.getMode()+"</th></tr>");
	    } 	
		out.print("</table>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
