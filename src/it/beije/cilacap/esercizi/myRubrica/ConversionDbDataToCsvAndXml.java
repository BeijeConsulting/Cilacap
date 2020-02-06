package it.beije.cilacap.esercizi.myRubrica;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class ConversionDbDataToCsvAndXml {
	
	public static int importInDbFromCsv(String csvPath) throws IOException, ClassNotFoundException {
		
		List<Contatto2> contatti = MyRubrica.caricaArrayListDiContattiFromCSV(csvPath);
		
		for(Contatto2 contatto: contatti) {
			DBtools.insertContatto(contatto);
		}
		
		return contatti.size();
	}
	
	public static int importInDbFromXml(String xmlPath) throws ParserConfigurationException, IOException, ClassNotFoundException, SAXException {
		
		List<Contatto2> contatti = MyRubrica.caricaArrayListDiContattiFromXML(xmlPath);
		
		for(Contatto2 contatto : contatti) {
			DBtools.insertContatto(contatto);
		}
		
		return contatti.size();
		
	}
	
	public static int exportDbInCsv(String csvPath) throws ClassNotFoundException, SQLException, IOException {
		
		List<Contatto2> contatti = DBtools.leggiContatti();
		MyRubrica.insertNewContattiOnFileCSV(csvPath, contatti);
		
		return contatti.size();
	}
	
	public static int exportDbInXml(String xmlPath) throws ParserConfigurationException, SAXException, IOException, TransformerException, ClassNotFoundException, SQLException {
		
		List<Contatto2> contatti = DBtools.leggiContatti();
		MyRubrica.updateConattiOnFileXML(xmlPath, contatti);
		
		return contatti.size();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, ParserConfigurationException, SAXException, SQLException, TransformerException {
		
		// import in db from .csv
		importInDbFromCsv("C:\\Users\\Padawan04\\Desktop\\newRubrica.csv");
		
		// import in db from .xml
		importInDbFromXml("C:\\Users\\Padawan04\\Desktop\\newRubrica.xml");
		
		// export from db to .csv
		exportDbInCsv("C:\\Users\\Padawan04\\Desktop\\newRubricaExported.csv");
		
		// export from db to .csv
		exportDbInXml("C:\\Users\\Padawan04\\Desktop\\newRubricaExported.xml");
	}
	
}
