package it.beije.cilacap.esercizi.myRubrica;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HibernateRubricaUtil {
	
	// read from DB and populate a list of Contatto
	public static List<Contatto2> readListOfContactsFromDB() {		
		Configuration configuration = new Configuration();
		configuration = configuration.configure()
				.addAnnotatedClass(Contatto2.class);
		
		//chiedo generatore di sessioni
		SessionFactory factory = configuration.buildSessionFactory();
		
		System.out.println("is open? " + factory.isOpen());
		
		//apro sessione
		Session session = factory.openSession();
		System.out.println("session is open? " + session.isOpen());

		//esempio query HQL
		String hql = "SELECT c FROM Contatto as c";
		Query<Contatto2> query = session.createQuery(hql);
		System.out.println(query.list().size());
		return query.list();
	}
	

	// write a list of contacts on db
	public static void writeListOfContactsOnDB(List<Contatto2> lista) {

		Configuration configuration = new Configuration();
		configuration = configuration.configure()
				.addAnnotatedClass(Contatto2.class);

		//chiedo generatore di sessioni
		SessionFactory factory = configuration.buildSessionFactory();

		System.out.println("is open? " + factory.isOpen());

		//apro sessione
		Session session = factory.openSession();
		System.out.println("session is open? " + session.isOpen());


		//esempio INSERT
		for(Contatto2 contatto : lista) {
			Transaction transaction = session.beginTransaction();
			session.save(contatto);
			transaction.commit();
		}

		session.close();
		System.out.println("Inserimento in db avveuto correttamente!!!");

	}

	// write a single contact on db
	public static void writeSingleContactOnDB(Contatto2 contatto) {

		Configuration configuration = new Configuration();
		configuration = configuration.configure()
				.addAnnotatedClass(Contatto2.class);

		//chiedo generatore di sessioni
		SessionFactory factory = configuration.buildSessionFactory();

		System.out.println("is open? " + factory.isOpen());

		//apro sessione
		Session session = factory.openSession();
		System.out.println("session is open? " + session.isOpen());

		//esempio INSERT
		Transaction transaction = session.beginTransaction();
		session.save(contatto);
		transaction.commit();

		session.close();
		System.out.println("Inserimento in db del singolo contatto avveuto correttamente!!!");

	}

	public static void main(String[] args) throws Exception {
		String pathXml = "C:\\Users\\Padawan04\\Desktop\\newRubrica.xml";
		String csvPath = "C:\\Users\\Padawan04\\Desktop\\rubricaNew.csv";
		
		// read from XML and write in DB		
//		writeListOfContactsOnDB(ParserXML.getContattiFromFile(pathXml));
		
		// read from CSV and write in DB
//		writeListOfContactsOnDB(MyRubrica.caricaArrayListDiContattiFromCSV(csvPath));
		
		// write in DB of a single Contatto
		Contatto2 c = new Contatto2();
		c.setNome("Fiorenza");
		c.setCognome("Volpe");
		c.setTelefono("00000000");
		c.setEmail("fiorenza@volpe.it");
//		writeSingleContactOnDB(c);
		
		// read from DB and put all contacts in a list
//		readListOfContactsFromDB();

	}

}
