package com.fly_project;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.fly_project.entity.air;
import com.fly_project.entity.book;

@WebServlet("/airlist")
public class airlist extends HttpServlet{
     static long id;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		String to = req.getParameter("to").toLowerCase();
		String frm = req.getParameter("from").toLowerCase();
		String dob= req.getParameter("bdate");
		BigInteger nop= new BigInteger(req.getParameter("nop"));
        StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metadata= new MetadataSources(registry).getMetadataBuilder().build();
		
	    SessionFactory factory= metadata.getSessionFactoryBuilder().build();
	    
	    Session session=factory.openSession();
    	
	    resp.setContentType("text/html");
	    
	    Query query=session.createQuery("from air where desti=?1 and arr=?2");
	    query.setString(1, to);
	    query.setString(2, frm);
	    List<air> St=query.list();
	    out.print("<h1>The List Flights Are</h1>");
	    out.print("<table border=1 cellSpacing=0 cellpadding=10>");
	    out.print("<tr><th>Id</th> <th>Name of Flight</th><th>Dest</th><th>Arr</th><th> D_Time</th><th>A_Time</th><th>Price</th><th>Capacity</th><th>Mode</th><th>Buy</th></tr>\r\n"
	    		+ "");
	    for(air as:St) {

	    	out.print("<tr><td>" +as.getAid()+ "</td><td>"+as.getAname()+"</td><td>"+as.getDesti()+
	    			" </td><td>"+as.getArr()+"</td><td>"+as.getD_time()+"</td><td>"+as.getA_time()
	    			+"</td><td>"+as.getPrice()+"</td><td>"+as.getCapacity()+"</td><td>"+as.getMode()+"</td><td><a href='useradd.html'>Buy Now</a></td></tr>");
	     
	    }
	    out.print("</table>");
	}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
	
}
