package it.beije.cilacap.rubrica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPDBtools {

	public static List<Contatto> getContattoFromJPAHDB() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager em = factory.createEntityManager();
		
		String jpql = "SELECT c FROM Contatto as c";
		
		Query query = em.createQuery(jpql);
		List<Contatto> contatti = query.getResultList();
		
		return contatti;
	}
	
	public static void insertInJPAHDB(List<Contatto> contatti) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		for (Contatto contatto : contatti) {
			em.persist(contatto);
		}
			
		em.getTransaction().commit();

		em.close();
		System.out.println("Is session open? " + factory.isOpen());
	}
}
