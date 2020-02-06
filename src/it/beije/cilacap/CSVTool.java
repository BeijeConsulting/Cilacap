package it.beije.cilacap;

import java.io.*;
import java.util.*;


import it.beije.cilacap.rubrica.Contatto;

public class CSVTool {
	
	static List<Contatto> listaContatti = new ArrayList<Contatto>();
	static Contatto contatto = new Contatto();
	
	public static void main(String[] args) throws IOException {
		
		String path = "csv/copia1.txt";
		ReaderCSV(path);
//		WriterCSV(listaContatti);
	}

	//Legge file CSV
	public static List<Contatto> ReaderCSV(String path) throws IOException{	
		File file = new File(path);
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);

		String row;
		String[] credenziali = new String[10];
		int count = 0;

		while ((row = reader.readLine()) != null) {
			
			String[] header = row.split(";");

			if (count == 0) {
				for (int i = 0; i < header.length; i++) {
					System.out.println(header[i]);
					credenziali[i] = header[i];
				}
				count++;
				
			} else {
				
				for (int i = 0; i < header.length; i++) {
					
					if(credenziali[i].equalsIgnoreCase("nome")) {
						contatto.setNome(header[i]);
					} else if(credenziali[i].equalsIgnoreCase("cognome")) {
						contatto.setCognome(header[i]);
					} else if(credenziali[i].equalsIgnoreCase("telefono")) {
						contatto.setTelefono(header[i]);
					} else if(credenziali[i].equalsIgnoreCase("email")) {
						contatto.setEmail(header[i]);
					} else {
						System.out.println("Errore");
					}
				}
				listaContatti.add(contatto);
				System.out.println(contatto);
//				System.out.println(listaContatti);
			}
		}
		System.out.println(listaContatti);
		reader.close();
		return listaContatti;
	}
	
	
	public static void WriterCSV(List<Contatto> listaContatti) throws IOException{
		
		String[] arrayContatto = new String[5];
		int j = 0;
		
		while(j < listaContatti.size()) {
		for (int i = 1; i <= listaContatti.size(); i++) {
				
				if(i == 2)
				System.out.println(contatto.getCognome());	
				else if(i == 3)
				System.out.println(contatto.getNome());
				else if(i == 4)
				System.out.println(contatto.getTelefono());		
				else if(i == 5)
				System.out.println(contatto.getEmail());
			}
		j++;
		}
	}
}