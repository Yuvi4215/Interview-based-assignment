package in.ineuron.Util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import in.ineuron.DTO.Products;

public class HibernateUtil {
	private static SessionFactory factory=null;
	
	private HibernateUtil() {
	}
	
	static{
	factory = new Configuration().configure().addAnnotatedClass(Products.class).buildSessionFactory();
	}

	public static Session getSession()  {
		return factory.openSession();
	}
	
	public static void closeSession(Session session) {
		if (session != null) 
			session.close();
	}

	public static void closeSessionFactory(SessionFactory sessionFactory) {
		if (sessionFactory != null) 
			sessionFactory.close();
	}
	public static void startup() {
		System.out.println("Hibernate Utill started ::");
	}

}
