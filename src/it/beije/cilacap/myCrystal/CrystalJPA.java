package it.beije.cilacap.myCrystal;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;


public class CrystalJPA {
	
	// write in DB using JPA from List<TestData>
	public static void writeJPAListOfContactsIntoDB(List<TestData> lista) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapCrystal");
		
		for(TestData testData : lista) {
			
			EntityManager entityManager = factory.createEntityManager();
			entityManager.getTransaction().begin();
			
			entityManager.persist(testData);
			
			int id_testdata = testData.getId();
			
			// test_row
			for(TestRow testRowRead : testData.getRead()) {
				testRowRead.setId_testdata(id_testdata);
				testRowRead.setMode_type("r");
				entityManager.persist(testRowRead);
				//entityManager.getTransaction().commit();
				
			}
			for(TestRow testRowWrite : testData.getWrite()) {
				testRowWrite.setId_testdata(id_testdata);
				testRowWrite.setMode_type("w");
				entityManager.persist(testRowWrite);
				//entityManager.getTransaction().commit();
			}
			
			entityManager.getTransaction().commit();
			entityManager.close();		
		}
		
		System.out.println(lista.size());
	}
	
	// read in List<TestData> from DB using JPA
	public static List<TestData> readJPAListOfContactsFromDB() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapCrystal");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		String jpql = "SELECT test FROM TestData as test";
		
		TypedQuery<TestData> query = entityManager.createQuery(jpql, TestData.class);
		List<TestData> listaTestData = query.getResultList();
		
		for(TestData testData : listaTestData) {
			
			String testRowQueryRead = "SELECT row FROM TestRow AS row WHERE mode_id = 'r'";
			TypedQuery<TestRow> queryRowRead = entityManager.createQuery(testRowQueryRead, TestRow.class);
			List<TestRow> listRead = queryRowRead.getResultList();
			
			String testRowQueryWrite = "SELECT row FROM TestRow AS row WHERE mode_id = 'w'";
			TypedQuery<TestRow> queryRowWrite = entityManager.createQuery(testRowQueryWrite, TestRow.class);
			List<TestRow> listWrite = queryRowWrite.getResultList();
			
			testData.setRead(listRead);
			testData.setWrite(listWrite);
			
			System.out.println("\tRead : " + listRead.size() + "\n\tWrite : " + listWrite.size());
			
		}
		
		System.out.println("Test data : " + listaTestData.size());
		
		return listaTestData;
	}
	
	
	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
		writeJPAListOfContactsIntoDB(MainCristal.getAllFiles("crystal/"));
	}
	
}
