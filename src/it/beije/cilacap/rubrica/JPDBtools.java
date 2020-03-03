package it.beije.cilacap.rubrica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPDBtools {

	
	public static List<Contatto> getContactsFromJPAHDB() {
		System.out.println("getContactsFromJPAHDB");
		
		//EntityManager creation
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager em = factory.createEntityManager();
		
		//Creation of the string with command in HQL dialect
		String jpql = "SELECT c FROM Contatto as c";
		String jpql2 = "SELECT c FROM Contatto as c WHERE cognome = 'rossi'";
		
		//Query creation
		Query query = em.createQuery(jpql);
		List<Contatto> contatti = query.getResultList();
		
		System.out.println(contatti.size());
//		for (Contatto contatto : contatti) {
//			System.out.println("id : " + contatto.getId());
//			System.out.println("nome : " + contatto.getNome());
//			System.out.println("cognome : " + contatto.getCognome());
//			System.out.println("telefono : " + contatto.getTelefono());
//			System.out.println("email : " + contatto.getEmail());
//		}
		
		em.close();
		
		return contatti;

	}
	
	public static void insertInJPAHDB(List<Contatto> contatti) {
		System.out.println("insertInJPAHDB");
		
		//EntityManager creation
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager em = factory.createEntityManager();
		
		//Transaction initiation
		em.getTransaction().begin();
		
		//Example Insert
		Contatto contatto = new Contatto();
		contatto.setNome("Gianna");
		contatto.setCognome("Nanni");
		contatto.setEmail("gianna@nannino.it");
		contatto.setTelefono("3455661634");
		em.persist(contatto);
				
//		for (Contatto contatto : contatti) {
//			System.out.println(contatto);
//			contatto.setId(null);
//			em.persist(contatto);
//		}
			
		//Confirmation of command on DB 
		em.getTransaction().commit();

		//Entity manager close
		em.close();
		System.out.println("Is session open? " + factory.isOpen());
	}
}
