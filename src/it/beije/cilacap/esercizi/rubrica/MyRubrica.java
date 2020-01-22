package it.beije.cilacap.esercizi.rubrica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyRubrica {

	public static void main(String[] args) throws IOException {

		System.out.println("Inserisci i tuoi contatti:");

		List<Contatto> contatti = new ArrayList<Contatto>();
		
		Scanner s = new Scanner(System.in);
		String st = "";
		
		while (!st.equalsIgnoreCase("N")) {
			
			Contatto contatto = new Contatto();
			
			// cognome
			String cognome = "";
			while(cognome.equals("")) {
				System.out.print("Cognome: ");
				cognome = s.nextLine();
			}
			contatto.setCognome(cognome);
			
			// nome
			String nome = "";
			while(nome.equals("")) {
				System.out.print("Nome: ");
				nome = s.nextLine();
			}
			contatto.setNome(nome);
			
			// telefono
			String telefono = "";
			while(telefono.equals("")) {
				System.out.print("Telefono: ");
				telefono = s.nextLine();
			}
			contatto.setTelefono(telefono);
			
			// email
			String email = "";
			while(email.equals("")) {
				System.out.print("Email: ");
				email = s.nextLine();
			}
			contatto.setEmail(email);
			
			contatti.add(contatto);
			
			System.out.println("\n\nHai altri contatti da inserire in rubrica? [ s / n ]");
			
			st = s.nextLine();
		}
		
		
		String path = "C:\\Users\\Padawan04\\Desktop\\LaMiaRubrica.csv";
		String intestazione = "COGNOME;NOME;TELEFONO;EMAIL\n";
		StringBuilder newFileContent = new StringBuilder();
		
		for(Contatto c : contatti) {
			newFileContent.append(c.toString() + "\n");
		}
		
		
		// scrittura di un nuovo file o sovrascrittura
		//TextFileManager.writeFileContent(intestazione + newFileContent.toString(), path);
		
		// Update file LaMiaRubrica.txt
		String oldContent = TextFileManager.readFileContent(path);
		String updateContent = oldContent + newFileContent.toString();
		TextFileManager.writeFileContent(updateContent.toString(), path);
		
		System.gc();
		System.out.println("BYE!!");
		s.close();

	}

}
