package it.beije.cilacap.rubrica;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;


public class HDBtools {
	
	//public static void 

	public static void main(String[] args) {
		System.out.println("INIZIO");

		//Initialize configuration
		Configuration configuration = new Configuration();
		configuration = configuration.configure("it/beije/cilacap/rubrica/hibernate.cfg.xml")
				.addAnnotatedClass(Contatto.class);
		
		//Session generator
		SessionFactory factory = configuration.buildSessionFactory();
		
		System.out.println("Is it open? " + factory.isOpen());
		
		//Session opener
		Session session = factory.openSession();
		System.out.println("Is session open? " + session.isOpen());

		//Example - query HQL
		String hql = "SELECT c FROM Contatto as c WHERE cognome = 'rossi'";
		Query<Contatto> query = session.createQuery(hql);
		System.out.println(query.list().size());
		
		//Example - Criteria
//		Criteria criteria = session.createCriteria(Contatto.class);
//		criteria.add(Restrictions.eq("cognome", "rossi"));
//		List<Contatto> contatti = criteria.list();
		
		for (Contatto contatto : query.list()) {
		//for (Contatto contatto : contatti) {
			System.out.println("id : " + contatto.getId());
			System.out.println("nome : " + contatto.getNome());
			System.out.println("cognome : " + contatto.getCognome());
			System.out.println("telefono : " + contatto.getTelefono());
			System.out.println("email : " + contatto.getEmail());
		}
		
		//Transaction opener
		Transaction transaction = session.beginTransaction();
		
		//Example UPDATE
//		Contatto contatto = session.get(Contatto.class, 1);
//		System.out.println(contatto);
//		contatto.setTelefono("432432421243");
//		System.out.println(contatto);
		
		//Example INSERT
		Contatto contatto = new Contatto();
		contatto.setNome("Fiorenza");
		contatto.setCognome("Volpe");
		contatto.setEmail("fiore@volpe.it");
		contatto.setTelefono("34556616");

		System.out.println("id : " + contatto.getId());
		session.save(contatto);
		System.out.println("id : " + contatto.getId());

//		session.save(contatto);
		
		//Confirm of update in DB
		transaction.commit();
		
		//Cancel update in DB
//		transaction.rollback();
		
		//Session close
		session.close();
		System.out.println("Is session open? " + session.isOpen());

	}

	
}
