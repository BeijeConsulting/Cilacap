package it.beije.cilacap.rubrica;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



public class FileWriterExercise {

	public static void Reader() {
		
		//StringBuilder data = new StringBuilder();
		String answer;
		ArrayList<String> data = new ArrayList<String>();
		
		do {
		
		Scanner info0 = new Scanner(System.in);
		System.out.println("Enter name");
		data.add(info0.nextLine());
		//String name = info0.nextLine();
		
		
		Scanner info1 = new Scanner(System.in);
		System.out.println("Enter surname");
		data.add(info1.nextLine());
		//String surname = info1.nextLine();
		
		
		Scanner info2 = new Scanner(System.in);
		System.out.println("Enter telephone");
		data.add(info2.nextLine());
		//String telephone = info2.nextLine();
		
		
		Scanner info3 = new Scanner(System.in);
		System.out.println("Enter email");
		data.add(info3.nextLine());
		//String email = info3.nextLine();
		
		
		
			
		Scanner further = new Scanner(System.in);
		System.out.println("Do you wish to enter another name?");
		answer = further.nextLine(); }
		
		while (answer.equalsIgnoreCase("yes")); 
			
		System.out.println(data);
		
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
	
	public static void writeFileContent(List<String> data, String filePath) throws IOException {
		File file = new File(filePath);
		writeFileContent(data, file);
	}

	public static void writeFileContent(List<String> data, File file) throws IOException {
		
		//contentRows = data;
		
		FileWriter fileWriter = new FileWriter(file);

		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		for (String row : data) {
			bufferedWriter.append(row).append('\n');
		}

		bufferedWriter.flush();
		bufferedWriter.close();
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Reader();
		
		//File f = new File("csv/rubrica1.csv");
		
		//writeFileContent(readFileContent(f), "csv/copia1.txt");
		//writeFileContent(readFileRows(f), "csv/copia2.txt");

	}

}
