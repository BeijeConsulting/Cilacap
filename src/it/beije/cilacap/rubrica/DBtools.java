package it.beije.cilacap.rubrica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.query.Query;


public class DBtools {
	public static String csvSplitBy=";";
	public static List<Contatto> leggiContatti() throws ClassNotFoundException, SQLException {
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		Connection connection = null;
		Statement stmt = null;
		
		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
			
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cilacap.rubrica");
			
			Contatto contatto = null;
			while (rs.next()) {
				contatto = new Contatto();
				contatto.setId(rs.getInt("id"));
	        	contatto.setNome(rs.getString("nome"));
	        	contatto.setCognome(rs.getString("cognome"));
	        	contatto.setTelefono(rs.getString("telefono"));
	        	contatto.setEmail(rs.getString("email"));
	        	
	        	System.out.println("id = " + contatto.getId());
	        	System.out.println("nome = " + contatto.getNome());
	        	System.out.println("cognome = " + contatto.getCognome());
	        	System.out.println("telefono = " + contatto.getTelefono());
	        	System.out.println("email = " + contatto.getEmail());
	        	
	        	contatti.add(contatto);
			}
			
		} catch (SQLException sqlEx) {
			System.out.println("PROBLEMA : " + sqlEx);
			throw sqlEx;
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException finEx) {
				System.out.println("PROBLEMA : " + finEx);
			}
		}
		
		System.out.println("contatti letti : " + contatti.size());
		
		return contatti;
	}
	public static void deleteContatto(Contatto c) throws ClassNotFoundException {
		Connection connection;
		Statement stmt=null;
		String sql;
		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
			int id=	c.getId();
			System.out.println(id);
			sql="delete from rubrica where id=" + id;
			stmt=connection.createStatement();
			stmt.execute(sql);
			connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		}
	public static boolean insertContatto(Contatto contatto) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean esito = false;
		
		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
			
//			StringBuilder insert = new StringBuilder("INSERT into cilacap.rubrica VALUES (null,")
//					.append('\'').append(contatto.getNome()).append("\',")
//					.append('\'').append(contatto.getCognome()).append("\',")
//					.append('\'').append(contatto.getTelefono()).append("\',")
//					.append('\'').append(contatto.getEmail()).append('t').append("\')");
//			System.out.println(insert.toString());
			pstmt = connection.prepareStatement("INSERT into cilacap.rubrica (nome,cognome,telefono,email) VALUES (?,?,?,?)");
			pstmt.setString(1, contatto.getNome());
			pstmt.setString(2, contatto.getCognome());
			pstmt.setString(3, contatto.getTelefono());
			pstmt.setString(4, contatto.getEmail());
			
			esito = pstmt.execute();
			System.out.println(pstmt.getUpdateCount());
			
			//pstmt.executeUpdate();
			
		} catch (SQLException sqlEx) {
			System.out.println("PROBLEMA : " + sqlEx);
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException finEx) {
				System.out.println("PROBLEMA : " + finEx);
			}
		}
		
		return esito;
	}
	public static void getXmlFromDatabase(String xmlPath) throws Exception{
		
		List<Contatto> lc= DBtools.leggiContatti();
		Methods.writeContattiInFileXml(lc, xmlPath);
		System.out.println("Xml creato correttamente!");
	}
	public static void getCsvFromDatabase(String csvPath)throws Exception{
		List<Contatto> lc= DBtools.leggiContatti();
		Methods.writeToCsvFile(Methods.getCsvListFromXmlFile(lc), csvSplitBy, csvPath);
	}
//    public static Query<Contatto> leggiContattiH()throws ClassNotFoundException, SQLException{
	// da errore in quanto ho importato query di persistance ed ho commentato import query hibernate che faceva conflitto.
