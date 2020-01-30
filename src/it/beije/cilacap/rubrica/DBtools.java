package it.beije.cilacap.rubrica;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBtools {

	public static Contatto inserisciContatto() { // riempie Bean da dare in pasto ai metodi
		Scanner scan = new Scanner(System.in);
		;
		String fieldContatto = "campiDiContatto";
		Contatto c = new Contatto();
		System.out.println("inserisci un contatto:");
		System.out.println("............................");
		System.out.print("digita il nome:");
		fieldContatto = scan.nextLine();
		c.setNome(fieldContatto);
		System.out.print("\ndigita il cognome:");
		fieldContatto = scan.nextLine();
		c.setCognome(fieldContatto);
		System.out.print("\ndigita il telefono:");
		fieldContatto = scan.nextLine();
		c.setTelefono(fieldContatto);
		System.out.print("\ndigita la mail:");
		fieldContatto = scan.nextLine();
		c.setEmail(fieldContatto);
		System.out.println("............................");
		scan.close();
		return c;

	}// fine metodo

	public static void esportaDaDBAXML(String filePath) {
		File file = new File(filePath);
		esportaDaDBAXML(file);
	}

	public static void esportaDaDBAXML(File file) {
		try {
			ParserXML.writeContattiInFile(leggiContatti(), file);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

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

	public static boolean insertContatto(Contatto contatto) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean esito = false;

		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);

			// StringBuilder insert = new StringBuilder("INSERT into cilacap.rubrica VALUES
			// (null,")
			// .append('\'').append(contatto.getNome()).append("\',")
			// .append('\'').append(contatto.getCognome()).append("\',")
			// .append('\'').append(contatto.getTelefono()).append("\',")
			// .append('\'').append(contatto.getEmail()).append('t').append("\')");
			// System.out.println(insert.toString());
			pstmt = connection
					.prepareStatement("INSERT into cilacap.rubrica (nome,cognome,telefono,email) VALUES (?,?,?,?)");
			pstmt.setString(1, contatto.getNome());
			pstmt.setString(2, contatto.getCognome());
			pstmt.setString(3, contatto.getTelefono());
			pstmt.setString(4, contatto.getEmail());

			esito = pstmt.execute();
			System.out.println(pstmt.getUpdateCount());

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

	public static void main(String[] args) {
		Contatto contatto = null;
		try {
			contatto = inserisciContatto();
			insertContatto(contatto);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
