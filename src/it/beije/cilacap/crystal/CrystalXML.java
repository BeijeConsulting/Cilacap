package it.beije.cilacap.crystal;

import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.Attribute;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import it.beije.cilacap.esercizi.rubrica.Contatto;
import it.beije.cilacap.crystal.ReadCrystal;;

public class CrystalXML {

	public static void main(String[] args) throws Exception {

		File fileCrystal = new File("crystal/01/CDM_20200102131948.txt");
		System.out.println(fileCrystal.exists());

		List<String> contenutoCrystal = new ArrayList<String>();
		contenutoCrystal = ReadCrystal.readFileRows(fileCrystal);
		System.out.println(contenutoCrystal.toString());

		TestData datiDiCrystal = ReadCrystal.getTestData(contenutoCrystal);
		datiDiCrystal.setIdComputer(fileCrystal.getPath().substring(15, fileCrystal.getPath().length() - 4));

		ParserXML.createXML(datiDiCrystal);

	}

}