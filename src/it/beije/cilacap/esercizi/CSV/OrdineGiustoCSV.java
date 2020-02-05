package it.beije.cilacap.esercizi.CSV;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

public class OrdineGiustoCSV {

private static final String[]intestazioneDesiderata= {"nome", "cognome", "telefono", "email", "indirizzo"};
private static String[] intestazioneFile;

public static void main(String[] args) throws IOException {
	File f = new File("C:/Users/Padawan07/git/Cilacap/csv/rubrica2.csv");
		if(!f.exists()) {
			System.out.println("File non trovato");
			return;
		}
			printFileFormatted(f);
		}
		

		
		private static void printFileFormatted(File f) throws IOException{
			FileReader fileReader= new FileReader(f);
			BufferedReader br = new BufferedReader(fileReader);
			String csvSplitBy=";";
			intestazioneFile=br.readLine().split(csvSplitBy);
			String line;
			List<String[]> country=new ArrayList<>();
			
				while ((line=br.readLine())!=null) {
					country.add(line.split(csvSplitBy));
					}
				
				for(String[] campo: country) {
					for(int i=0;i<campo.length;i++) {
						int j=ricercaIndex(intestazioneDesiderata[i]);
						if(j!=-1) System.out.println(intestazioneDesiderata[i]+ ":" + campo[j]);
			}
					System.out.println();
					br.close();
				}
			}
		
		
		private static int ricercaIndex(String cercaIndice) {
			for(int i=0;i<intestazioneFile.length;i++) {
				if(cercaIndice.equalsIgnoreCase(intestazioneFile[i])) return i;
			}
			return -1;
		}
			
		public static String readFileContent(File file) throws IOException {
			StringBuilder builder = new StringBuilder();
			
			FileReader fileReader = new FileReader(file);
			int c;
			while ((c = fileReader.read()) > -1) {
				builder.append((char)c);
			}
			fileReader.close();
			return builder.toString();
				
		}
		
}


				
			
		
		
		
	