//    	//inizializzo configurazione
//    	Configuration configuration = new Configuration();
//    	configuration = configuration.configure()
//    				.addAnnotatedClass(Contatto.class);
//    	//chiedo generatore di sessioni
//    	SessionFactory factory = configuration.buildSessionFactory();
//    			
//    	System.out.println("is open? " + factory.isOpen());
//    	//apro sessione
//    	Session session = factory.openSession();
//    	System.out.println("session is open? " + session.isOpen());
//    	String hql = "SELECT c FROM Contatto as c";
//    	Query<Contatto> query = session.createQuery(hql);
//    	for (Contatto contatto : query.list()) {
//    		System.out.println("id : " + contatto.getId());
//			System.out.println("nome : " + contatto.getNome());
//			System.out.println("cognome : " + contatto.getCognome());
//			System.out.println("telefono : " + contatto.getTelefono());
//			System.out.println("email : " + contatto.getEmail());
//    	}
//    	session.close();
//    	System.out.println("session is open? " + session.isOpen());
//    	return query;
//}
    public static boolean insertContattoH(Contatto contatto)throws ClassNotFoundException{
    	//inizializzo configurazione
    			Configuration configuration = new Configuration();
    			configuration = configuration.configure()
    					.addAnnotatedClass(Contatto.class);		
    			//chiedo generatore di sessioni
    			SessionFactory factory = configuration.buildSessionFactory();
    			
    			System.out.println("is open? " + factory.isOpen());
    			
    			//apro sessione
    			Session session = factory.openSession();
    			System.out.println("session is open? " + session.isOpen());
    			//apro transazione
    			Transaction transaction = session.beginTransaction();
    			System.out.println("id : " + contatto.getId());
    			session.save(contatto);
    			//confermo aggiornamento su DB
    			transaction.commit();
    			//chiudo la sessione
    			session.close();
    			System.out.println("session is open? " + session.isOpen());
    			return true;

    }
	public static void deleteContattoH(Contatto contatto)throws ClassNotFoundException{
		//inizializzo configurazione
				Configuration configuration = new Configuration();
				configuration = configuration.configure()
						.addAnnotatedClass(Contatto.class);
				//chiedo generatore di sessioni
				SessionFactory factory = configuration.buildSessionFactory();
				
				System.out.println("is open? " + factory.isOpen());
				
				//apro sessione
				Session session = factory.openSession();
				System.out.println("session is open? " + session.isOpen());
				//apro transazione
				Transaction transaction = session.beginTransaction();
				session.delete(contatto);
				transaction.commit();
				session.close();
				System.out.println("session is open? " + session.isOpen());
	}
	public static void updateContattoH(Integer idContatto) {
		Scanner read = new Scanner(System.in);
		//inizializzo configurazione
		Configuration configuration = new Configuration();
		configuration = configuration.configure()
				.addAnnotatedClass(Contatto.class);
		//chiedo generatore di sessioni
		SessionFactory factory = configuration.buildSessionFactory();
		
		System.out.println("is open? " + factory.isOpen());
		
		//apro sessione
		Session session = factory.openSession();
		System.out.println("session is open? " + session.isOpen());
		//apro transazione
		Transaction transaction = session.beginTransaction();
		Contatto contatto = session.get(Contatto.class, idContatto);
		System.out.println("Si desidera modificare il Nome?S/N?");
		if(read.nextLine().equalsIgnoreCase("s")) {
			System.out.println("Inserire il nuovo nome");
			contatto.setNome(read.nextLine());
		}
		System.out.println("Si desidera modificare il Cognome?S/N?");
		if(read.nextLine().equalsIgnoreCase("s")) {
			System.out.println("Inserire il nuovo cognome");
			contatto.setCognome(read.nextLine());
			}
		System.out.println("Si desidera modificare il Telefono?S/N?");
		if(read.nextLine().equalsIgnoreCase("s")) {
			System.out.println("Inserire il nuovo numero di telefono");
			contatto.setTelefono(read.nextLine());
		}
		System.out.println("Si desidera modificare la Mail?S/N?");
		if(read.nextLine().equalsIgnoreCase("s")) {
			System.out.println("Inserire la nuova mail");
			contatto.setEmail(read.nextLine());
		}
		session.save(contatto);
		transaction.commit();
		session.close();
		read.close();
		System.out.println("session is open? " + session.isOpen());
			
	}
	public static void leggiContattiJpa()throws ClassNotFoundException,SQLException{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
		String jpql= "select c from Contatto as c";
		TypedQuery<Contatto> query=entityManager.createQuery(jpql,Contatto.class);
		List<Contatto> contatti= query.getResultList();
		System.out.println(contatti.size());
		for (Contatto contatto: contatti) {
			System.out.println("id :"+contatto.getId());
			System.out.println("nome : "+contatto.getNome());
			System.out.println("congnome : "+contatto.getCognome());
			System.out.println("telefono : "+contatto.getTelefono());
			System.out.println("email : "+contatto.getEmail());
			System.out.println(contatto.getClass());
		}
	}
	public static  void insertContattoJpa(Contatto contatto ) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(contatto);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("Contatto inserito correttamente");
	}
//	public static void updateContattoJpa
//	public static void deleteContattoJpa
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		Scanner read= new Scanner(System.in);
		Contatto contatto= new Contatto();
		//insert contatto ok!!
//		System.out.println("Inserire un nuovo contatto? S/N?");
//		String quest= read.next();
//		while(quest.equalsIgnoreCase("s")) {
//			System.out.println("Inserire il nome");
//			contatto.setNome(read.next());
//			System.out.println("Inserire il cognome");
//			contatto.setCognome(read.next());
//			System.out.println("Inserire il telefono");
//			contatto.setTelefono(read.next());
//			System.out.println("Inserire il email");
//			contatto.setEmail(read.next());
//			System.out.println("Inserire un altro contatto? S/N?");
//			quest=read.next();	
//			insertContatto(contatto);
//		}
//		read.close();
		
		
//		Delete per id. ok!!
		contatto.setCognome("Brunato");
		contatto.setNome("Stefano");
		contatto.setTelefono("3481751833");
		contatto.setEmail("sb@gmail.com");
		contatto.setId(8);
//		deleteContatto(contatto);
//		System.out.println("contatto eliminato");

//		getXML from Database ok!!
//		try {
//			getXmlFromDatabase("C:\\Users\\Padawan07\\git\\Cilacap\\xml\\ExtractDatabase.xml");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	    leggiContattiH(); ok funziona!
//		insertContattoH(contatto);
//		deleteContattoH(contatto);
//		leggiContattiJpa(); funziona
		insertContattoJpa(contatto);
//		deleteContattoJpa();
		
	}
}

