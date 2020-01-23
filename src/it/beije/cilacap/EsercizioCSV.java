package it.beije.cilacap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import it.beije.cilacap.esercizi.TextFileManager;

public class EsercizioCSV {

	public static void main(String[] args) throws IOException {
		ArrayList<contatto> prova = new ArrayList<>();
		System.out.println("Inserisci dei dati");
		String nome = new String();
		String cognome = new String();
		String email = new String();
		String telefono = new String();
		String continuare = new String();
		Scanner sc = new Scanner(System.in);
		while(!continuare.equalsIgnoreCase("N")){
			while(nome.equals("")) {	
			System.out.println("Nome:");
			nome= sc.nextLine();
			}
			while(cognome.equals("")) {	
			System.out.println("Cognome:");
			cognome= sc.nextLine();
			}
			while(telefono.equals("")) {	
			System.out.println("Telefono:");
			telefono= sc.nextLine();
			}
			while(email.equals("")) {	
			System.out.println("email:");
			email= sc.nextLine();
			}
			prova.add(new contatto(nome,cognome,telefono,email));
			System.out.println("Vuoi continuare? S-N");
			continuare = sc.nextLine();
			if(continuare.equalsIgnoreCase("s")) {
				nome = "";
				cognome = "";
				telefono = "";
				email = "";
			}
			
		}
		File file = new File("C:\\Users\\Padawan03\\Desktop\\EsCsv.txt");
		FileWriter writer = new FileWriter(file);
		TextFileManager we = new TextFileManager();
		StringBuilder provafile = new StringBuilder();
		for(int i=0;i<prova.size();i++) {
			provafile.append(prova.get(i).getNome());
			provafile.append("\n");
			provafile.append(prova.get(i).getCognome());
			provafile.append("\n");
			provafile.append(prova.get(i).getTelefono());
			provafile.append("\n");
			provafile.append(prova.get(i).getEmail());
			provafile.append("\n");
			provafile.append("\n");
		}
		we.writeFileContent(provafile.toString(), file);	
		
		
		
	}
	
	public void CaricareContatti() {
		
		
		
		
	}
	
	
}


class contatto{
	private String nome;
	private String cognome;
	private String telefono;
	private String email;
	public contatto(String nome, String cognome, String telefono, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
}
