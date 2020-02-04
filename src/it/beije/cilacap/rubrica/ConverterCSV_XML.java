package it.beije.cilacap.rubrica;

import java.util.List;

public class ConverterCSV_XML {
	
	public static void main(String[] args) throws Exception {
		
		List<Contatto> contacts = CSVtools.readCSVFile("csv/rubrica3.csv");
		XMLtools.writeContattiInFile(contacts, "xml\\MyRubricaCSVtoXML4.xml");
		
	}

}
