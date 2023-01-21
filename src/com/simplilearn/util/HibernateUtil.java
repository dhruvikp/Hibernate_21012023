package com.simplilearn.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.EProduct;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory buildSessionFactory() {
		if (sessionFactory == null) {
			Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EProduct.class);
			sessionFactory = config.buildSessionFactory();
		}
		return sessionFactory;
	}
}
