package it.beije.cilacap.rubrica;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import static it.beije.cilacap.esercizi.rubrica.EsercizioRubrica.writeInFileCSV;
import static it.beije.cilacap.esercizi.rubrica.EsercizioRubrica.writeInXML;;

public class EsercizioDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, ParserConfigurationException, TransformerException {
		List<Contatto> listaContatti=new ArrayList<Contatto>();
		listaContatti=DBtools.leggiContatti();
		File f1=new File("csv/database.csv");
		File f2=new File("xml/database.xml");
		writeInFileCSV(listaContatti, f1);
		writeInXML(listaContatti, f2);
	}
	
}
