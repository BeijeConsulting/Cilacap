package it.beije.cilacap.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConversionFromCSV {

	static List<String> contat;
	static List<Contatto> contatti = new ArrayList<Contatto>();

	public static List<String> readFileRows(String filePath) throws IOException {
		File file = new File(filePath);

		return readFileRows(file);
	}

	public static List<String> readFileRows(File file) throws IOException {
		List<String> rows = new ArrayList<String>();

		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		while ((row = reader.readLine()) != null) {
			rows.add(row);

		}

		return rows;
	}

	public static List<Contatto> convertiInOggetto(List<String> contat) {
		int cont = 0;
		LABEL: for (String s : contat) {
			if (cont > 0) {
				String[] string = s.split(";");
				for (int i = 0; i < string.length; i++) {
					Contatto c = new Contatto();
					c.setCognome(string[1]);
					c.setNome((string[0]));
					c.setTelefono((string[2]));
					c.setEmail((string[3]));
					contatti.add(c);
					continue LABEL;
				}

			}
			cont++;
		}

		return contatti;

	}

	public static boolean insertContatto(Contatto contatto) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean esito = false;

		try {

			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);

			pstmt = connection
					.prepareStatement("INSERT into cilacap.rubrica (nome,cognome,telefono,email) VALUES (?,?,?,?)");
			pstmt.setString(1, contatto.getNome());
			pstmt.setString(2, contatto.getCognome());
			pstmt.setString(3, contatto.getTelefono());
			pstmt.setString(4, contatto.getEmail());

			esito = pstmt.execute();
			//System.out.println(pstmt.getUpdateCount());

			// pstmt.executeUpdate();

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

	public static void main(String[] args) throws IOException {
		contat = readFileRows("csv/rubrica1.csv");
		//System.out.println(convertiInOggetto(contat));
		convertiInOggetto(contat);
		try {
			for(int i=0;i<contatti.size();i++)
			insertContatto(contatti.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
