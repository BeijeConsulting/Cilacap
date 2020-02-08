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

public class MyRubricaCSV_XML_DB_JDBC {

	@SuppressWarnings("unused")
	private static int onMainMenu() throws ClassNotFoundException, SQLException, IOException {

		int uscita = 0; // -1 esco
		System.out.println(".................................");
		System.out.println("1 -- Insert Contacts ------------");
		System.out.println("2 -- Update Contacts ------------");
		System.out.println("3 -- Show Contacts   ------------");
		System.out.println("4 -- From DB to XML  ------------");
		System.out.println("5 -- From DB to CSV  ------------");
		System.out.println("6 -- From CSV to DB  ------------");
		System.out.println("7 -- From XML to DB  ------------");
		System.out.println("8 -- Exit From App.  ------------");
		System.out.println(".................................");

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choose = scan.nextInt();
		switch (choose) {
		case 1:
			Contatto contatto = Utility.inserisciContatto();
			insertContattoInDB(contatto);
			break;
		case 2:
			updateContactInDB();
			break;
		case 3:
			Utility.visualizzaRubrica(leggiContattiFromDB());
			break;
		case 4:
			fromDBtoXML(Utility.choosePath(true));
			break;
		case 5:
			fromDBtoCSV(Utility.choosePath(false), leggiContattiFromDB());
			break;
		case 6:
			fromCSVtoDB(Utility.choosePath(false));
			break;
		case 7:
			fromXMLtoDB(Utility.choosePath(true));
			break;
		case 8:
			uscita = -1;
			break;
		}
		return uscita;
	}

	/* PARTE import/export */
	
	public static void fromDBtoXML(String filePath) { // overload sotto
		File file = new File(filePath);
		fromDBtoXML(file);
	}

	public static void fromDBtoXML(File file) { // leggo i contatti dal DB e li scrivo in un XML.
		try {
			MyRubricaCSV_XML_General.esportaRubricaInXML(file, leggiContattiFromDB());
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void fromDBtoCSV(String filePath, List<Contatto> listaContatti) throws IOException { // overload
																										// sotto
		File file = new File(filePath);
		fromDBtoCSV(file, listaContatti);
	}

	public static void fromDBtoCSV(File file, List<Contatto> listaContatti) throws IOException { // metto lista del
																									// DB in un file
																									// CSV.

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

	public static void fromCSVtoDB(String filePath) { // overload sotto.
		File file = new File(filePath);
		fromCSVtoDB(file);
	}

	public static void fromCSVtoDB(File file) { // preleva tutti i Bean contatto dal file CSV e li inserisci
		// all'interno del DB.
		try {

			List<Contatto> listaContatti = MyRubricaCSV_XML_General.caricaContattiDaCSV(file); // ottengo tutti i
																								// contattai dal file
																								// csv.
			for (int i = 0; i < listaContatti.size(); i++) {
				insertContattoInDB(listaContatti.get(i));
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void fromXMLtoDB(String filePath) {
		File file = new File(filePath);
		fromXMLtoDB(file);
	}

	public static void fromXMLtoDB(File file) {

		List<Contatto> listaContatti = new ArrayList<Contatto>();
		try {
			
			listaContatti = MyRubricaCSV_XML_General.caricaContattiDaXML(file);
			for(Contatto c : listaContatti) {
				insertContattoInDB(c);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	
	
	/* PARTE DB metodi. */
	public static List<Contatto> leggiContattiFromDB() throws ClassNotFoundException, SQLException { // SELECT * FROM
		// cilacap.rubrica.

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

	public static boolean insertContattoInDB(Contatto contatto) throws ClassNotFoundException { // inserisci Contatto in
																								// DB
		// cilacap.rubrica
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean esito = false;
		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);

			pstmt = connection
					.prepareStatement("INSERT INTO cilacap.rubrica (nome,cognome,telefono,email) VALUES (?,?,?,?)");
			pstmt.setString(1, contatto.getNome());
			pstmt.setString(2, contatto.getCognome());
			pstmt.setString(3, contatto.getTelefono());
			pstmt.setString(4, contatto.getEmail());

			esito = pstmt.execute();
			System.out.println(pstmt.getUpdateCount());
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

	@SuppressWarnings("resource")
	public static void updateContactInDB() { // query update del contatto con l'id rispettivo.

		List<Contatto> listaContatti = null;
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {

			listaContatti = leggiContattiFromDB(); // prendo listaContatti da DB
			System.out.println("##################### Ecco i contatti #####################");
			Utility.visualizzaRubrica(listaContatti);
			System.out.println("............................................");
			System.out.println("-- Inserisci L'Id dell'utente da modificare--");
			Scanner scan = new Scanner(System.in);
			int idUtente = scan.nextInt();
			Contatto c = findContactByID(listaContatti, idUtente); // prendo il contatto con quell'ID;
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

	public static Contatto findContactByID(List<Contatto> listaContatti, int ID) throws NullPointerException {

		for (int i = 0; i < listaContatti.size(); i++) {
			if (listaContatti.get(i).getId() == ID) {
				return listaContatti.get(i);
			}
		}
		return null; // qua non arrivo

	}

	
	
	public static void main(String[] args) throws Exception {
		
			//[Tests Methods]

	}

}
