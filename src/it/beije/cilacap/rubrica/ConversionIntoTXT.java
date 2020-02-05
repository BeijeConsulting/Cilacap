package it.beije.cilacap.rubrica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConversionIntoTXT {
	
	static List<Contatto> contatti = new ArrayList<Contatto>();

	public static List<Contatto> leggiContatti() throws ClassNotFoundException, SQLException {
		//List<Contatto> contatti = new ArrayList<Contatto>();

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

		//System.out.println("contatti letti : " + contatti.size());

		return contatti;
	}
	
	public static void writeFileContent(List<Contatto> contatti, File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.append("NOME;").append("COGNOME;").append("TELEFONO;").append("EMAIL;").append('\n');
		for (Contatto row : contatti) {
			bufferedWriter.append(row.getNome() + ";");
			bufferedWriter.append(row.getCognome() + ";");
			bufferedWriter.append(row.getTelefono() + ";");
			bufferedWriter.append(row.getEmail() + ";").append('\n');
		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}


	public static void main(String[] args) throws IOException {
		try {
			contatti = (leggiContatti());
			writeFileContent(contatti,new File("csv/copia_rubrica1.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
