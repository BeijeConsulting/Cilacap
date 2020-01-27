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
			//info0.close();
			
			Scanner info1 = new Scanner(System.in);
			System.out.println("Enter surname");
			data.add(info1.nextLine() + ";");
			//info1.close();
			
			Scanner info2 = new Scanner(System.in);
			System.out.println("Enter telephone");
			data.add(info2.nextLine() + ";");
			//info2.close();
			
			Scanner info3 = new Scanner(System.in);
			System.out.println("Enter email");
			data.add(info3.nextLine() + ";");
			//info3.close();
			
			data.add("\n");
			
			
			Scanner further = new Scanner(System.in);
			System.out.println("Do you wish to enter another name?");
			answer = further.nextLine();
			//further.close();
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
	
	public static void Reader() throws IOException {
		
		File continued = new File("csv/copia1.txt");
		
		FileReader fileReader = new FileReader(continued); // read the file
		
		BufferedReader reader = new BufferedReader(fileReader); // 	read the file line per line
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		
		Scanner firstQuestion = new Scanner(System.in);
		System.out.println("If you want to start a new register list, type 1. If you want to keep adding data to an existing list, type 2.");
		
		/*
		while (firstQuestion.nextInt() != 1 && firstQuestion.nextInt() != 2 ) {
			System.out.println("Please, enter the correct value of 1 or 2.");
		}*/
		
		if (firstQuestion.nextInt() == 1) {
			writerFile(inputReader());
		}
		else if (firstQuestion.nextInt() == 2) {
			Reader();
			writerFile(inputReader());
		}
		
		firstQuestion.close();
	}

}
