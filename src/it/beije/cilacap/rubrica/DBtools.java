package it.beije.cilacap.rubrica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBtools {

	private static int onMainMenu() throws ClassNotFoundException, SQLException, IOException {

		int uscita = 0; // -1 esco
		System.out.println(".................................");
		System.out.println("1 -- Aggiungi Contatto ----------");
		System.out.println("2 -- Modifica Campo Contatto ----");
		System.out.println("3 -- Lista Contatti -------------");
		System.out.println("4 -- Esporta contatti in XML ----");
		System.out.println("5 -- Esporta contatti in CSV ----");
		System.out.println("6 -- Esci Dall'Applicazione -----");
		System.out.println(".................................");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choose = scan.nextInt();
		switch (choose) {
		case 1:
			Contatto contatto = Utility.inserisciContatto();
			insertContatto(contatto);
			break;
		case 2:
			updateContatto();
			break;
		case 3:
			stampaContatti(leggiContatti());
			break;
		case 4:
			esportaDaDBaXML(Utility.choosePath(true));
			break;
		case 5:
			esportaDaDBaCSV(Utility.choosePath(false), leggiContatti());
			break;
		case 6:
			uscita = -1;
			break;
		}
		return uscita;
	}

	
	public static Contatto trovaContattoByID(List<Contatto> listaContatti, int ID) throws NullPointerException {

		for (int i = 0; i < listaContatti.size(); i++) {
			if (listaContatti.get(i).getId() == ID) {
				return listaContatti.get(i);
			}
		}
		return null; // qua non arrivo

	}

	@SuppressWarnings("resource")
	public static void updateContatto() {

		List<Contatto> listaContatti = null;
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {

			listaContatti = leggiContatti(); // prendo listaContatti da DB
			System.out.println("#####################Ecco i contatti#####################");
			stampaContatti(listaContatti);
			System.out.println("............................................");
			System.out.println("-- Inserisci L'Id dell'utente da modificare--");
			Scanner scan = new Scanner(System.in);
			int idUtente = scan.nextInt();
			Contatto c = trovaContattoByID(listaContatti, idUtente); // prendo il contatto con quell'ID;
			String query = "";
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
			query = "UPDATE cilacap.rubrica SET nome = ?, cognome = ?, telefono = ?, email = ? WHERE id= " + c.getId()
					+ ";";

			pstmt = connection.prepareStatement(query);
			Contatto contatto = Utility.inserisciContatto();
			pstmt.setString(1, contatto.getNome());
			pstmt.setString(2, contatto.getCognome());
			pstmt.setString(3, contatto.getTelefono());
			pstmt.setString(4, contatto.getEmail());
			pstmt.executeUpdate();
			System.out.println("Contatto modificato con successo ! !");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}
	
	public static void esportaDaDBaXML(String filePath) {
		File file = new File(filePath);
		esportaDaDBaXML(file);
	}

	public static void esportaDaDBaXML(File file) {
		try {
			ParserXML.writeContattiInFile(leggiContatti(), file);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void esportaDaDBaCSV(String filePath, List<Contatto> listaContatti) throws IOException {
		File file = new File(filePath);
		esportaDaDBaCSV(file, listaContatti);
	}

	public static void esportaDaDBaCSV(File file, List<Contatto> listaContatti) throws IOException {
		FileWriter fileWriter = new FileWriter(file, true); // true nell'append
		BufferedWriter bWriter = new BufferedWriter(fileWriter);
		for (Contatto c : listaContatti) {
			bWriter.append(c.getNome()).append(";").append(c.getCognome()).append(";").append(c.getTelefono())
					.append(";").append(c.getEmail()).append(";").append("\n");
		}
		System.out.println("file esportato con successo ! ! !");
		bWriter.flush();
		bWriter.close();

	}// fine metodo

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
				//
				// System.out.println("id = " + contatto.getId());
				// System.out.println("nome = " + contatto.getNome());
				// System.out.println("cognome = " + contatto.getCognome());
				// System.out.println("telefono = " + contatto.getTelefono());
				// System.out.println("email = " + contatto.getEmail());
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

	public static void stampaContatti(List<Contatto> listaContatti) {
		boolean primogiro = true;
		for (Contatto contatto : listaContatti) {
			if (primogiro) {
				System.out.println(".....................................");
			}
			primogiro = false;
			System.out.println("id = " + contatto.getId());
			System.out.println("nome = " + contatto.getNome());
			System.out.println("cognome = " + contatto.getCognome());
			System.out.println("telefono = " + contatto.getTelefono());
			System.out.println("email = " + contatto.getEmail());
			System.out.println(".....................................");
		}
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
					.prepareStatement("INSERT INTO cilacap.rubrica (nome,cognome,telefono,email) VALUES (?,?,?,?)");
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
		try {
			int uscita = 0;
			while (uscita != -1) {

				uscita = onMainMenu();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
