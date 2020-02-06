package it.beije.cilacap.rubrica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MyRubricaJpa {

	@SuppressWarnings("unchecked")
	public static List<Contatto> leggiContatti() { // preleva da DB tutti i contatti. [Hibernate]

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();

		// esempio query JPQL
		String jpql = "SELECT c FROM Contatto as c";
		Query query = entityManager.createQuery(jpql);
		List<Contatto> listaContatti = query.getResultList();
		System.out.println(listaContatti.size());
		return listaContatti;
	}	
	

	public static void readFromDBWriteInCSV() throws Exception {
		List<Contatto> listaContatti = MyRubricaJpa.leggiContatti();
		Utility.esportaRubricaInCSV(Utility.choosePath(false), listaContatti);
		System.out.println("### Scrittura In File CSV effettuata con Successo ! ! !");
	}

	public static void readFromDBWriteInXML() throws Exception {
		List<Contatto> listaContatti = MyRubricaJpa.leggiContatti();
		Utility.esportaRubricaInXML(Utility.choosePath(true), listaContatti);
		System.out.println("### Scrittura In File XML effettuata con Successo ! ! !");
	}

	public static void writeInDBFromCSV() throws Exception {
		List<Contatto> listaContatti = Utility.caricaContattiDaCSV(Utility.choosePath(false));
		// INSERT
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		
		for (Contatto c : listaContatti) {
			entityManager.persist(c);
		}
		entityManager.getTransaction().commit();
		entityManager.close();

		System.out.println("### Scrittura In DB effettuata con Successo ! ! !");

	}

	public static void writeInDBFromXML() throws Exception {
		List<Contatto> listaContatti = Utility.caricaContattiDaXML(Utility.choosePath(true));

		// INSERT
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		
		for (Contatto c : listaContatti) {
			entityManager.persist(c);
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("### Scrittura In DB effettuata con Successo ! ! !");
	}
}
