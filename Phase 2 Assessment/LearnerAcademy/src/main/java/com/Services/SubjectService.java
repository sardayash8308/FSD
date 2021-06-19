package com.Services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ImpFiles.HibernateUtil;
import com.Models.Subject;
import com.Models.Teacher;
import com.Models.Class;

public class SubjectService {
	static SessionFactory fact = null;
	static Session se;
	public static void addSubject(String subject_name,Class cls,Teacher teacher) {
		fact = HibernateUtil.getFactory();
		se = fact.openSession();
		se.beginTransaction();
		Subject a = new Subject(subject_name);
//		String qt = "From Teacher T where T.teacherName = "+teacher;
//		String qc = "From Class C where C.className = "+cls;
//		Teacher t = se.createQuery(qt,Teacher.class).uniqueResult();
//		Class c = se.createQuery(qc,Class.class).uniqueResult();
		a.setAssignedClass(cls);
		a.setTeacher(teacher);
		
		se.save(a);
		
		se.getTransaction().commit();
		se.close();
		HibernateUtil.shutdown(fact);
	}
	@SuppressWarnings("unchecked")
	public static List<Subject> getSubject() {
		List<Subject> subjects;
		fact = HibernateUtil.getFactory();
		se = fact.openSession();
		subjects = se.createQuery("From Subject").list();
		return subjects;
		
	}
}

