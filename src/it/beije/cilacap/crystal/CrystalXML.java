package it.beije.cilacap.crystal;

import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrystalXML {
	
	public static List<String> readFileRows(String filePath) throws IOException {
		File file = new File(filePath);
		
		return readFileRows(file);
	}

	public static List<String> readFileRows(File file) throws IOException {
		List<String> rows = new ArrayList<String>();
		
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		while ((row = reader.readLine()) != null) {
			System.out.println(row);
			rows.add(row);
		}
		
		System.out.println("rows size : " + rows.size());
		return rows;
	}
	
	static int i;

	public static TestData  createListOfData(List <String> contenuto) {
		TestData info= new TestData();
		//CE 20200125: creazione array con il contenuto del file, separati dal \n
		String[] dati= new String[contenuto.size()];
		dati=contenuto.toArray(dati);

		for(; i<dati.length;i++) {
			System.out.println("nel for di createdListOfData");
		//CE 20200125: creazione array con le parole di una riga.
			String [] riga= dati[i].split(" ");
			
		//CE 20200125: inizio analisi della riga
			CICLO: for(int j=0; j<riga.length; j++) {
//				System.out.println("nel for di createdList colonna");
//				System.out.println(riga[j]);
				String colonna= riga[j].trim();
//				System.out.println(colonna);
				String parola=createWord(colonna);		
////				System.out.println(parola.equalsIgnoreCase("Profile:"));
//				if(parola.equalsIgnoreCase("Profile:")) {
//					takeProfileFieldData(info, dati);
//				}else
				System.out.println(parola);
					if(parola.equalsIgnoreCase("CrystalDiskMark")) {
						info.setVersion(createWord(riga[++j].trim())+ " "+ createWord(riga[++j].trim()));
					}
					if(parola.equalsIgnoreCase("[Read]")) {
					takeReadFieldData(info, dati);
					break CICLO;
					}
//				}else if(parola.equalsIgnoreCase("[Write]:")) {
//					takeProfileFieldData(info, dati);
//				}
//				switch(parola) {
//				
//				case "Profile:": 
//					takeProfileFieldData(info, dati);
//					break;
//				case "[Read]":
//					takeReadFieldData(info, dati);
//					break;
//				case "[Write]":
//					takeWriteFieldData(info, dati);
//					break;	
//				default:break;
//				}
			}
		}
		return info;
	}
	
	
	//CE 20200124: metodo per estrapolare i dati nel campo profile default
	public static void takeProfileFieldData(TestData info, String [] dati) {
		System.out.println("dentro takeProfileFieldData");
		for (;i<dati.length;i++) {
			String [] riga= dati[i].split(" ");
//			System.out.println("for i");
			for(int col=0;col<riga.length;col++) {
//				System.out.println("for j");
				String parola= createWord(riga[col]);
//				System.out.println(parola);
				String colonna= riga[col].trim();
				
				switch(parola) {
					case "Test:": 
									info.setType(createWord(riga[col+1])+" " +createWord(riga[col+2]));
//									System.out.println(info.getType());
									info.setIterations(createWord(riga[col+3]).charAt(2)- '0');
//									System.out.println(info.getIterations());
									break;
					case "[Interval:":  
						                info.setInterval(createWord(riga[col+1])+ " "+ createWord(riga[col+2]).substring(0,3) );
//										System.out.println(info.getInterval());
										break;
					case "Date:": 
						          info.setDate(createWord(riga[col+1])+ " "+ createWord(riga[col+2])); 
//								  System.out.println(info.getDate());break;
					case "OS:": 
						        info.setOs(createWord(riga[col+1])+ " " + createWord(riga[col+2]));
//								System.out.println(info.getDate());
								break;
				}
			}
		}
		
	}
	
	//CE 20200127: metodo per prendere i dati della sezione read
	public static void takeReadFieldData(TestData info, String[] dati) {
		List<TestRow> listaRead = new ArrayList<TestRow> ();
		
		System.out.println("dentro metodo takereadfielddata");
		
		CICLO_INIZIALE: for(; i<dati.length; i++) {
			String [] riga= dati[i].split(" ");
			List <String> listRiga= new ArrayList<String>();
			
			for(int k=0; k<riga.length;k++) {
				String parola= createWord(riga[k]);
				if(parola.length()!=0)
					listRiga.add(parola);
			}
			riga=listRiga.toArray(new String[0]);
			TestRow raccoltaDatiRead= new TestRow();
			for(int j =0; j<riga.length; j++) {
				
//            		String parola= createWord(riga[j]);
//					System.out.println(parola.length());
					
				
//					System.out.println(riga[j]);
					String colonna= riga[j].trim();
					
					if(colonna.equalsIgnoreCase("[Write]")) {
						takeWriteFieldData(info, dati);
						break CICLO_INIZIALE;
					}
					
					
					switch(colonna) {
					case "Sequential":
										raccoltaDatiRead.setType(createWord(riga[++j]).charAt(0)+" "+ createWord(riga[j]).substring(1));
										System.out.println(raccoltaDatiRead.getType());
										break;
					case "(Q=": 		
										raccoltaDatiRead.setQ(createWord(riga[++j]).charAt(0)-'0');
										System.out.println(raccoltaDatiRead.getQ());
										break;
										
					case "T=":       
										//	System.out.println(createWord(riga[j+5]));
										raccoltaDatiRead.setT(riga[++j].charAt(0)-'0');
										raccoltaDatiRead.setMbs(Double.parseDouble(riga[++j]));
										System.out.println(raccoltaDatiRead.getT());
										System.out.println(raccoltaDatiRead.getMbs());
										break;
					case"[": 			
										raccoltaDatiRead.setIops(Double.parseDouble(riga[++j]));
										System.out.println(raccoltaDatiRead.getIops());
										break;
					case"<":
										raccoltaDatiRead.setUs(Double.parseDouble(riga[++j]));
										System.out.println(raccoltaDatiRead.getUs());
										break;
	
					}
				
				}
				listaRead.add(raccoltaDatiRead);
			}
		info.setRead(listaRead);
		}
		
	
//CE 20200128: metodo per leggere i dati delle rige in write 	
public static void takeWriteFieldData(TestData info, String[] data) {
		
List<TestRow> listaWrite = new ArrayList<TestRow> ();
		
		System.out.println("dentro metodo takeWritefielddata");
		
		CICLO_INIZIALE: for(; i<data.length; i++) {
			String [] riga= data[i].split(" ");
			List <String> listRiga= new ArrayList<String>();
			
			for(int k=0; k<riga.length;k++) {
				String parola= createWord(riga[k]);
				if(parola.length()!=0)
					listRiga.add(parola);
			}
			riga=listRiga.toArray(new String[0]);
			TestRow raccoltaDatiWrite= new TestRow();
			for(int j =0; j<riga.length; j++) {
				
//            		String parola= createWord(riga[j]);
//					System.out.println(parola.length());
					
					
				
//					System.out.println(riga[j]);
					String colonna= riga[j].trim();
					
					if(colonna.equalsIgnoreCase("Profile:")) {
						System.out.println("è uguale");
						takeProfileFieldData(info, data);
						break CICLO_INIZIALE;
					}
					
					
					switch(colonna) {
					case "Sequential":
										raccoltaDatiWrite.setType(createWord(riga[++j]).charAt(0)+" "+ createWord(riga[j]).substring(1));
//										System.out.println(raccoltaDatiWrite.getType());
										break;
					case "(Q=": 		
										raccoltaDatiWrite.setQ(createWord(riga[++j]).charAt(0)-'0');
//										System.out.println(raccoltaDatiWrite.getQ());
										break;
										
					case "T=":       
										//	System.out.println(createWord(riga[j+5]));
										raccoltaDatiWrite.setT(riga[++j].charAt(0)-'0');
										raccoltaDatiWrite.setMbs(Double.parseDouble(riga[++j]));
										System.out.println(raccoltaDatiWrite.getT());
										System.out.println(raccoltaDatiWrite.getMbs());
										break;
					case"[": 			
										raccoltaDatiWrite.setIops(Double.parseDouble(riga[++j]));
										System.out.println(raccoltaDatiWrite.getIops());
										break;
					case"<":
										raccoltaDatiWrite.setUs(Double.parseDouble(riga[++j]));
										System.out.println(raccoltaDatiWrite.getUs());
										break;
	
					}
				
				}
				listaWrite.add(raccoltaDatiWrite);
			}
		info.setWrite(listaWrite);
		System.out.println("Finito");
		
			
		}
	//CE 20200127: metodo per eliminare gli spazi null e creare la parola
	public static String createWord(String colonna){
		
		//CE 20200125: prova costruzione parola senza spazi in mezzo
				char []caratteri =	colonna.toCharArray();
				StringBuilder costruttoreParola= new StringBuilder();
					for(int a=0; a<caratteri.length; a++) {
						if(caratteri[a]!=(char)0) {
							costruttoreParola.append(caratteri[a]);
						}
					}
					String parola = costruttoreParola.toString();
	return parola;
	}
		
	

	public static void main (String [] args) throws Exception {
			
			File fileCrystal= new File("crystal/01/CDM_20200102131948.txt");
			System.out.println(fileCrystal.exists());
			List <String> contenutoCrystal = new ArrayList<String>();
			contenutoCrystal=readFileRows(fileCrystal);
			System.out.println(contenutoCrystal.toString());
			TestData datiDiCrystal=createListOfData(contenutoCrystal);
			datiDiCrystal.setIdComputer(fileCrystal.getPath().substring(9,10));
			System.out.println(datiDiCrystal.getType());
			System.out.println(datiDiCrystal.getDate());
			System.out.println(datiDiCrystal.getVersion());
			System.out.println(datiDiCrystal.getIdComputer());
			System.out.println(datiDiCrystal.getInterval());
			System.out.println(datiDiCrystal.getIterations());
			System.out.println(datiDiCrystal.getOs());
			
	}
}

