package it.beije.cilacap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EsFile {
	public static void main(String[] args) throws IOException {

		File f = new File("csv/rubrica4.csv");
		FileReader fileReader = new FileReader(f);
		BufferedReader reader = new BufferedReader(fileReader);

		String row;
		String[] credenziali = new String[10];
		int count = 0;
		int headerLength = 0;

		while ((row = reader.readLine()) != null) {
			String[] header = row.split(";");

			if (count == 0) {
				for (int i = 0; i < header.length; i++) {
					credenziali[i] = header[i];
				}

				headerLength = header.length;
				count++;
				continue;

			} else {
				System.out.println(row + "\n");

				for (int i = 0; i < headerLength; i++) {

					System.out.print(credenziali[i] + ": ");

					if (header.length > i) {
						System.out.println(header[i]);
					} else {
						System.out.println();
					}

				}

				System.out.println("\n");
			}
		}
		
		reader.close();
	}
}

