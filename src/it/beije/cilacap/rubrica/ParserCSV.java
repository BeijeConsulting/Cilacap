package it.beije.cilacap.rubrica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParserCSV {
	
	public static List<Contatto> getContattiFromCsv(String pathfile) throws Exception {
		File file = new File(pathfile);
		return getContattiFromCsv(file);
	}

	public static List<Contatto> getContattiFromCsv(File file) throws Exception {
		if(!file.exists()) return null;
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		StringBuilder sb = new StringBuilder();
		while((row = reader.readLine()) != null) sb.append(row+"\n");
		reader.close();
		return fromStringToList(sb.toString());
	}
	
	public static void writeContattiInCsv(List<Contatto> c, String pathfile) throws Exception {
		File file = new File(pathfile);
		writeContattiInCsv(c, file);
	}
	
	public static void writeContattiInCsv(List<Contatto> contatti, File f) throws IOException {
		Scanner scan = new Scanner(System.in);
		StringBuilder content = new StringBuilder();
		int c;
		if(f.exists()) {
			FileReader fileReader = new FileReader(f);
			while((c=fileReader.read())>-1) content.append((char) c);
			fileReader.close();
		}
		else {
			for(String s : Contatto.INTESTAZIONE) content.append(s+";"); //aggiunge l'intestazione all'inizio dello StringBuilder
			content.append("\n");
		}
		content.append(fromListToString(contatti));
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.append(content.toString());
		bw.flush();
		bw.close();
		scan.close();
	}
	
	private static StringBuilder fromListToString(List<Contatto> list) {
		StringBuilder st = new StringBuilder();
		for(Contatto c : list) {
			for(String s : Contatto.INTESTAZIONE) {
				switch(s) {
					case "nome":
						st.append(c.getNome()+";");
						break;
					case "cognome":
						st.append(c.getCognome()+";");
						break;
					case "telefono":
						st.append(c.getTelefono()+";");
						break;
					case "email":
						st.append(c.getEmail()+";");
						break;
				}
			}
			st.append("\n");
		}
		return st;
	}
	
	private static List<Contatto> fromStringToList(String s){
		List<Contatto> lista = new ArrayList<Contatto>();
		String[] elementi = s.split("\n");
		String[] intestazioneFile = elementi[0].split(";");
		for(int k=1; k<elementi.length; k++) {
			String[] contattoString = elementi[k].split(";");
			Contatto cont = new Contatto();
			for(int i=0; i<contattoString.length; i++) {
				int j=ricercaIndex(intestazioneFile[i]);
				switch(Contatto.INTESTAZIONE[i]) {
					case "nome":
						cont.setNome(contattoString[j]);
						break;
					case "cognome":
						cont.setCognome(contattoString[j]);
						break;
					case "telefono":
						cont.setTelefono(contattoString[j]);
						break;
					case "email":
						cont.setEmail(contattoString[j]);
						break;
				}
			}
			lista.add(cont);
		}
		return lista;
	}
	private static int ricercaIndex(String cercaIndice) {
		for(int i=0; i<Contatto.INTESTAZIONE.length; i++) {
			if(cercaIndice.equalsIgnoreCase(Contatto.INTESTAZIONE[i])) return i;
		}
		return -1;
	}
}
