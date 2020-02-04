package it.beije.cilacap.rubrica;

import java.util.List;

public class ConverterCSV_DB {
	
	public static void main(String[] args) throws Exception {
		
		List<Contatto> contacts = CSVtools.readCSVFile("csv/MyRubricaDBtoCSV.csv");
		DBtools.insertContatto(contacts);
		
	}

}
