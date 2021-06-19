package com.Services;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ImpFiles.HibernateUtil;
import com.Models.Class;
import com.Models.Student;
import com.Models.Subject;

public class StudentServices {
	static SessionFactory fact =null;

	
	public static void addStudent(String fname,String faname,String mname,String lname,Date dob,String add,String city,int id) {
		Class cls = null;
		Student st = new Student(fname,faname,mname,lname,dob,add,city,cls);
		if(fact==null) {
			fact = HibernateUtil.getFactory();
			Session se = fact.openSession();
			cls = se.get(Class.class, id);
			st.setCls(cls);
			se.beginTransaction();
			se.save(st);
			se.getTransaction().commit();
			se.close();
			HibernateUtil.shutdown(fact);
		}
		
	}
	public static void deleteStudent(Student st) {
		if(fact==null) {
			fact = HibernateUtil.getFactory();
			Session se =fact.openSession();
			se.createQuery("Delete Student from StudentTable where Student Id= "+st.getId());
			se.close();
		}
	}
	public static List<Student> findAll() {
//		SessionFactory factory = HibernateUtil.getFactory();
//        Session session = factory.openSession();
//
//        session.beginTransaction();
//        
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
//        criteria.from(Student.class);
//        List<Student> studentList = session.createQuery(criteria).getResultList();
//        
//        session.getTransaction().commit();
//        
//        session.close();
//        
//        return studentList;
		List<Student> stu;
		fact = HibernateUtil.getFactory();
		Session se = fact.openSession();
		stu = se.createQuery("From Student").list();
		return stu;
	}
}
