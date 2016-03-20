package Connection;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtill {
	 private static SessionFactory sessionFactory;

	    public static void createSessionFactory() {
	        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    }

	    public static Session getSession() {
	        return sessionFactory.openSession();
	    }

}
