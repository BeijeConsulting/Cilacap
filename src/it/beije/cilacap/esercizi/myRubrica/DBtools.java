package it.beije.cilacap.esercizi.myRubrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBtools {
	
	public static int updateContatti(Contatto2 c, String newCognome) throws ClassNotFoundException {
		Connection connection = null;
		Statement stmt = null;
		
		int updatedContatti = 0;
		
		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
			
			stmt = connection.createStatement();
			updatedContatti = stmt.executeUpdate("UPDATE cilacap.rubrica SET cognome = \'" + newCognome + "\' WHERE Nome = \'" + c.getNome() + "\'");
			
			
			
		} catch (SQLException sqlEx) {
			System.out.println("PROBLEMA : " + sqlEx);
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException finEx) {
				System.out.println("PROBLEMA : " + finEx);
			}
		}
		
		
		return updatedContatti;
	}

	public static List<Contatto2> leggiContatti() throws ClassNotFoundException, SQLException {
		List<Contatto2> contatti = new ArrayList<Contatto2>();
		
		Connection connection = null;
		Statement stmt = null;
		
		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
			
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cilacap.rubrica");
			
			Contatto2 contatto = null;
			while (rs.next()) {
				contatto = new Contatto2();
				contatto.setId(rs.getInt("id"));
	        	contatto.setNome(rs.getString("nome"));
	        	contatto.setCognome(rs.getString("cognome"));
	        	contatto.setTelefono(rs.getString("telefono"));
	        	contatto.setEmail(rs.getString("email"));
	        	
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
	
	public static boolean insertContatto(Contatto2 contatto) throws ClassNotFoundException {
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
			
			// La posizione dei ? parte dalla posizione 1
			pstmt = connection.prepareStatement("INSERT into cilacap.rubrica (nome,cognome,telefono,email) VALUES (?,?,?,?)");
			pstmt.setString(1, contatto.getNome());
			pstmt.setString(2, contatto.getCognome());
			pstmt.setString(3, contatto.getTelefono());
			pstmt.setString(4, contatto.getEmail());
			
			esito = pstmt.execute();
			
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
	
	public static void main(String[] args) {
		
		try {
			//insertContatto(leggiContatti().get(0));
			Contatto2 c = new Contatto2();
			c.setNome("Riccardo");
			c.setCognome("pippo");
			c.setTelefono("025896369");
			c.setEmail("bb@b.it");
			System.out.println(updateContatti(c, "Baioni"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
