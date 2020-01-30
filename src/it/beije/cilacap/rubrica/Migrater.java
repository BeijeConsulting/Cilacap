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
	
	public static void fromCSVtoDB(File file) {
		List<Contatto> lista = ParserCSV.getContattiFromCsv(file);
		for(Contatto c : lista) {
			DBtools.insertContatto(c);
		}
	}
	
	public static void fromDBtoCSV(File newfile) {
		List<Contatto> lista = DBtools.leggiContatti();
		while(newFile.exists()) {
			Random r = new Random(20)
			newFile = new File("CSV"+r.getInt()+newFile.getName());
		}
		ParserCSV.writeContattiInCsv(lista, newFile.getAbsolutePath());
	}
	
	public static void fromXMLtoDB(File file) throws Exception {
		List<Contatto> lista = ParserXML.getContattiFromFile(file);
		for(Contatto c : lista) {
			DBtools.insertContatto(c);
		}
	}
	
	public static void fromDBtoXML(File newFile) throws Exception {
		List<Contatto> lista = DBtools.leggiContatti();
		while(newFile.exists()) {
			Random r = new Random(20)
			newFile = new File("XML"+r.getInt()+newFile.getName());
		}
		ParserXML.writeContattiInFile(lista, newFile.getAbsolutePath());
	}

}
