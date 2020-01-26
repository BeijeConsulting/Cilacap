package it.beije.cilacap.myCrystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainCristal {
	
	private static String getCaratteriAmmessi() {
		StringBuilder caratteriAmmessi = new StringBuilder();
		for(int c = 32; c < 126; c++) {
			caratteriAmmessi.append((char)c);
		}
		return caratteriAmmessi.toString();
	}

	@SuppressWarnings("resource")
	public static String fileContent(String file) throws IOException {
		
		String charAmmessi = getCaratteriAmmessi();
		StringBuilder rows = new StringBuilder();
		
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		
		String row;
		
		while ((row = reader.readLine()) != null) {
			rows.append(row);
		}
		
		StringBuilder stringOk = new StringBuilder();
		
		for(int i = 0; i < rows.length(); i++) {
			if(charAmmessi.indexOf(rows.charAt(i)) != -1) {
				stringOk.append(rows.charAt(i));
			}
		}

		return stringOk.toString();
		
	}
	
	
	public static TestData addContentToList(String s, String idComputer) {
		
		List<TestRow> listRead = new ArrayList<TestRow>();
		List<TestRow> listWrite = new ArrayList<TestRow>();
		
		TestData testData = new TestData();
		testData.setIdComputer(idComputer);
		testData.setVersion(CrystalUtil.getTest(s)[0]);
		testData.setOs(CrystalUtil.getTest(s)[1]);
		testData.setType(CrystalUtil.getTest(s)[2]);
		testData.setIterations(Integer.parseInt(CrystalUtil.getTest(s)[3]));
		testData.setInterval(CrystalUtil.getTest(s)[4] + " sec");
		testData.setDate(CrystalUtil.getTest(s)[5]);
		
		for(int i = 0; i < CrystalUtil.getMBsRead(s).length; i++) {
			
			TestRow testRowRead = new TestRow();
			
			if(i <= 2) {
				testRowRead.setType("Sequential_1MiB");
			} else {
				testRowRead.setType("Random_4KiB");
			}
			
			testRowRead.setQ(Integer.parseInt(CrystalUtil.getQRead(s)[i]));
			testRowRead.setT(Integer.parseInt(CrystalUtil.getTRead(s)[i]));
			testRowRead.setMbs(Double.parseDouble(CrystalUtil.getMBsRead(s)[i]));
			testRowRead.setIops(Double.parseDouble(CrystalUtil.getIOPSRead(s)[i]));
			testRowRead.setUs(Double.parseDouble(CrystalUtil.getUsRead(s)[i]));
			
			listRead.add(testRowRead);
		}
		
		for(int i = 0; i < CrystalUtil.getMBsWrite(s).length; i++) {
			
			TestRow testRowWrite = new TestRow();
			
			if(i <= 2) {
				testRowWrite.setType("Sequential_1MiB");
			} else {
				testRowWrite.setType("Random_4KiB");
			}
			
			testRowWrite.setQ(Integer.parseInt(CrystalUtil.getQWrite(s)[i]));
			testRowWrite.setT(Integer.parseInt(CrystalUtil.getTWrite(s)[i]));
			testRowWrite.setMbs(Double.parseDouble(CrystalUtil.getMBsWrite(s)[i]));
			testRowWrite.setIops(Double.parseDouble(CrystalUtil.getIOPSWrite(s)[i]));
			testRowWrite.setUs(Double.parseDouble(CrystalUtil.getUsWrite(s)[i]));
			
			listWrite.add(testRowWrite);
		}
		
		testData.setRead(listRead);
		testData.setWrite(listWrite);
		
		return testData;
	}
	
	public static void getFiles(String rootPath) throws IOException {
		File folder = new File(rootPath);
		for(File f : folder.listFiles()) {
			
			if(f.isDirectory()) {
				
				String newPath = rootPath + f.getName();
				
				File ff = new File(newPath);
				
				String pathXML = ff.getParent() + "\\" + f.getName() + "\\" + f.getName() + ".xml";
				
				List<TestData> testData = new ArrayList<TestData>();
				
				for(File file : ff.listFiles()) {
					testData.add(addContentToList(fileContent(file.getPath()), f.getName()));
				}
				
				writeXML(pathXML, testData);
			}
		}
	}
	
	public static void writeXML(String pathXML, List<TestData> listTestData) {
		
	}
	

	public static void main(String[] args) throws IOException {
		getFiles("crystal/");
	}

}
