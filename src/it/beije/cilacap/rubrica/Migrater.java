package it.beije.cilacap.rubrica;

import java.util.List;
import java.io.File;

public class Migrater {
	
	public static void fromXMLtoCSV(File file) throws Exception {
		List<Contatto> lista = ParserXML.getContattiFromFile(file);
		File newFile = new File("CSV"+file.getName());
		if(newFile.exists()) newFile.delete();
		ParserCSV.writeContattiInCsv(lista, newFile.getAbsolutePath());
	}
	
	public static void fromCSVtoXML(File file) throws Exception {
		List<Contatto> lista = ParserCSV.getContattiFromCsv(file);
		File newFile = new File("XML"+file.getName());
		if(newFile.exists()) newFile.delete();
		ParserXML.writeContattiInFile(lista, newFile.getAbsolutePath());
	}

}
