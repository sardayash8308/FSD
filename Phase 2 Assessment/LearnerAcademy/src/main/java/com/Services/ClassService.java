package com.Services;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ImpFiles.HibernateUtil;
import com.Models.Class;

public class ClassService {
	static SessionFactory fact = null;
	static Session se;

	public static void addClass(Class a) {
		fact = HibernateUtil.getFactory();
		se = fact.openSession();
		se.beginTransaction();
		try {
			se.save(a);
			se.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		se.close();
		HibernateUtil.shutdown(fact);
	}
	public static List<Class> getClasses() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();

		session.beginTransaction();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Class> criteria = builder.createQuery(Class.class);
		criteria.from(Class.class);
		List<Class> classList = session.createQuery(criteria).getResultList();

		session.getTransaction().commit();

		session.close();

		return classList;
	}
	public static Class getClassByName(String name) {
		fact = HibernateUtil.getFactory();
		se = fact.openSession();
		String que = "from Class where Class.className = " + name;
		Class cls = se.createQuery(que, Class.class).uniqueResult();
		return cls;
	}
	public static Class getClassById(int id) {
		fact = HibernateUtil.getFactory();
		se = fact.openSession();
		return se.get(Class.class, id);
	}
}
