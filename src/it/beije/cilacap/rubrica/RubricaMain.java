package it.beije.cilacap.rubrica;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RubricaMain {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		File f = new File("C:\\Users\\Padawan09\\git\\Cilacap\\xml\\rubrica.xml");
//		List<Contatto> rubrica = aggiungiElencoContatti();
		try {
//			ParserCSV.writeContattiInCsv(rubrica, f);
//			Migrater.fromCSVtoXML(f);
			Migrater.fromXMLtoDB(f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static List<Contatto> aggiungiElencoContatti() {
		List<Contatto> elenco = new ArrayList<Contatto>();
		while(true) {
			Contatto cont = new Contatto();
			for(String intestazione : Contatto.INTESTAZIONE) {
				System.out.println("inserisci i dati del campo "+intestazione);
				switch(intestazione) {
					case "nome":
						cont.setNome(scan.nextLine());
						break;
					case "cognome":
						cont.setCognome(scan.nextLine());
						break;
					case "telefono":
						cont.setTelefono(scan.nextLine());
						break;
					case "email":
						cont.setEmail(scan.nextLine());
						break;
				}
			}
			elenco.add(cont);
			System.out.println("Aggiungere un altro contatto?(S/N)");
			if(scan.next().equalsIgnoreCase("n")) return elenco;
		}
	}
}
