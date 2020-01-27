package rubrica;

import static rubrica.ParserXML.writeContattiInFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Metodi {
	public static Contatto impostaContatto() throws IOException
	{
		
		Contatto contatto = new Contatto();
		Scanner scanner = new Scanner(System.in);
		
		
		while(contatto.getCognome()==null)
		{
			System.out.println("inserisci cognome: ");
			contatto.setCognome(scanner.nextLine());
			
		}
		while(contatto.getNome()==null)
		{
			System.out.println("inserisci nome: ");
			contatto.setNome(scanner.nextLine());
			
		}
		while(contatto.getTelefono()==null)
		{
			System.out.println("inserisci telefono: ");
			contatto.setTelefono(scanner.nextLine());
			
		}
		while(contatto.getEmail()==null)
		{
			System.out.println("inserisci email: ");
			contatto.setEmail(scanner.nextLine());
			
		}

		return contatto;
		
			
	}
	
	
	public static String toCSV(Contatto contatto)
	{
		
		String stringa="";
		stringa += contatto.getCognome()+";"+contatto.getNome()+";"+contatto.getTelefono()+";"+contatto.getEmail()+'\n';
		return stringa;
	}
	
	
	public static void xmlToCSV()
	{
		
		
		
		
		
	}

	
	
	public static void toXML(List<Contatto> listaContatti ,File f) throws Exception
	{
		int i=0;
		int j=0;
		String stringa="";
		//stringa += readFileRows(f);
		List<String> listStringa = new ArrayList<>();
		listStringa.addAll(readFileRows(f));
		
	for(i=0;i<listStringa.size();i++)
		{
			Contatto contatto = new Contatto();
			
			
			contatto.setCognome(listStringa.get(i).split(";")[0]);
			contatto.setNome(listStringa.get(i).split(";")[1]);
			contatto.setTelefono(listStringa.get(i).split(";")[2]);
			contatto.setEmail(listStringa.get(i).split(";")[3]);
			listaContatti.add(contatto);
			
		}
		
		writeContattiInFile(listaContatti, "c:/work/prova.xml");
	}
	
	public static void writeFileContent(List<String> contentRows, File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
				
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		for (String row : contentRows) {
			bufferedWriter.append(row).append('\n');
		}
		
		bufferedWriter.flush();
		bufferedWriter.close();
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
		
		//IM 20200122 : approccio alternativo, utilizzo il metodo readFileRows e unisco nuovamente le righe
//		List<String> rows = readFileRows(file);
//		for (int r = 0; r < rows.size(); r++) {
//			builder.append(rows.get(r));
//			if (r < rows.size()-1) builder.append('\n');
//		}
		
		return builder.toString();
	}
	
	
	public static List<String> readFileRows(File file) throws IOException {
		List<String> rows = new ArrayList<String>();
		
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		while ((row = reader.readLine()) != null) {
			//System.out.println(row);
			rows.add(row);
		}
		
		System.out.println("rows size : " + rows.size());
		return rows;
	}
	
	
	
	public static void writeFileContent(String content, File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		
		fileWriter.write(content );
		
		
		fileWriter.flush();
		fileWriter.close();
	}
	
}

