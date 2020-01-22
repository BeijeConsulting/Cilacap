package it.beije.cilacap.es_FileCSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileCSV {
	
	private static final String[] intestazioneDesiderata = {"nome", "cognome", "telefono", "email", "indirizzo"};
	private static String[] intestazioneFile;

	public static void main(String[] args) throws Exception {
		File f = new File("C:\\Users\\Padawan09\\git\\Cilacap\\src\\it\\beije\\cilacap\\es_FileCSV\\csv\\rubrica2.csv");
		if(!f.exists()) {
			System.out.println("file non trovato");
			return;
		}
		printFileFormatted(f);
	}
	
	private static void printFileFormatted(File f) throws IOException {
		FileReader fileReader = new FileReader(f);
		BufferedReader reader = new BufferedReader(fileReader);
		ArrayList<String[]> elenco = new ArrayList<>();
		intestazioneFile = reader.readLine().split(";");
		String row;
		while((row = reader.readLine()) != null) {
			elenco.add(row.split(";"));
		}
		for(String[] campo : elenco) {
			for(int i=0; i<campo.length; i++) {
				int j=ricercaIndex(intestazioneDesiderata[i]);
				if(j!=-1) System.out.println(intestazioneDesiderata[i] + ":" + campo[j]);
			}
			System.out.println();
		}
		reader.close();
	}

	private static int ricercaIndex(String cercaIndice) {
		for(int i=0; i<intestazioneFile.length;i++) {
			if(cercaIndice.equalsIgnoreCase(intestazioneFile[i])) return i;
		}
		return -1;
	}
	
	public String readFileContent(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		StringBuilder str = new StringBuilder();
		int c;
		while((c=fileReader.read())>-1) str.append((char) c);
		fileReader.close();
		return str.toString();
	}
	
	public static void writeFileContent(String content, File file) throws IOException {
		FileWriter fw = new FileWriter(file);
		fw.write(content);
		fw.close();
	}

}
