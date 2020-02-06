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

	public static void main(String[] args) {
		logger.debug("INIZIO");

		//inizializzo configurazione
		Configuration configuration = new Configuration();
		configuration = configuration.configure()
				.addAnnotatedClass(Contatto.class);
//				.addAnnotatedClass(altra classe)
		
		//chiedo generatore di sessioni
		SessionFactory factory = configuration.buildSessionFactory();
		
		System.out.println("is open? " + factory.isOpen());
		
		//apro sessione
		Session session = factory.openSession();
		System.out.println("session is open? " + session.isOpen());

		//esempio query HQL
//		String hql = "SELECT c FROM Contatto as c WHERE cognome = 'rossi'";
//		Query<Contatto> query = session.createQuery(hql);
//		System.out.println(query.list().size());
		
		//esempio Criteria
//		Criteria criteria = session.createCriteria(Contatto.class);
//		criteria.add(Restrictions.eq("cognome", "rossi"));
//		List<Contatto> contatti = criteria.list();
		
//		for (Contatto contatto : query.list()) {
//		for (Contatto contatto : contatti) {
//			System.out.println("id : " + contatto.getId());
//			System.out.println("nome : " + contatto.getNome());
//			System.out.println("cognome : " + contatto.getCognome());
//			System.out.println("telefono : " + contatto.getTelefono());
//			System.out.println("email : " + contatto.getEmail());
//		}
		
		//apro transazione
		Transaction transaction = session.beginTransaction();
		
		//esempio UPDATE
//		Contatto contatto = session.get(Contatto.class, 1);
//		System.out.println(contatto);
//		contatto.setTelefono("432432421243");
//		System.out.println(contatto);
		
		//esempio INSERT
		Contatto contatto = new Contatto();
		contatto.setNome("Fiorenza");
		contatto.setCognome("Volpe");
		contatto.setEmail("fiore@volpe.it");
		contatto.setTelefono("34556616");

		System.out.println("id : " + contatto.getId());
		session.save(contatto);
		System.out.println("id : " + contatto.getId());

//		session.save(contatto);
		
		//confermo aggiornamento su DB
		transaction.commit();
		
		//annullo aggiornamento su DB
//		transaction.rollback();
		
		//chiudo la sessione
		session.close();
		System.out.println("session is open? " + session.isOpen());
		
		logger.debug("FINE");
	}

}
