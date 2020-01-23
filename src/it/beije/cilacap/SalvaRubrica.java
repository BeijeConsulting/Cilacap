package it.beije.cilacap;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

//da scanner caricare Lista contatti e poi salvare nel file CSV
//caricare Lista contatti da Rubrica.CSV
//scrivere Lista contatti in file CSV
//programma trasferimento rubrica.csv in xml
//programma trasferimento rubrica.xml in csv

public class SalvaRubrica {

	public static void main(String[] args) throws IOException {
		String nome;
		String cognome;
		String telefono;
		String email;
		Scanner s = new Scanner(System.in);
		String verifica = "-1";
		ArrayList<String> array = new ArrayList<String>();
		File file = new File("rubrica.txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fw);

		while (!verifica.equalsIgnoreCase("N")) {
			cognome = new String();
			nome = new String();
			telefono = new String();
			email = new String();
			while (nome.equals("")) {
				System.out.println("inserisci nome");
				nome = s.nextLine();
			}
			while (cognome.equals("")) {
				System.out.println("inserisci cognome");
				cognome = s.nextLine();
			}
			while (telefono.equals("")) {
				System.out.println("inserisci telefono");
				telefono = s.nextLine();
			}
			while (email.equals("")) {
				System.out.println("inserisci email");
				email = s.nextLine();
			}
			array.add(nome);
			array.add(cognome);
			array.add(telefono);
			array.add(email);
			System.out.println("vuoi inserire nuovi contatti ? S/N");
			verifica = s.nextLine();
			StringBuilder builder = new StringBuilder();
			ArrayList<String> arrayList = new ArrayList<String>();
			if (verifica.equalsIgnoreCase("N")) {
				for (String row : array) {
					System.out.println(row);
					bufferedWriter.append(row).append('\n');

				}
				System.out.println();
				builder.append(bufferedWriter);
				//bufferedWriter.flush();
				bufferedWriter.close();
			}
		}
	}

}
