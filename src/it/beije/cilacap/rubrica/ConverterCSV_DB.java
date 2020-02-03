package it.beije.cilacap.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConverterCSV_DB {
	
	
	public static void readCSVFile(List<Contatto> contacts, String pathFile) throws Exception {
		
		File sheet = new File(pathFile); // import the file
		
		FileReader fileReader = new FileReader(sheet); // read the file
		
		BufferedReader reader = new BufferedReader(fileReader); // 	read the file line per line

		
		String row = reader.readLine();
		String[] fields = row.split(";");
		final int[] arrayIndex = new int[5];
  		int counterColumns;       // Variable to count number of columns in the first line
  		
		//Creating indexes for each column
		
		for(counterColumns = 0; counterColumns <= fields.length-1; counterColumns++) {
			
			if (fields[counterColumns].contentEquals("NOME")) {
				arrayIndex[0] = counterColumns;
			}
			if (fields[counterColumns].contentEquals("COGNOME")) {
				arrayIndex[1] = counterColumns;
			}
			if (fields[counterColumns].contentEquals("TELEFONO")) {
				arrayIndex[2] = counterColumns;
			}
			if (fields[counterColumns].contentEquals("EMAIL")) {
				arrayIndex[3] = counterColumns;
			}
			if (fields[counterColumns].contentEquals("INDIRIZZO")) {
				arrayIndex[4] = counterColumns;
			}
				
		}
		
		// Organization of the data according to the columns
		
		row = reader.readLine();
		
		while (row != null) {
			
			Contatto data = new Contatto();
			
			fields = row.split(";"); //Divide row 
				
			if (arrayIndex[0] < fields.length) {
				data.setNome(fields[arrayIndex[0]]);
				//System.out.println("Nome: " + fields[arrayIndex[0]]);
			}
			if (arrayIndex[1] < fields.length) {
				data.setCognome(fields[arrayIndex[1]]);
				//System.out.println("Cognome: " + fields[arrayIndex[1]]);
			}
			if (arrayIndex[2] < fields.length) {
				data.setTelefono(fields[arrayIndex[2]]);
				//System.out.println("Telefono: " + fields[arrayIndex[2]]);
			}
			if (arrayIndex[3] < fields.length) {
				data.setEmail(fields[arrayIndex[3]]);
				//System.out.println("Email: " + fields[arrayIndex[3]]);
			}
//			if (arrayIndex[4] < fields.length) {
//				data.setIndirizzo(fields[arrayIndex[4]]);
//				//System.out.println("Indirizzo: " + fields[arrayIndex[4]]);
//			}
				
			contacts.add(data);
				
			row = reader.readLine();
			}
		
		reader.close();	
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

	public static void main(String[] args) throws Exception {
		
		ArrayList<Contatto> listContacts = new ArrayList<Contatto>();
		
		readCSVFile(listContacts, "csv/rubrica3.csv");
		
		insertContatto(listContacts);
		
	}

}
