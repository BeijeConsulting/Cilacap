package it.beije.cilacap.rubrica;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import static it.beije.cilacap.rubrica.DBManager.getHibernateConfiguration;

import java.util.List;

public class HibernateMethods {
	
	
	public static List<Contatto> leggiContatti() {

				Configuration configuration=getHibernateConfiguration();
				//chiedo generatore di sessioni
				
				SessionFactory factory = configuration.buildSessionFactory();
				
//				System.out.println("is open? " + factory.isOpen());
				
				//apro sessione
				Session session = factory.openSession();
				System.out.println("session is open? " + session.isOpen());
				
				
				//CE 20200204: creazione query per estrapolare tutti i contatti
				String hql = "SELECT c FROM Contatto as c";
				Query<Contatto> query = session.createQuery(hql);
				
				for (Contatto contatto : query.list()) {
						System.out.println("id : " + contatto.getId());
						System.out.println("nome : " + contatto.getNome());
						System.out.println("cognome : " + contatto.getCognome());
						System.out.println("telefono : " + contatto.getTelefono());
						System.out.println("email : " + contatto.getEmail());
					}
		
				return query.list();
		
	}
	
	public static void inserisciContatti(List <Contatto> listaContatti) {
		
		Configuration configuration= getHibernateConfiguration();
		SessionFactory factory = configuration.buildSessionFactory();
		
//		System.out.println("is open? " + factory.isOpen());
		
//		//apro sessione
//		Session session = factory.openSession();
//		System.out.println("session is open? " + session.isOpen());
//		
//		
//		//apro transazione
//				Transaction transaction = session.beginTransaction();
//			//apro sessione
		Session session = factory.openSession();
		System.out.println("session is open? " + session.isOpen());
		
		for(int i=0; i < listaContatti.size(); i++) {	
			//apro transazione
			Transaction transaction = session.beginTransaction();	
			session.save(listaContatti.get(i));
			transaction.commit();
		}
		session.close();

				
		
	}
	
	
	

}
