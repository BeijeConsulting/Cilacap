package it.beije.cilacap.crystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyCristal {
	
	
	public static void main(String[] args) throws IOException {
		String path="C:\\Users\\Padawan07\\git\\Cilacap\\crystal\\07\\CDM_20200103150916.txt";
		File f= new File(path);
		TestData test= new TestData();
		FileReader fileReader = new FileReader(f);
		BufferedReader reader= new BufferedReader(fileReader);
		String row =reader.readLine();
		List<String> ls =new ArrayList<>();
		while(row!=null) {
//			System.out.println(row);
			ls.add(row);
			row=reader.readLine();
		}
		String prova = ls.get(2);
		System.out.println(prova);
	}

}
