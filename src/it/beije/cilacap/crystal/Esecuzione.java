package it.beije.cilacap.crystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Esecuzione {
	
	public static void main(String[] args) throws Exception {
		TestData test = new TestData();
		String memorizza = "";
		String temp = null;
		String percorso = "crystal/01/CDM_20200102131948.txt";
		File f = new File(percorso);
		FileReader filereader = new FileReader(f);
		BufferedReader reader = new BufferedReader(filereader);
		String row = "";
		ArrayList<String> prova = new ArrayList<>();
		while ((row = reader.readLine()) != null) {
			if (row.length() != 1) {
				row = row.replace((char) 0, " ".charAt(0)).replace(" ", "");
				prova.add(row);

			}
		}

		for (String riga : prova) {
			System.out.println(riga);
		}
		for (int i = 0; i < prova.size(); i++) {
			memorizza = prova.get(i);
			if (memorizza.contains("Mark")) {
				temp=memorizza;
				// CrystalDiskMark7.0.0x64(C)2007-2019hiyohiyo
				temp = temp.substring(temp.indexOf("Mark") + 4, temp.indexOf("(C"));
				test.setVersion(temp);
			}
			if (memorizza.contains("OS")) {
				//OS:Windows10[10.0 Build 18363] (x64)
				temp=memorizza;
				temp=temp.substring(temp.indexOf(":")+1,temp.indexOf("0")).concat(temp.substring(temp.indexOf("]")+1,temp.indexOf(")")));
				test.setOs(temp);
				}
			//   Test: 1 GiB (x5) [Interval: 5 sec] <DefaultAffinit=DISABLED>
			if(memorizza.contains("Test")) {
				temp=memorizza;
				temp=temp.substring(temp.indexOf(":")+1,temp.indexOf("("));
				test.setType(temp);
				
			}
			if(memorizza.contains("Test")) {
				// Test:1GiB(x5)[Interval:5sec]<DefaultAffinity=DISABLED>
				temp=memorizza;
				temp=temp.substring(temp.indexOf("(")+2,temp.indexOf(")"));
				test.setIterations(Integer.parseInt(temp));
				
			}
			
			
			

		}
	}

}
