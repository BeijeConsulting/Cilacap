package it.beije.cilacap.rubrica;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EsercizioDB {

	
	
	public static void scriviCSV(List <Contatto> contatti, File f1 ) throws IOException {
		
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
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		List<Contatto> listaContatti=new ArrayList<Contatto>();
		listaContatti=DBtools.leggiContatti();
		File f1=new File("csv/database.csv");
		scriviCSV(listaContatti, f1);
	}
	
}
