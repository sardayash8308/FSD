package com.Services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ImpFiles.HibernateUtil;
import com.Models.Teacher;

public class TeacherService {
	static SessionFactory fact = null;
	static Session se;
	public static void addTeacher(String a) {
		fact = HibernateUtil.getFactory();
		Teacher t =new Teacher(a);
		se = fact.openSession();
		se.beginTransaction();
		se.save(t);
		se.getTransaction().commit();
		se.close();
		HibernateUtil.shutdown(fact);
	}
	@SuppressWarnings("unchecked")
	public static List<Teacher> getTeacher() {
		List<Teacher> teachers;
		fact = HibernateUtil.getFactory();
		se = fact.openSession();
		teachers = se.createQuery("From Teacher").list();
		return teachers;
		
	}
}