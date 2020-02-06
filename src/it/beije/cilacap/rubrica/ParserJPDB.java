package it.beije.cilacap.rubrica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;

public class ParserJPDB {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
	private static EntityManager entityManager = factory.createEntityManager();
	
	public static List<Contatto> getContattiFromJPDB() {
		String selectAll = "SELECT * FROM Contatto";
		Query q = entityManager.createQuery(selectAll);
		List<Contatto> lista = q.getResultList();
		entityManager.close();
		return lista;
	}
	
	public static void writeContattiInJPDB(List<Contatto> list) {
		entityManager.getTransaction().begin();
		for(Contatto c : list) {
			try {
				entityManager.persist(c);
				entityManager.getTransaction().commit();
			}catch(ConstraintViolationException cve) {
				System.out.println("Contatto già presente");
				entityManager.clear();
			}catch(Exception e) {}
		}
		entityManager.close();
		factory.close();
	}

}
