package it.beije.cilacap.rubrica;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaMethods {

	public static List<Contatto> leggiContatti() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();

		String jpql = "SELECT c FROM Contatto as c";
		Query query = entityManager.createQuery(jpql);
		List<Contatto> contatti = query.getResultList();
		System.out.println(contatti.size());

		for (Contatto contatto : contatti) {
			System.out.println("id : " + contatto.getId());
			System.out.println("nome : " + contatto.getNome());
			System.out.println("cognome : " + contatto.getCognome());
			System.out.println("telefono : " + contatto.getTelefono());
			System.out.println("email : " + contatto.getEmail());
		}
		return contatti;
	}

	public static void inserisciContatti(List<Contatto> listaContatti)
			throws java.sql.SQLIntegrityConstraintViolationException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();
		for (int i = 0; i < listaContatti.size(); i++) {
			Contatto contatto = listaContatti.get(i);
			entityManager.persist(contatto);

		}
		entityManager.getTransaction().commit();
		entityManager.close();

	}
	
//	public static void aggiornaContatti(List<Contatto> listaContatti) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
//		EntityManager entityManager = factory.createEntityManager();
//		Contatto contatto=null;
//		for(int i =0; i<listaContatti.size();i++) {
//		contatto=entityManager.find(Contatto.class, i);
//		
//		}
//	
//	}
}
