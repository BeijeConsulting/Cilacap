package it.beije.cilacap.esercizi.myRubrica;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

public class JpaRubricaUtils {

	// read from DB with JPA
	public static void writeJPAListOfContactsIntoDB(List<Contatto2> lista) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();

		for(Contatto2 contatto : lista) {
			entityManager.getTransaction().begin();
			entityManager.persist(contatto);
			entityManager.getTransaction().commit();
		}
		
		System.out.println("Scrittura di " + lista.size() + " contatti!");

	}
	
	// write list of Contatto2 in DB with JPA
	@SuppressWarnings("unchecked")
	public static List<Contatto2> readJPAListOfContactsFromDB() {
		
		List<Contatto2> lista = new ArrayList<Contatto2>();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		String jpql = "SELECT c FROM Contatto as c";
		
		Query query = entityManager.createQuery(jpql);
		
		lista = query.getResultList();
		
		System.out.println("Lettura di " + lista.size() + " contatti!");
		
		return lista;
		
	}
	
	public static void main(String[] args) throws Exception {
		
		readJPAListOfContactsFromDB();
		
		writeJPAListOfContactsIntoDB(ParserXML.getContattiFromFile("C:\\Users\\Padawan04\\Desktop\\LaMiaRubrica.xml"));
		
	}

}
