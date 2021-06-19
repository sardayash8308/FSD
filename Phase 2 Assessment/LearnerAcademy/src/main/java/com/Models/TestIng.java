package com.Models;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ImpFiles.HibernateUtil;
import com.Services.ClassService;
import com.Services.StudentServices;


public class TestIng {

	public static Scanner sc = new Scanner(System.in);
	public static Session session = null;
	public static SessionFactory factory =null;
	public static Configuration cfg = new Configuration();
	public static void main2(String[] args)  {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		//factory = HibernateUtil.getFactory();
		System.out.println(factory);
		session = factory.openSession();//Start new session
		session.beginTransaction();
		//factory = HibernateUtil.getFactory();
		if(factory==null)System.out.println("FActory is null");
		session = factory.openSession();
		session.beginTransaction();
		System.out.println("Transaction begin");
		Class c = new Class("A");
		Student st = new Student("Yash","Ramchandra","Yojana","Sarda",new Date("20-Apr-2000"),"Beed","Beed",c);
		session.save(c);
		session.save(st);
		// Can be committed by following two ways
		// Transaction is used only when you have to save or update data
		// To fetch data you don't need transaction
		session.getTransaction().commit();
		/* Or
		 * Transaction tran = session.getTransaction();
		 * tran.commit();
		 */
		
		// To fetch data get() and load is used

		//getStudentsList();
		List<Student> stl = StudentServices.findAll();
		System.out.println(stl.size());
		for(Student st1:stl) {
			System.out.println(st1);
			}
		List<Class> cl = ClassService.getClasses();
		System.out.println(cl.size());
		for(Class s:cl) {
			System.out.println(cl.size());
			System.out.println(s.getClassName());
		}
		System.out.println("Hello from class");
		Student st1 = session.get(Student.class, 1);
		System.out.println(st1);
		session.close();
		factory.close();
		
		
	}
		
	public static void addClass() {
		System.out.print("Enter Class Name : "); 
		String cls = sc.nextLine();   
		if (session.isOpen()) {
			Class c = new Class(cls);
			session.beginTransaction();
			session.save(c);
			session.getTransaction().commit();
			
		}
	}
	

}
