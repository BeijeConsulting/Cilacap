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
	
	
	public static ArrayList<String> inputReader() throws IOException {
		
		
		String answer;
		ArrayList<String> data = new ArrayList<String>();
		
		do {
		
			Scanner info0 = new Scanner(System.in);
			System.out.println("Enter name");
			data.add(info0.nextLine() + ";");
			
			Scanner info1 = new Scanner(System.in);
			System.out.println("Enter surname");
			data.add(info1.nextLine() + ";");
			
			Scanner info2 = new Scanner(System.in);
			System.out.println("Enter telephone");
			data.add(info2.nextLine() + ";");
			
			Scanner info3 = new Scanner(System.in);
			System.out.println("Enter email");
			data.add(info3.nextLine() + ";");
		
			data.add("\n");
			
			
			Scanner further = new Scanner(System.in);
			System.out.println("Do you wish to enter another name?");
			answer = further.nextLine();
			
			}
		
		while (answer.equalsIgnoreCase("yes")); 
		
		
				
		//System.out.println(data);
		return data;
	}
	
	
	public static void writerFile(ArrayList<String> data1) throws IOException {
		File file = new File("csv/copia1.txt");
		FileWriter fileWriter = new FileWriter(file);
		//BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		fileWriter.write("NOME;COGNOME;TELEFONO;EMAIL;\n");
		for (String dat : data1) {		
			fileWriter.write(dat);
		}

		fileWriter.flush();
		fileWriter.close();
		
		System.out.println("File Saved");
	}
	
	
	public static void main(String[] args) throws IOException {
		
			writerFile(inputReader());
	
	}

}
