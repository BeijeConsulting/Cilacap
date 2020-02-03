package it.beije.cilacap.rubrica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConverterDB_CSV {
	
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
	
	public static void writerFile(List<Contatto> listaContatti, String pathFile) throws IOException {
		
		File file = new File(pathFile);
		FileWriter fileWriter = new FileWriter(file);
		//BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		fileWriter.write("NOME;COGNOME;TELEFONO;EMAIL;\n");
		
		for (Contatto contacts : listaContatti) {		
			fileWriter.write(contacts.getNome() + ";");
			fileWriter.write(contacts.getCognome() + ";");
			fileWriter.write(contacts.getTelefono() + ";");
			fileWriter.write(contacts.getEmail() + ";");
			fileWriter.write("\n");
		}
	
		fileWriter.flush();
		fileWriter.close();
		
		System.out.println("File Saved");
	}

	public static void main(String[] args) throws Exception {
		
		writerFile(leggiContatti(), "csv/MyRubricaDBtoCSV.csv");
	}

}
