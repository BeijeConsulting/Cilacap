package it.beije.cilacap.esercizi.rubrica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TextFileManager {

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
		
		//IM 20200122 : approccio alternativo, utilizzo il metodo readFileRows e unisco nuovamente le righe
//		List<String> rows = readFileRows(file);
//		for (int r = 0; r < rows.size(); r++) {
//			builder.append(rows.get(r));
//			if (r < rows.size()-1) builder.append('\n');
//		}
		
		return builder.toString();
	}
	
	public static List<String> readFileRows(String filePath) throws IOException {
		File file = new File(filePath);
		
		return readFileRows(file);
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

	public static void writeFileContent(List<String> contentRows, String filePath) throws IOException {
		File file = new File(filePath);
		writeFileContent(contentRows, file);
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

	public static void main(String[] args) throws IOException {
		File f = new File("csv/rubrica1.csv");
		
//		System.out.println("f.exists() ? " + f.exists());
//		System.out.println("f.getAbsolutePath() : " + f.getAbsolutePath());

//		System.out.println(readFileContent(f));
//		System.out.println(readFileRows(f));
		
		writeFileContent(readFileContent(f), "csv/copia1.txt");
		writeFileContent(readFileRows(f), "csv/copia2.txt");
		
		
		System.out.println("the end");
	}

}
