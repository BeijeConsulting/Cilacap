package it.beije.cilacap.rubrica;

import java.io.File;

import java.util.List;

public class ConverterXML_DB {
	
	public static List<Contatto> getContattiFromFile(String pathfile) throws Exception {
		
		File file = new File(pathfile);
		
		return XMLtools.getContattiFromFile(file);
	}
	
	public static void main(String[] args) throws Exception {
	
		List<Contatto> contacts = getContattiFromFile("xml/rubrica.xml");
		DBtools.insertContatto(contacts);
	}

}
