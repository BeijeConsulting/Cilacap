package it.beije.cilacap.rubrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBtools {
	
	public static List<Contatto> leggiContatti() throws ClassNotFoundException, SQLException {
		
		List<Contatto> contacts = new ArrayList<Contatto>();
		
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
	        	
	        	contacts.add(contatto);
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
		
		System.out.println("contatti letti : " + contacts.size());
		
		return contacts;
	}
	
	public static boolean insertContatto(List<Contatto> contacts) throws ClassNotFoundException {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean esito = false;
		
		try {
			
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
			
			for(Contatto contatto : contacts) {
			
			pstmt = connection.prepareStatement("INSERT into cilacap.rubrica (nome,cognome,telefono,email) VALUES (?,?,?,?)");
			pstmt.setString(1, contatto.getNome());
			pstmt.setString(2, contatto.getCognome());
			pstmt.setString(3, contatto.getTelefono());
			pstmt.setString(4, contatto.getEmail());
			
			esito = pstmt.execute();
		
			}
			
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
	
}
