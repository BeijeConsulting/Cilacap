package it.beije.cilacap;

import java.util.List;

import it.beije.cilacap.rubrica.Contatto;

public class ProvaTool {
	
	public static void main(String[] args) throws Exception {
		CSVTool csvTool = new CSVTool();
		XMLTool xmlTool = new XMLTool();
		
		String path = "C:/work/Provaa.txt";
		List<Contatto> contatti = csvTool.ReaderCSV(path);
		
		String pathfile = "C:/work/Provaxml.xml";
		xmlTool.writeContattiInFile(contatti, pathfile);
	}

}
