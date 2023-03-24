package com.learn_academy;

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

import com.learn_academy.entity.classTab;
import com.learn_academy.entity.student;
import com.learn_academy.entity.subject;
import com.learn_academy.entity.teacher;

@WebServlet("/classadd")
public class classadd  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out= resp.getWriter();
		String std = req.getParameter("cstd");
		String ctime= req.getParameter("ctime");
		String sname= req.getParameter("sname");
		String subcode=req.getParameter("subcode");
		String tname=req.getParameter("tname");
		String email = req.getParameter("email");
		String tgender= req.getParameter("tgender");
		String mob=req.getParameter("mob");
		String name= req.getParameter("name");
		String gender= req.getParameter("gender");
		String dob=req.getParameter("dob");
		
        StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metadata= new MetadataSources(registry).getMetadataBuilder().build();
		
	    SessionFactory factory= metadata.getSessionFactoryBuilder().build();
	    
	    classTab ct= new classTab(std, ctime);
		
	    subject sub=new subject(sname, std, subcode, ct);
	    
	    teacher teach=new teacher(tname, email, tgender, mob, ct);
	    
	    student stu=new student(name, gender, std, dob, ct);
	    
	    
        Session session=factory.openSession();
		
		Transaction tx= session.beginTransaction();
		session.save(ct);
		session.save(sub);
		session.save(teach);
		session.save(stu);
		
		
		tx.commit();
		out.print("Record Enter Successfully");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
