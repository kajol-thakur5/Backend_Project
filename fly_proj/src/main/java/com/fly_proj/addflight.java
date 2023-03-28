package com.fly_proj;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

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

import com.fly_proj.entity.airline;

@WebServlet("/flightadd")
public class addflight  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		String aname = req.getParameter("aname");
		String dest= req.getParameter("dest");
		String arr= req.getParameter("arr");
		String dt=req.getParameter("dt");
		String at= req.getParameter("at");
		BigInteger cap=new BigInteger(req.getParameter("cap"));
		String mode=req.getParameter("mode");
		BigDecimal price=new BigDecimal(req.getParameter("price"));
		
        StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metadata= new MetadataSources(registry).getMetadataBuilder().build();
		
	    SessionFactory factory= metadata.getSessionFactoryBuilder().build();
	    
	    airline al=new airline(aname, dest, arr, dt, at, cap, mode, price);
	    
        Session session=factory.openSession();
		
		Transaction tx= session.beginTransaction();
		session.save(al);
		
		tx.commit();
		out.print("Add Flight Detail Successfully");
	    
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

	
}
