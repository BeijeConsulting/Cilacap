package it.beije.cilacap.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MyRubrica {

	private static boolean exit = false;
//	private static List<Contatto> listaContatti = new ArrayList<Contatto>();

	public static void main(String[] args) throws Exception {

		List<Contatto> listaContatti = new ArrayList<Contatto>();
		while (!exit) {
			listaContatti = onMainMenu(listaContatti);
		}
		System.out.println("BYE");
	}

	@SuppressWarnings("resource")
	public static List<Contatto> onMainMenu(List<Contatto> listaContatti) throws Exception {
		System.out.println();
		System.out.println(".....................................");
		System.out.println("1--Inserisci Contatto----------------");// inserisci Bean
		System.out.println("2--Visualizza Rubrica----------------");// printRubrica
		System.out.println("3--Caricare Contatti da CSV----------");// da CSV file prendo Bean e lo metto in rubrica
		System.out.println("4--Caricare Contatti da XML----------");// da XML file prendo Bean e lo metto in rubrica
		System.out.println("5--Esporta file in CSV---------------");// esporta Bean in csv
		System.out.println("6--Esporta file in XML---------------");// esporta Bean in XML
		System.out.println("7--Esci dall'applicazione------------");// exit = true;
		System.out.println(".....................................");
		System.out.println();
		
		Scanner info = new Scanner(System.in);
		int choose = info.nextInt();
		switch (choose) {
		case 1:
			listaContatti = inserisciContatto(listaContatti);
			break;
		case 2:
			Utility.visualizzaRubrica(listaContatti);
			break;
		case 3:
			listaContatti = Utility.caricaContattiDaCSV(Utility.choosePath(false)); // false = csv, true = xml
			break;
		case 4:
			listaContatti = Utility.caricaContattiDaXML(Utility.choosePath(true)); // true = xml
			break;
		case 5:
			Utility.esportaRubricaInCSV(Utility.choosePath(false), listaContatti); // false = csv, true = xml
			break;
		case 6:
			Utility.esportaRubricaInXML(Utility.choosePath(true), listaContatti);
			break;
		case 7:
			exit = true;
		
		}
		return listaContatti;

	}

	public static List<Contatto> inserisciContatto(List<Contatto> listaContatti) {
		boolean exitFromLoop = false;
		Scanner scan = null;
		String fieldContatto = "campiDiContatto";
		while (!exitFromLoop) {
			scan = new Scanner(System.in);
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
			listaContatti.add(c);
			fieldContatto = "";
			String choose = "decisioneMenuUscita";
			while (true) {
				System.out.println("vuoi inserire altri contatti ? s/n");
				choose = scan.next();
				if (choose.equalsIgnoreCase("n")) {
					exitFromLoop = true;
					break;
				} else if (choose.equalsIgnoreCase("s")) { // esco dal while
					break;
				} else {
					System.out.println("immetti un valore valido (s/n)");
				}
			}
		} // fine while
		System.out.println("vuoi tornare al menù principale? s/n");
		fieldContatto = scan.nextLine();
		if (fieldContatto.equalsIgnoreCase("n")) {
			exit = true;
		}
		return listaContatti;

	}// fine metodo

	

	

	
	
	

	}
