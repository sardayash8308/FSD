package com.ImpFiles;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory getFactory() {
		SessionFactory factory = null;
		try {
//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
//		factory = cfg.buildSessionFactory();
		try {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
			
			factory = metadata.getSessionFactoryBuilder().build();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return factory;
		
	}
	public static void shutdown(SessionFactory factory) {
		if(factory!=null) {
			factory.close();
		}
	}
}
