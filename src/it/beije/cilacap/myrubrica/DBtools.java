package it.beije.cilacap.myrubrica;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.beije.cilacap.esercizi.TextFileManager;
import it.beije.cilacap.rubrica.Contatti;

public class DBtools {	
	public static void main(String[] args) throws Exception {
		ArrayList <Contatti> ListaContattiCaricati = new ArrayList<Contatti>();
		List <Contatti> ListaContattiCaricatiXML = new ArrayList<Contatti>();
		List <Contatti> LeggiContattiDB = new ArrayList<Contatti>();
		ListaContattiCaricati = CaricareContattiCSV();
		ListaContattiCaricatiXML = CaricaContattiXML();
//		for(int i=0 ; i<ListaContattiCaricati.size();i++) {
//			//insertContatto(ListaContattiCaricati.get(i));
//			InserimentoHibernate(ListaContattiCaricati.get(i));
//		}
//		for(int i=0 ; i<ListaContattiCaricatiXML.size();i++) {
//			//insertContatto(ListaContattiCaricatiXML.get(i));
//			InserimentoHibernate(ListaContattiCaricatiXML.get(i));
//		}
		LetturaJPA();
//		LeggiContattiDB = leggiContattiDalDB();
//		writeContattiInFile(LeggiContattiDB, "PathdelFIleXML");
//		ScrivereContattiCsv(LeggiContattiDB);
		
		
	}
	public static List<Contatti> CaricaContattiXML() throws Exception {
		File file = new File("C:\\Users\\Padawan03\\Desktop\\EsCsv.xml");
		List<Contatti> listaContatti = new ArrayList<Contatti>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the
        // Document class.
        Document document = builder.parse(file);
        Element element = document.getDocumentElement();       
        System.out.println(element.getTagName());
        
        //System.out.println(element.getChildNodes().getLength());
        NodeList contatti = element.getElementsByTagName("contatto");
        System.out.println("contatti : " + contatti.getLength());

        for (int i = 0; i < contatti.getLength(); i++) {
        	Element utente = (Element)contatti.item(i);
        	System.out.println(utente.getTagName() + " " + i);
        	System.out.println("\tanni = " + utente.getAttribute("anni"));
 
        	Element nome = (Element)utente.getElementsByTagName("nome").item(0);
        	Element cognome = (Element)utente.getElementsByTagName("cognome").item(0);
        	Element telefono = (Element)utente.getElementsByTagName("telefono").item(0);
        	Element email = (Element)utente.getElementsByTagName("email").item(0);
        	
        	Contatti contatto = new Contatti();
        	contatto.setNome(nome.getTextContent());
        	contatto.setCognome(cognome.getTextContent());
        	contatto.setTelefono(telefono.getTextContent());
        	contatto.setEmail(email.getTextContent());
        	
        	System.out.println("\tnome = " + contatto.getNome());
        	System.out.println("\tcognome = " + contatto.getCognome());
        	System.out.println("\ttelefono = " + contatto.getTelefono());
        	System.out.println("\temail = " + contatto.getEmail());
        	
        	listaContatti.add(contatto);
        }
        
        return listaContatti;
	}

	public static ArrayList <Contatti> CaricareContattiCSV() throws IOException { 
		File file = new File("C:\\Users\\Padawan03\\Desktop\\EsCsv.csv");
		List <String> FileCaricato = TextFileManager.readFileRows(file);
		ArrayList <Contatti> ListaContattiCaricati = new ArrayList<Contatti>();
		String[] split;
		for(int i=1;i<FileCaricato.size();i++) {
			Contatti appoggio = new Contatti();
			split = FileCaricato.get(i).split(";");
			for(int i1=0;i1<split.length;i1++) {
				if(i1==0)
				appoggio.setNome(split[i1]);
				if(i1==1)
					appoggio.setCognome(split[i1]);
				if(i1==2)
					appoggio.setTelefono(split[i1]);
				if(i1==3)
					appoggio.setEmail(split[i1]);
				
			}
			ListaContattiCaricati.add(appoggio);
			
		}	
		return ListaContattiCaricati;
		
	}
	
	public static boolean insertContatto(Contatti contatto) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean esito = false;
		
		try {
			connection = it.beije.cilacap.myrubrica.DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
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
				finEx.printStackTrace();
			}
		}
		return esito;
	}
	public static List<Contatti> leggiContattiDalDB() throws ClassNotFoundException, SQLException {
		List<Contatti> contatti = new ArrayList<Contatti>();
		
		Connection connection = null;
		Statement stmt = null;
		
		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
			
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cilacap.rubrica");
			
			Contatti contatto = null;
			while (rs.next()) {
				contatto = new Contatti();
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
	
	public static void writeContattiInFile(List<Contatti> contatti, String pathfile) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.newDocument();
        Element docElement = document.createElement("rubrica");
        document.appendChild(docElement);
        
        for (Contatti c : contatti) {
        	Element contatto = document.createElement("contatto");
        	Element nome = document.createElement("nome");
        	Element cognome = document.createElement("cognome");
        	Element telefono = document.createElement("telefono");
        	Element email = document.createElement("email");
        	
        	nome.setTextContent(c.getNome());
        	cognome.setTextContent(c.getCognome());
        	telefono.setTextContent(c.getTelefono());
        	email.setTextContent(c.getEmail());
        	
        	contatto.appendChild(nome);
        	contatto.appendChild(cognome);
        	contatto.appendChild(telefono);
        	contatto.appendChild(email);

        	docElement.appendChild(contatto);
        }

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(pathfile));

		// Output to console for testing
		//StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");
	}
	public static void ScrivereContattiCsv( List<Contatti> prova) throws IOException {
		
		File file = new File("C:\\Users\\Padawan03\\Desktop\\EsCsv.csv");
		TextFileManager we = new TextFileManager();
		StringBuilder provafile = new StringBuilder();
		provafile.append("NOME;COGNOME;TELEFONO;EMAIL");
		provafile.append("\n");
		for(int i=0;i<prova.size();i++) {
			provafile.append(prova.get(i).getNome());
			provafile.append(";");
			provafile.append(prova.get(i).getCognome());
			provafile.append(";");
			provafile.append(prova.get(i).getTelefono());
			provafile.append(";");
			provafile.append(prova.get(i).getEmail());
			provafile.append("\n");
		}
		we.writeFileContent(provafile.toString(), file);
		
	}
	
	public static void InserimentoHibernate(Contatti contatto) {
		Configuration configuration = new Configuration();
		configuration = configuration.configure()
				.addAnnotatedClass(Contatti.class);
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(contatto);
		
		transaction.commit();
		
		session.close();
	}
	
	public static void LetturaHibernate() {
		Configuration configuration = new Configuration();
		configuration = configuration.configure()
				.addAnnotatedClass(Contatti.class);
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		
		String hql = "SELECT c FROM Contatto as c";
		Query<Contatti> query = session.createQuery(hql);
		
		for (Contatti contatto : query.list()) {
			System.out.println(contatto);
		}	
	}
	
	public static void LetturaJPA() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		Contatti contatto = entityManager.find(Contatti.class, 74);
		System.out.println(contatto);
	}
	
	
	public static void ScritturaJPA(Contatti contatto) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(contatto);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
