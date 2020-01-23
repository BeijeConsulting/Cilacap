package it.beije.cilacap.esercizi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.beije.cilacap.rubrica.Contatto;
import jdk.nashorn.internal.runtime.ListAdapter;

public class EsercizioRubrica {
	
	public static String readFileContent(String filePath) throws IOException {
		File file = new File(filePath);
		
		return readFileContent(file);
	}

	public static String readFileContent(File file) throws IOException {
		StringBuilder builder = new StringBuilder();
		
		FileReader fileReader = new FileReader(file);

		int c;
		while ((c = fileReader.read()) > -1) {
			//System.out.print((char)c);
			builder.append((char)c);
		}
		
		fileReader.close();
		return builder.toString();
	}
	
	public static void writeFileContent(String content, String filePath) throws IOException {
		File file = new File(filePath);
		writeFileContent(content, file);
	}
	
	public static void writeFileContent(String content, File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		
		fileWriter.write(content);
		
		fileWriter.flush();
		fileWriter.close();
	}
	
	public static String insertData() {
		Scanner s = new Scanner(System.in);
		String dato;
		dato=s.nextLine();
		boolean noChar= false;
		while(dato.isEmpty() || dato == null || dato.trim().isEmpty()) {
			System.out.println("Campo obbligatorio, non può essere vuoto"); 
			dato=s.nextLine();
			
		}		
		return dato;
	}
	
	
	public static List<Contatto> loadContactList (File file) throws IOException{
		List <Contatto>  contactList= new ArrayList<Contatto>();
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		while ((row = reader.readLine()) != null) {
			Contatto c1=new Contatto();
			c1.setCognome(row);
			while((row=reader.readLine())!="\n") {
				
			}
		}
		return contactList;	
	}
	
	public static void writeInFile(List <Contatto> contatti, File f1 ) throws IOException {
		
		StringBuilder contenuto= new StringBuilder();
		for(Contatto contatto: contatti) {
			contenuto.append(contatto.getCognome()+";");
			contenuto.append(contatto.getNome()+";");
			contenuto.append(contatto.getTelefono()+";");
			contenuto.append(contatto.getEmail()+"\n");
		}
	
		String intestazione ="COGNOME;NOME;TELEFONO;EMAIL\n";
		String nuovoContenuto=contenuto.toString();
		
		if(f1.exists()) {
			String contenutoFile =readFileContent(f1);
			System.out.println(contenutoFile);
			String stringContenutoFile=intestazione.concat(contenutoFile.substring(contenutoFile.indexOf('\n')+1).concat(nuovoContenuto));
			writeFileContent(stringContenutoFile, f1);
		}else {
			String contenuto2=intestazione.concat(nuovoContenuto);
			writeFileContent(contenuto2, f1);
			
		}
	}
	
	public static List<Contatto> createContacts() {
		
		Scanner s= new Scanner(System.in);
		boolean finito=false;
		List<Contatto> listaContatti = new ArrayList<Contatto>();
		
		
		//CE 20200122: ciclo inserimento dati
		do { 		
			Contatto c=new Contatto();
			System.out.println("Cognome: ");
			c.setCognome(insertData());
			System.out.println("Nome: " );
			c.setNome(insertData());			
			System.out.println("Telefono: ");
			c.setTelefono(insertData());			
			System.out.println("Email: ");
			c.setEmail(insertData());
			listaContatti.add(c);
			System.out.println("Hai altri contatti o vuoi inserire altri contatti?");
				if(s.nextLine().equalsIgnoreCase("n")) {
					finito=true;
				}
		}while (!finito);
		return listaContatti;
	}
	
	
	public static void main(String[] args) throws IOException {

		//CE 20200122: Inizio soluzione esercizio mia rubrica
		File f1=new File ("csv/miaRubrica.txt");
		StringBuilder info= new StringBuilder();
		List<Contatto> listaContatti= createContacts();
		writeInFile(listaContatti, f1);
		
		System.out.println("the end");
	}

	


}
