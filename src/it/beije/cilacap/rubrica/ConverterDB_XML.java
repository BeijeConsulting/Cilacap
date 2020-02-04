package it.beije.cilacap.rubrica;

import java.util.List;

public class ConverterDB_XML {
	
	public static void main(String[] args) throws Exception {
		
		List<Contatto> contacts = DBtools.leggiContatti();
		XMLtools.writeContattiInFile(contacts, "xml\\MyRubricaDBtoXML2.xml");

	}

}
