package it.beije.cilacap.rubrica;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.beije.cilacap.esercizi.TextFileManager;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;

public class DBtools {

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
	//INSERT QUERY
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
	//UPDATE QUERY
     	public static boolean updateContatto(Contatto contatto) throws ClassNotFoundException {
		Connection connection=null;
		PreparedStatement prepared=null;
		boolean b=false;
		try {
			connection=DBManager.getMySqlConnection(DBManager.DB_URL,DBManager.DB_USER, DBManager.DB_PASSWORD);
			prepared = connection.prepareStatement("UPDATE cilacap.rubrica  SET nome=?, cognome=?,"
					+ " telefono=?, email=? WHERE id=2");
			prepared.setString(1, "Salvo");
			prepared.setString(2,"Dani");
			prepared.setString(3,"33445556677");
			prepared.setString(4,"Dani@salvo.it");
			b=prepared.execute();
			System.out.println(prepared.getUpdateCount());
		} catch (SQLException sqlEx) {
			System.out.println("PROBLEMA : " + sqlEx);
		} finally {
			try {
				prepared.close();
				connection.close();
			} catch (SQLException finEx) {
				System.out.println("PROBLEMA : " + finEx);
			}
		}
		
		return b;
			
}
     	//DELETE QUERY
     	public static boolean deleteContatto(Contatto contatto) throws ClassNotFoundException {
     		Connection conn=null;
     		PreparedStatement prepared=null;
     		boolean b=false;
     		try {
     			conn=DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
     			prepared=conn.prepareStatement("DELETE FROM cilacap.rubrica WHERE id=?");
     			
     			b=prepared.execute();
     		} catch (SQLException sqlEx) {
    			System.out.println("PROBLEMA : " + sqlEx);
    		} finally {
    			try {
    				prepared.close();
    				conn.close();
    			} catch (SQLException finEx) {
    				System.out.println("PROBLEMA : " + finEx);
    			}
     		}
     		return b;
     	}
     	
     	
     	public static int esportadbsucsv(String path) throws ClassNotFoundException, SQLException, IOException {
     		List<Contatto> c=DBtools.leggiContatti();
     		Contatto con=new Contatto();
     		con.settoFile();
     		return c.size();
     	}
     	
    	public static ArrayList<Contatto> settoFile() throws IOException{
    		Contatto c=new Contatto();
    		TextFileManager tfx=new TextFileManager();
    		List<String> file=tfx.readFileRows("C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.csv");
    		ArrayList<Contatto> contatticaricati=new ArrayList <Contatto>();
    		String separatore=(";");
    		String[] righe;
    		for(int i=0;i<file.size();i++) {
    			Contatto nuovo=new Contatto();
    			righe=file.get(i).split(separatore);
    			for(int a=0;a<righe.length-1;a++) {
    				if(a==0) {
    					nuovo.setCognome(righe[i]);
    				}
    				if(a==1) {
    					nuovo.setNome(righe[i]);
    				}
    				if (a==2) {
    					nuovo.setTelefono(righe[i]);
    				}
    				if(a==3) {
    					nuovo.setEmail(righe[i]);
    				}
//    				switch (a) {
//    				case 0:
//    					nuovo.setCognome(righe[i]);
//    					
//    				case 1:
//    					nuovo.setNome(righe[i]);
//    					break;
//    				case 2:
//    					nuovo.setTelefono(righe[i]);
//    					break;
//    				case 3:
//    					nuovo.setEmail(righe[i]);
//    					break;
//    				default:
//    					break;
//    				}
    			}
    			contatticaricati.add(nuovo);
    		}
    		return contatticaricati;
    	}
     	
    	public static List<Contatto> getContattiFromFile() throws Exception {
    		File file=new File("C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.xml");
    		List<Contatto> listaContatti = new ArrayList<Contatto>();
    		try {
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
            	
            	Contatto contatto = new Contatto();
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
    		}catch(Exception e) {
    			System.out.println("a");
    		}
            
    	
            
            return listaContatti;
    	}
  
     		
     	
		
		
	
	public static void main(String[] args) throws Exception, ArrayIndexOutOfBoundsException {
		
		
		ArrayList <Contatto> contatti= new ArrayList<Contatto>();
		List<Contatto> xml=new ArrayList<>();
		List<Contatto> db=new ArrayList<>();
		xml=getContattiFromFile();
		try{
			contatti=settoFile();
		}catch(ArrayIndexOutOfBoundsException arrayex){
			contatti=settoFile();
			System.out.println(arrayex);;
		}
		for(int i=0;i<contatti.size();i++) {
			insertContatto(contatti.get(i));
			for(int a=0;a<xml.size();a++) {
				insertContatto(xml.get(a));
			}
			db=leggiContatti();
			ParserXML parser=new ParserXML();
			parser.writeContattiInFile(db, "C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.xml");
			Contatto c=new Contatto();
			c.scrivisuFile(db, ";");
		}
		
		try {
//			insertContatto(leggiContatti().get(0));
			updateContatto(leggiContatti().get(0));
			
			esportadbsucsv("C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.csv");
//			csvtoDb("C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.csv");
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("Qualcosa non va: "+e);
		}
		
	}

}
