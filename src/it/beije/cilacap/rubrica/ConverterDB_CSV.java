package it.beije.cilacap.rubrica;

import java.util.List;

public class ConverterDB_CSV {

	public static void main(String[] args) throws Exception {
		
		List<Contatto> contacts = DBtools.leggiContatti();
		CSVtools.writeCSVFile(contacts, "csv/MyRubricaDBtoCSV2.csv");
	}

}
