package it.beije.cilacap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.beije.cilacap.esercizi.TextFileManager;
import it.beije.cilacap.rubrica.Contatto;
import it.beije.cilacap.rubrica.ParserXML;

public class EsercizioCSV {

	public static void main(String[] args) throws Exception {
		EsercizioCSV provaz = new EsercizioCSV();
//		ArrayList<Contatto> prova = new ArrayList<>();
//		prova = provaz.CreaFileCsv();
//		provaz.ScrivereContattiCsv(prova);
//		provaz.CaricareContatti();
		provaz.CreaFileXml();
//		provaz.CreaCSVdaXML();
		
	}

	public ArrayList<Contatto> CreaFileCsv() {      //crea i dati da mettere nel csv
		ArrayList<Contatto> prova = new ArrayList<>();
		System.out.println("Inserisci dei dati");
		String nome = new String();
		String cognome = new String();
		String email = new String();
		String telefono = new String();
		String continuare = new String();
		Scanner sc = new Scanner(System.in);
		while(!continuare.equalsIgnoreCase("N")){
			Contatto contatto =  new Contatto();
			while(nome.equals("")) {
			System.out.println("Nome:");
			nome= sc.nextLine();
			contatto.setNome(nome);
			}
			while(cognome.equals("")) {	
			System.out.println("Cognome:");
			cognome= sc.nextLine();
			contatto.setCognome(cognome);
			}
			while(telefono.equals("")) {	
			System.out.println("Telefono:");
			telefono= sc.nextLine();
			contatto.setTelefono(telefono);
			}
			while(email.equals("")) {	
			System.out.println("email:");
			email= sc.nextLine();
			contatto.setEmail(email);
			}
			prova.add(contatto);
			System.out.println("Vuoi continuare? S-N");
			continuare = sc.nextLine();
			if(continuare.equalsIgnoreCase("s")) {
				nome = "";
				cognome = "";
				telefono = "";
				email = "";
			}
			
		}
		return prova;
	}
	public void ScrivereContattiCsv( List<Contatto> prova) throws IOException { //Prendo l'array di contatti scritto in precedenza e li metto in un file csv
		
		File file = new File("C:\\Users\\Padawan03\\Desktop\\EsCsv.csv");
		TextFileManager we = new TextFileManager();
		StringBuilder provafile = new StringBuilder();
		provafile.append("NOME;COGNOME;TELEFONO;EMAIL");
		provafile.append("\n");
		for(int i=0;i<prova.size();i++) {
			provafile.append(prova.get(i).getNome());
			provafile.append(";");
			provafile.append(prova.get(i).getCognome());
			provafile.append(";");
			provafile.append(prova.get(i).getTelefono());
			provafile.append(";");
			provafile.append(prova.get(i).getEmail());
			provafile.append("\n");
		}
		we.writeFileContent(provafile.toString(), file);
		
	}
	
	public void CaricareContatti() throws IOException { //riprendo il file csv che ho nel desktop e inserisco i contatti in un array
		File file = new File("C:\\Users\\Padawan03\\Desktop\\EsCsv.csv");
		List <String> FileCaricato = TextFileManager.readFileRows(file);
		ArrayList <Contatto> ListaContattiCaricati = new ArrayList<Contatto>();
		String[] split;
		for(int i=1;i<FileCaricato.size();i++) {
			Contatto appoggio = new Contatto();
			split = FileCaricato.get(i).split(";");
			for(int i1=0;i1<split.length;i1++) {
				if(i1==0)
				appoggio.setNome(split[i1]);
				if(i1==1)
					appoggio.setCognome(split[i1]);
				if(i1==2)
					appoggio.setTelefono(split[i1]);
				if(i1==3)
					appoggio.setEmail(split[i1]);
				
			}
			ListaContattiCaricati.add(appoggio);
			
		}	
		return;
		
	}
	
	public void CreaFileXml() throws Exception {     //prendo l'arraylist di contatti che in precedenza ho popolato partendo dal file csv e ne creo uno xml
		ParserXML xml = new ParserXML();
		EsercizioCSV provaz = new EsercizioCSV();
		List<Contatto> prova = provaz.CreaFileCsv(); 
		xml.writeContattiInFile(prova,"C:\\Users\\Padawan03\\Desktop\\EsCsv.xml");	
	}
	
	public void CreaCSVdaXML() throws Exception {   //prendo il file xml creato in precedenza e lo traduco in file csv
		EsercizioCSV provaz = new EsercizioCSV();
		List<Contatto> prova = new ArrayList<Contatto>();
		ParserXML xml = new ParserXML();
		prova= xml.getContattiFromFile("C:\\Users\\Padawan03\\Desktop\\EsCsv.xml");
		provaz.ScrivereContattiCsv(prova);
	}
	
	
}


