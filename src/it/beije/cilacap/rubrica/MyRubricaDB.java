package it.beije.cilacap.rubrica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyRubricaDB
{

	public static void main(String[] args) throws Exception
	{
		List<Contatto> listacontatti = new ArrayList<Contatto>();
		getContattiFromDB(listacontatti); //metodo autoesplicativo
		//MyRubricaXML.writeContattiInFile(listacontatti, "xml\\DBtoXML.xml"); //stampa su XML
		//MyRubricaXML.writeContattiInFileCSV(listacontatti, "csv\\DBtoCSV.csv"); //stampa su CSV
		
		

	}
	
	public static void getContattiFromDB(List<Contatto> contatti) throws ClassNotFoundException, SQLException
	{
		Connection connection = null;
		Statement stmt = null;
		
		try 
		{
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
			
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cilacap.rubrica");
			
			while (rs.next()) 
			{
				Contatto valore = new Contatto();
				valore.setId(rs.getInt("id"));
	        	valore.setNome(rs.getString("nome"));
	        	valore.setCognome(rs.getString("cognome"));
	        	valore.setTelefono(rs.getString("telefono"));
	        	valore.setEmail(rs.getString("email"));
	        	
	        	System.out.println("id = " + valore.getId());
	        	System.out.println("nome = " + valore.getNome());
	        	System.out.println("cognome = " + valore.getCognome());
	        	System.out.println("telefono = " + valore.getTelefono());
	        	System.out.println("email = " + valore.getEmail());
	        	
	        	contatti.add(valore);
			}
		} 
		catch (SQLException sqlEx)
		{
			System.out.println("PROBLEMA : " + sqlEx);
			throw sqlEx;
		}
		finally
		{
			try
			{
				stmt.close();
				connection.close();
			}
			catch (SQLException finEx)
			{
				System.out.println("PROBLEMA : " + finEx);
			}
		}
		
		System.out.println("contatti letti : " + contatti.size());
	}
	
	public static void setContattiFromXML(List<Contatto> contatti) throws ClassNotFoundException {
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
			pstmt.setString(1, contatti.getNome());
			pstmt.setString(2, contatti.getCognome());
			pstmt.setString(3, contatti.getTelefono());
			pstmt.setString(4, contatti.getEmail());
			
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

}
