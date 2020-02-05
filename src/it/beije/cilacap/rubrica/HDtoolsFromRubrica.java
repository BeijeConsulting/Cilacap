package it.beije.cilacap.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HDtoolsFromRubrica {

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
					c.setCognome(string[0]);
					c.setNome((string[1]));
					c.setTelefono((string[3]));
					c.setEmail((string[2]));
					contatti.add(c);
					continue LABEL;
				}

			}
			cont++;
		}

		return contatti;

	}

	public static void writeInDBMS(Contatto contatto) {

		System.out.println("INIZIO");

		// inizializzo configurazione
		Configuration configuration = new Configuration();
		configuration = configuration.configure().addAnnotatedClass(Contatto.class);
		// .addAnnotatedClass(altra classe)

		SessionFactory factory = configuration.buildSessionFactory();

		System.out.println("is open? " + factory.isOpen());

		// apro sessione
		Session session = factory.openSession();
		System.out.println("session is open? " + session.isOpen());

		// apro transazione
		Transaction transaction = session.beginTransaction();
		Contatto c = new Contatto();
		c.setNome(contatti.get(0).getNome());
		c.setCognome(contatti.get(0).getCognome());
		c.setEmail(contatti.get(0).getEmail());
		c.setTelefono(contatti.get(0).getTelefono());

		System.out.println("id : " + contatto.getId());
		session.save(c);
		System.out.println("id : " + contatto.getId());

		transaction.commit();

		// chiudo la sessione
		session.close();
		System.out.println("session is open? " + session.isOpen());

	}

	public static void main(String[] args) throws IOException {
		System.out.println("INIZIO");

		// inizializzo configurazione
		Configuration configuration = new Configuration();
		configuration = configuration.configure();
		// .addAnnotatedClass(Contatto.class);
//				.addAnnotatedClass(altra classe)
		SessionFactory factory = configuration.buildSessionFactory();

		System.out.println("is open? " + factory.isOpen());

		// apro sessione
		Session session = factory.openSession();
		System.out.println("session is open? " + session.isOpen());
		// Transaction transaction = session.beginTransaction();

		session.close();
		System.out.println("session is open? " + session.isOpen());

		File f = new File("csv/rubrica2.csv");
		contat = readFileRows(f);
		convertiInOggetto(contat);
		System.out.println(contatti);
		try {
			for (int i = 0; i < contatti.size(); i++)
				writeInDBMS(contatti.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
