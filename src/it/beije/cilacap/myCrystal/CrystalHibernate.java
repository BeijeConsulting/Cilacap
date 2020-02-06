package it.beije.cilacap.myCrystal;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.xml.sax.SAXException;


public class CrystalHibernate {

	public static void insertIntoDbUsingHibernate(List<TestData> listTestData) {
		Configuration configuration = new Configuration();
		configuration = configuration.configure()
				.addAnnotatedClass(TestRow.class)
				.addAnnotatedClass(TestData.class);
				
		
		//chiedo generatore di sessioni
		SessionFactory factory = configuration.buildSessionFactory();
		
		//apro sessione
		Session sessionTestData = factory.openSession();
		
		for(TestData testData : listTestData) {
			
			// insert in testdata
			sessionTestData.save(testData);
			
			// insert in test_row
			int id_testdata = testData.getId();
			
			for(TestRow read : testData.getRead()) {
				read.setId_testdata(id_testdata);
				read.setMode_type("r");
				sessionTestData.save(read);
			}
			
			for(TestRow write : testData.getWrite()) {
				write.setId_testdata(id_testdata);
				write.setMode_type("w");
				sessionTestData.save(write);
			}
		}
		sessionTestData.close();
		
	}
	
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		// rinominare hibernate.cfg.old in hibernate.cfg.xml
		insertIntoDbUsingHibernate(MainCristal.getAllFiles("crystal/"));
	}
	
}
