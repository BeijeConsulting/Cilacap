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
		setContattiFromXMLToDB(listacontatti); //scrittura su DB del contenuto del bean listacontatti
		
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
	
	public static void setContattiFromXMLToDB(List<Contatto> contatti) throws ClassNotFoundException
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try
		{
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
			
			for (Contatto c : contatti)
			{
				pstmt = connection.prepareStatement("INSERT into cilacap.rubrica (nome,cognome,telefono,email) VALUES (?,?,?,?)");
				pstmt.setString(1, c.getNome());
				pstmt.setString(2, c.getCognome());
				pstmt.setString(3, c.getTelefono());
				pstmt.setString(4, c.getEmail());
				
				pstmt.executeUpdate();
			}
			
		}
		catch (SQLException sqlEx)
		{
			System.out.println("PROBLEMA : " + sqlEx);
		}
		finally
		{
			try
			{
				pstmt.close();
				connection.close();
			}
			catch (SQLException finEx)
			{
				System.out.println("PROBLEMA : " + finEx);
			}
			
			System.out.println("Dati inseriti in DB");
		}
	}

}
