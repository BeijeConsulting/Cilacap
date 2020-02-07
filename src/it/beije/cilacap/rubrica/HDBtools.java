package it.beije.cilacap.rubrica;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;


public class HDBtools {
	
	private static Log logger = LogFactory.getLog(HDBtools.class);
	
	public static List<Contatto> getContactFromHDB() {
		
		logger.debug("INIZIO");
		
		//Configuration opener 
		Configuration configuration = new Configuration();
		configuration = configuration.configure("it/beije/cilacap/rubrica/hibernate.cfg.xml")
				.addAnnotatedClass(Contatto.class); // Specification of the used object
		
		//Session generator 
		SessionFactory factory = configuration.buildSessionFactory();
		System.out.println("Is it open? " + factory.isOpen());
		
		//Session opener
		Session session = factory.openSession();
		
		//Creation of the string with command in HQL dialect
		String hql = "SELECT c FROM Contatto as c";
		Query<Contatto> query = session.createQuery(hql);
		
		return query.list();
		
	}
	
	public static void insertInHDB(List<Contatto> contatti) {
		
		logger.debug("INIZIO");
		
		//Configuration opener 
		Configuration configuration = new Configuration();
		configuration = configuration.configure("it/beije/cilacap/rubrica/hibernate.cfg.xml")
				.addAnnotatedClass(Contatto.class); // Specification of object used
		
		//Session generator 
		SessionFactory factory = configuration.buildSessionFactory();
		System.out.println("Is it open? " + factory.isOpen());
		
		//Session opener
		Session session = factory.openSession();	
		
		//Transaction opener
		Transaction transaction = session.beginTransaction();
		
		//Example INSERT
//		Contatto contatto = new Contatto();
//		contatto.setNome("Marco");
//		contatto.setCognome("Polo");
//		contatto.setEmail("marco@polo.it");
//		contatto.setTelefono("34553567");
		
		//Saving each contact
		for (Contatto c : contatti) {
			session.save(c);
		}
		
		//Confirmation of insertion in DB	
		transaction.commit();
		
		//Session Closer
		session.close();
		System.out.println("Is session open? " + session.isOpen());
		factory.close();
		
		logger.debug("FINE");
		
	}
	
	public static void updateHDB(List<Contatto> contatti) {
		
logger.debug("INIZIO");
		
		//Configuration opener 
		Configuration configuration = new Configuration();
		configuration = configuration.configure("it/beije/cilacap/rubrica/hibernate.cfg.xml")
				.addAnnotatedClass(Contatto.class); // Specification of object used
		
		//Session generator 
		SessionFactory factory = configuration.buildSessionFactory();
		System.out.println("Is it open? " + factory.isOpen());
		
		//Session opener
		Session session = factory.openSession();	
		
		//Transaction opener
		Transaction transaction = session.beginTransaction();
		
		//Example UPDATE
		Contatto contatto = session.get(Contatto.class, 1);
		System.out.println(contatto);
		contatto.setTelefono("432432421243");
		System.out.println(contatto);
		
		System.out.println("id : " + contatto.getId());
		session.save(contatto);
		System.out.println("id : " + contatto.getId());
		
		//Confirm of update in DB
		transaction.commit();
		
		//Cancel update in DB
//		transaction.rollback();
		
		//Session close
		session.close();

		System.out.println("Is session open? " + session.isOpen());

		logger.debug("FINE");

	}
	
}
