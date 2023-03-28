package com.fly_project;


import java.io.IOException;
import java.io.PrintWriter;
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

import com.fly_project.entity.book;
import com.fly_project.entity.user;

@WebServlet("/usera")
public class addUser  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		String name= req.getParameter("name");
		BigInteger age=new BigInteger(req.getParameter("age"));
		String addr=req.getParameter("addr");
		String mob=req.getParameter("mob");
		BigInteger fid=new BigInteger(req.getParameter("fid"));
		String bdate= req.getParameter("bdate");
		BigInteger nop=new BigInteger(req.getParameter("nop"));
		
        StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metadata= new MetadataSources(registry).getMetadataBuilder().build();
		
	    SessionFactory factory= metadata.getSessionFactoryBuilder().build();
 
	    user u1=new user(name, age, addr, mob);
	    book b1=new book(u1, bdate, nop, fid);
	    Session session=factory.openSession();
		
		Transaction tx= session.beginTransaction();
		session.save(u1);
		session.save(b1);
		
		tx.commit();
		resp.sendRedirect("pay.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
