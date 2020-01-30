package it.beije.cilacap.crystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//CE 20200130: creazione di una classe esterna per gestire il metodo di read Crystal, migliore comprensione del codice
public class GestoreReadCrystal {


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
	static boolean campoRead=true;

	public static TestData  createListOfData(List <String> contenuto) {
		TestData info= new TestData();
		
		//CE 20200125: creazione array con il contenuto del file, separati dal \n
		//CE 20200130: metodo iniziale. Provare a creare un'alternativa con createArrayWord
		
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
				

				
				System.out.println(parola);
					if(parola.equalsIgnoreCase("CrystalDiskMark")) {
						info.setVersion(createWord(riga[++j].trim())+ " "+ createWord(riga[++j].trim()));
					}
					if(parola.equalsIgnoreCase("[Read]")) {
					takeData(info, dati);
					break CICLO;
					}
					

			}
		}
		return info;
	}

	//CE 20200127: metodo per prendere i dati della sezione read
	//CE 20200130. metodo per prendere i dati nella sezione read e write tramite ricorsione
	public static void takeData(TestData info, String[] dati) {
		List<TestRow> listaDati = new ArrayList<TestRow> ();
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
//						i++;
////						takeWriteFieldData(info, dati);
//						campoRead=false;
//						takeData(info,dati);
						break CICLO_INIZIALE;
					}
					if(colonna.equalsIgnoreCase("Profile:")) {
						System.out.println("è uguale");
						takeProfileFieldData(info, dati);
						break CICLO_INIZIALE;
					} 
					
					switch(colonna) {
					case "Sequential":
										if(campoRead)	
										raccoltaDatiRead.setType(createWord(riga[j])+ "_"+createWord(riga[++j]).charAt(0)+createWord(riga[j]).substring(1));
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
										
					case "Random":
										raccoltaDatiRead.setType(createWord(riga[j])+ "_"+createWord(riga[++j]).charAt(0)+" "+ createWord(riga[j]).substring(1));
										System.out.println(raccoltaDatiRead.getType());
										break;
					}
				
				}
				if(campoRead) {
				listaDati.add(raccoltaDatiRead);
				}else {listaDati.add(raccoltaDatiRead);}
				
					
			}
		
		if(campoRead) {
			System.out.println("inserimento dati lista read");
			info.setRead(listaDati);
			i++;
//			takeWriteFieldData(info, dati);
			campoRead=false;
			takeData(info,dati);
			} else 	{
				System.out.println("inserimento dati lista write");
				info.setWrite(listaDati);
				System.out.println("Finito");
			}
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
	
	
	//CE 20200127: metodo per eliminare gli spazi null e creare la parola
	public static String createWord(String colonna){
		
		//CE 20200125: prova costruzione parola senza spazi in mezzo
		//CE 20200130: costruzione parola senza spazi funzionante
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

}
