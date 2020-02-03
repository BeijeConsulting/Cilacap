package it.beije.cilacap.rubrica;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManagement {
	
	
	static int choice;
	static String answer;

	public static String getPath(int choicePath) {
		
		int choice = choicePath;
		String pathChosen = "";
		
		if (choice == 1) {
			pathChosen = "csv/rubrica1.csv";
		}
		else if (choice == 2) {
			pathChosen = "csv/rubrica2.csv";
		}
		else if (choice == 3) {
			pathChosen = "csv/rubrica3.csv";
		}
		else if (choice == 4) {
			pathChosen = "csv/rubrica4.csv";
		}
		return pathChosen;
	}

	
	public static ArrayList<String> inputReader() throws IOException {
			
		
		ArrayList<String> data = new ArrayList<String>();
		
			
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
				
		Scanner info4 = new Scanner(System.in);
		System.out.println("Enter address");
		data.add(info4.nextLine() + ";");
				
		data.add("\n");
				
		//System.out.println(data);
		return data;
	}
	
	
	public static int[] fileReader(String path) throws IOException {
		
		path = getPath(choice);
		
		FileReader fileReader = new FileReader(path); // read the file
		
		BufferedReader reader = new BufferedReader(fileReader); // 	read the file line per line
		
		String row = reader.readLine();
		String[] fields = row.split(";");
		final int[] arrayIndex = new int[5];
  		int counterColumns;       // Variable to count number of columns in the first line
  		
		
		//Creating indexes for each column
  		
			for(counterColumns = 0; counterColumns <= fields.length-1; counterColumns++) {
				
				if (fields[counterColumns].contentEquals("NOME")) {
					arrayIndex[0] = counterColumns;
				}
				if (fields[counterColumns].contentEquals("COGNOME")) {
					arrayIndex[1] = counterColumns;
				}
				if (fields[counterColumns].contentEquals("TELEFONO")) {
					arrayIndex[2] = counterColumns;
				}
				if (fields[counterColumns].contentEquals("EMAIL")) {
					arrayIndex[3] = counterColumns;
				}
				if (fields[counterColumns].contentEquals("INDIRIZZO")) {
					arrayIndex[4] = counterColumns;
				}
			
			}
  		
		return arrayIndex;
			
	}
	
	public static void writerFile(String path, ArrayList<String> data1, int[] index) throws IOException {
		
		path = getPath(choice);
		index = fileReader(path);
		
		FileWriter fileWriter = new FileWriter(path, true);
		
		//fileWriter.write("\n");
		
		for (int i = 0; i < 5; i++) {
			if (index[i] == 0) {
				fileWriter.write(data1.get(0));
			}
			if (index[i] == 1) {
				fileWriter.write(data1.get(1));
			}
			if (index[i] == 2) {
				fileWriter.write(data1.get(2));
			}
			if (index[i] == 3) {
				fileWriter.write(data1.get(3));
			}
			if (index[i] == 4) {
				fileWriter.write(data1.get(4));
			}
			
		} 
		
		fileWriter.write("\n");
		
		fileWriter.flush();
		fileWriter.close();
		
	}
		
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		Scanner path = new Scanner(System.in);
		System.out.println("Please choose the file in which you would like to make the registration");
		choice = path.nextInt();
		
		Scanner initiate = new Scanner(System.in);
		System.out.println("Would you like to initiate a new registration? (Y/N)");
		
		if (initiate.nextLine().equalsIgnoreCase("Y")) {
			
			do {
			
				writerFile(getPath(choice),inputReader(), fileReader(getPath(choice)));
			
				Scanner further = new Scanner(System.in);
				System.out.println("Do you wish to enter another name? (Y/N)");
				answer = further.nextLine();
			
			} while (answer.equalsIgnoreCase("Y")); 
			
		}
		
		System.out.println("File Saved");
	}

}
