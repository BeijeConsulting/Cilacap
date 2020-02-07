package it.beije.cilacap.rubrica;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class JPDBtools {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
	
		//esempio SELECT
//		Contatto contatto = entityManager.find(Contatto.class, 1);
//		
//		System.out.println(contatto);
		
		
		//esempio INSERT
		Contatto contatto = new Contatto();
		contatto.setNome("Gianna");
		contatto.setCognome("Nanni");
		contatto.setEmail("gianna@nannino.it");
		contatto.setTelefono("3455661634");
		
		entityManager.getTransaction().begin();
		System.out.println("contatto id : " + contatto.getId());
		entityManager.persist(contatto);
		System.out.println("contatto id : " + contatto.getId());
		entityManager.getTransaction().commit();
		//entityManager.getTransaction().rollback();
		
		entityManager.close();
	}

}
