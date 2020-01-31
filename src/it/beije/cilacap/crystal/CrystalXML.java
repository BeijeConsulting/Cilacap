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

public class CrystalXML extends GestoreReadCrystal {
	
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
		createXML(datiDiCrystal);
		
	}
	
	public static void createXML(TestData datiDiCrystal) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.newDocument();
        Element crystal = document.createElement("CrystalDiskMark");
        document.appendChild(crystal);
        
        Element test=document.createElement("test");
        test.setAttribute("id_computer", "01");
        test.setAttribute("version", datiDiCrystal.getVersion());
        test.setAttribute("os", datiDiCrystal.getOs());
        test.setAttribute("type", datiDiCrystal.getType());
        test.setAttribute("iterations",Integer.toString( datiDiCrystal.getIterations()));
        test.setAttribute("interval", datiDiCrystal.getInterval());
        test.setAttribute("date", datiDiCrystal.getDate());
        crystal.appendChild(test);
        
        Element read= document.createElement("read");
        test.appendChild(read);
        
        TestRow[] datiRead=new TestRow[datiDiCrystal.getRead().size()];
    	datiRead= datiDiCrystal.getRead().toArray(datiRead);
    	
    	Element write= document.createElement("read");
        test.appendChild(write);
    	
        TestRow[] datiWrite=new TestRow[datiDiCrystal.getWrite().size()];
    	datiWrite= datiDiCrystal.getWrite().toArray(datiRead);
    	
        for (int i=0; i< datiRead.length-1; i++) {
        	if(datiRead[i].getType().equalsIgnoreCase("Sequential_1MIB")) {
        		Element sequential= document.createElement("Sequential_1MiB");
        		sequential.setAttribute("q",Integer.toString(datiRead[i].getQ()));
        		sequential.setAttribute("t", Integer.toString(datiRead[i].getT()));
        		Element mbs=document.createElement("MBs");
        		Element iops=document.createElement("IOPS");
        		Element us= document.createElement("us");
        		mbs.setTextContent(	Double.toString(datiRead[i].getMbs()));
        		iops.setTextContent(	Double.toString(datiRead[i].getIops()));
        		us.setTextContent(	Double.toString(datiRead[i].getUs()));
        		
        		sequential.appendChild(mbs);
        		sequential.appendChild(iops);
        		sequential.appendChild(us);
        		
        		read.appendChild(sequential);
        	}
        		
        }
        for (int i=0; i< datiWrite.length-1; i++) {
        	if(datiWrite[i].getType().equalsIgnoreCase("Sequential_1MIB")) {
        		Element sequential= document.createElement("Sequential_1MiB");
        		sequential.setAttribute("q",Integer.toString(datiWrite[i].getQ()));
        		sequential.setAttribute("t", Integer.toString(datiWrite[i].getT()));
        		Element mbs=document.createElement("MBs");
        		Element iops=document.createElement("IOPS");
        		Element us= document.createElement("us");
        		mbs.setTextContent(	Double.toString(datiWrite[i].getMbs()));
        		iops.setTextContent(	Double.toString(datiWrite[i].getIops()));
        		us.setTextContent(	Double.toString(datiWrite[i].getUs()));
        		
        		sequential.appendChild(mbs);
        		sequential.appendChild(iops);
        		sequential.appendChild(us);
        		
        		write.appendChild(sequential);
        	}
        		
        }
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File("crystal/xmltest.xml"));

		// Output to console for testing
		//StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");
	}
	
	
//	
//	public static List<String> readFileRows(String filePath) throws IOException {
//		File file = new File(filePath);
//		
//		return readFileRows(file);
//	}
//
//	public static List<String> readFileRows(File file) throws IOException {
//		List<String> rows = new ArrayList<String>();
//		
//		FileReader fileReader = new FileReader(file);
//		BufferedReader reader = new BufferedReader(fileReader);
//		String row;
//		while ((row = reader.readLine()) != null) {
//			System.out.println(row);
//			rows.add(row);
//		}
//		
//		System.out.println("rows size : " + rows.size());
//		return rows;
//	}
//	
//	
//	
//	
//	
//	static int i;
//	static boolean campoRead=true;
//
//	public static TestData  createListOfData(List <String> contenuto) {
//		TestData info= new TestData();
//		//CE 20200125: creazione array con il contenuto del file, separati dal \n
//		//CE 20200130: metodo iniziale. Provare a creare un'alternativa con createArrayWord
//		String[] dati= new String[contenuto.size()];
//		dati=contenuto.toArray(dati);
//
//		for(; i<dati.length;i++) {
//			System.out.println("nel for di createdListOfData");
//		//CE 20200125: creazione array con le parole di una riga.
//			String [] riga= dati[i].split(" ");
//			
//		//CE 20200125: inizio analisi della riga
//			CICLO: for(int j=0; j<riga.length; j++) {
////				System.out.println("nel for di createdList colonna");
////				System.out.println(riga[j]);
//				
//				String colonna= riga[j].trim();
//				
////				System.out.println(colonna);
//				
//				String parola=createWord(colonna);	
//				
//////				System.out.println(parola.equalsIgnoreCase("Profile:"));
////				if(parola.equalsIgnoreCase("Profile:")) {
////					takeProfileFieldData(info, dati);
////				}else
//				
//				System.out.println(parola);
//					if(parola.equalsIgnoreCase("CrystalDiskMark")) {
//						info.setVersion(createWord(riga[++j].trim())+ " "+ createWord(riga[++j].trim()));
//					}
//					if(parola.equalsIgnoreCase("[Read]")) {
//					takeData(info, dati);
//					break CICLO;
//					}
//					
////				}else if(parola.equalsIgnoreCase("[Write]:")) {
////					takeProfileFieldData(info, dati);
////				}
////				switch(parola) {
////				
////				case "Profile:": 
////					takeProfileFieldData(info, dati);
////					break;
////				case "[Read]":
////					takeData(info, dati);
////					break;
////				case "[Write]":
////					takeWriteFieldData(info, dati);
////					break;	
////				default:break;
////				}
//			}
//		}
//		return info;
//	}
//
//	//CE 20200127: metodo per prendere i dati della sezione read
//	//CE 20200130. metodo per prendere i dati nella sezione read e write tramite ricorsione
//	public static void takeData(TestData info, String[] dati) {
//		List<TestRow> listaDati = new ArrayList<TestRow> ();
//		System.out.println("dentro metodo takereadfielddata");
//		
//		CICLO_INIZIALE: for(; i<dati.length; i++) {
//			String [] riga= dati[i].split(" ");
//			List <String> listRiga= new ArrayList<String>();
//			
//			for(int k=0; k<riga.length;k++) {
//				String parola= createWord(riga[k]);
//				if(parola.length()!=0)
//					listRiga.add(parola);
//			}
//			riga=listRiga.toArray(new String[0]);
//			TestRow raccoltaDatiRead= new TestRow();
//			for(int j =0; j<riga.length; j++) {
//				
////            		String parola= createWord(riga[j]);
////					System.out.println(parola.length());
//					
//				
////					System.out.println(riga[j]);
//					String colonna= riga[j].trim();
//					
//					if(colonna.equalsIgnoreCase("[Write]")) {
////						i++;
//////						takeWriteFieldData(info, dati);
////						campoRead=false;
////						takeData(info,dati);
//						break CICLO_INIZIALE;
//					}
//					if(colonna.equalsIgnoreCase("Profile:")) {
//						System.out.println("è uguale");
//						takeProfileFieldData(info, dati);
//						break CICLO_INIZIALE;
//					} 
//					
//					switch(colonna) {
//					case "Sequential":
//										if(campoRead)	
//										raccoltaDatiRead.setType(createWord(riga[j])+ "_"+createWord(riga[++j]).charAt(0)+" "+ createWord(riga[j]).substring(1));
//										System.out.println(raccoltaDatiRead.getType());
//										break;
//					case "(Q=": 		
//										raccoltaDatiRead.setQ(createWord(riga[++j]).charAt(0)-'0');
//										System.out.println(raccoltaDatiRead.getQ());
//										break;
//										
//					case "T=":       
//										//	System.out.println(createWord(riga[j+5]));
//										raccoltaDatiRead.setT(riga[++j].charAt(0)-'0');
//										raccoltaDatiRead.setMbs(Double.parseDouble(riga[++j]));
//										System.out.println(raccoltaDatiRead.getT());
//										System.out.println(raccoltaDatiRead.getMbs());
//										break;
//					case"[": 			
//										raccoltaDatiRead.setIops(Double.parseDouble(riga[++j]));
//										System.out.println(raccoltaDatiRead.getIops());
//										break;
//					case"<":
//										raccoltaDatiRead.setUs(Double.parseDouble(riga[++j]));
//										System.out.println(raccoltaDatiRead.getUs());
//										break;
//										
//					case "Random":
//										raccoltaDatiRead.setType(createWord(riga[j])+ "_"+createWord(riga[++j]).charAt(0)+" "+ createWord(riga[j]).substring(1));
//										System.out.println(raccoltaDatiRead.getType());
//										break;
//					}
//				
//				}
//				if(campoRead) {
//				listaDati.add(raccoltaDatiRead);
//				}else {listaDati.add(raccoltaDatiRead);}
//				
//					
//			}
//		
//		if(campoRead) {
//			System.out.println("inserimento dati lista read");
//			info.setRead(listaDati);
//			i++;
////			takeWriteFieldData(info, dati);
//			campoRead=false;
//			takeData(info,dati);
//			} else 	{
//				System.out.println("inserimento dati lista write");
//				info.setWrite(listaDati);
//				System.out.println("Finito");
//			}
//	}
//
//	
//	//CE 20200124: metodo per estrapolare i dati nel campo profile default
//	public static void takeProfileFieldData(TestData info, String [] dati) {
//		System.out.println("dentro takeProfileFieldData");
//		for (;i<dati.length;i++) {
//			String [] riga= dati[i].split(" ");
//			
////			System.out.println("for i");
//			
//			for(int col=0;col<riga.length;col++) {
//				
////				System.out.println("for j");
//				
//				String parola= createWord(riga[col]);
////				System.out.println(parola);
//				
//				String colonna= riga[col].trim();
//				
//				switch(parola) {
//					case "Test:": 
//									info.setType(createWord(riga[col+1])+" " +createWord(riga[col+2]));
//									
////									System.out.println(info.getType());
//									
//									info.setIterations(createWord(riga[col+3]).charAt(2)- '0');
//									
////									System.out.println(info.getIterations());
//									break;
//					case "[Interval:":  
//						                info.setInterval(createWord(riga[col+1])+ " "+ createWord(riga[col+2]).substring(0,3) );
//						                
////										System.out.println(info.getInterval());
//										break;
//					case "Date:": 
//						          info.setDate(createWord(riga[col+1])+ " "+ createWord(riga[col+2])); 
//						          
////								  System.out.println(info.getDate());break;
//					case "OS:": 
//						        info.setOs(createWord(riga[col+1])+ " " + createWord(riga[col+2]));
//						        
////								System.out.println(info.getDate());
//								break;
//				}
//			}
//		}
//		
//	}
//	
//	
//	//CE 20200127: metodo per eliminare gli spazi null e creare la parola
//	public static String createWord(String colonna){
//		
//		//CE 20200125: prova costruzione parola senza spazi in mezzo
//				char []caratteri =	colonna.toCharArray();
//				StringBuilder costruttoreParola= new StringBuilder();
//					for(int a=0; a<caratteri.length; a++) {
//						if(caratteri[a]!=(char)0) {
//							costruttoreParola.append(caratteri[a]);
//						}
//					}
//					String parola = costruttoreParola.toString();
//	return parola;
//	}
	
	
}


//CE 20200130: commentato il metodo, creata alternativa con ricorsione
//CE 20200128: metodo per leggere i dati delle rige in write 	
//public static void takeWriteFieldData(TestData info, String[] data) {
//		
//List<TestRow> listaDati = new ArrayList<TestRow> ();
//		
//		System.out.println("dentro metodo takeWritefielddata");
//		
//		CICLO_INIZIALE: for(; i<data.length; i++) {
//			String [] riga= data[i].split(" ");
//			List <String> listRiga= new ArrayList<String>();
//			
//			for(int k=0; k<riga.length;k++) {
//				String parola= createWord(riga[k]);
//				if(parola.length()!=0)
//					listRiga.add(parola);
//			}
//			riga=listRiga.toArray(new String[0]);
//			TestRow raccoltaDatiWrite= new TestRow();
//			for(int j =0; j<riga.length; j++) {
//				
////          		String parola= createWord(riga[j]);
////					System.out.println(parola.length());
//					
//					
//				
////					System.out.println(riga[j]);
//					String colonna= riga[j].trim();
//					
//					if(colonna.equalsIgnoreCase("Profile:")) {
//						System.out.println("è uguale");
//						takeProfileFieldData(info, data);
//						break CICLO_INIZIALE;
//					}
//					
//					
//					switch(colonna) {
//					case "Sequential":
//										raccoltaDatiWrite.setType(createWord(riga[++j]).charAt(0)+" "+ createWord(riga[j]).substring(1));
//										System.out.println(raccoltaDatiWrite.getType());
//										break;
//					case "(Q=": 		
//										raccoltaDatiWrite.setQ(createWord(riga[++j]).charAt(0)-'0');
//										System.out.println(raccoltaDatiWrite.getQ());
//										break;
//										
//					case "T=":       
//										//	System.out.println(createWord(riga[j+5]));
//										raccoltaDatiWrite.setT(riga[++j].charAt(0)-'0');
//										raccoltaDatiWrite.setMbs(Double.parseDouble(riga[++j]));
//										System.out.println(raccoltaDatiWrite.getT());
//										System.out.println(raccoltaDatiWrite.getMbs());
//										break;
//					case"[": 			
//										raccoltaDatiWrite.setIops(Double.parseDouble(riga[++j]));
//										System.out.println(raccoltaDatiWrite.getIops());
//										break;
//					case"<":
//										raccoltaDatiWrite.setUs(Double.parseDouble(riga[++j]));
//										System.out.println(raccoltaDatiWrite.getUs());
//										break;
//					case "Random":
//						raccoltaDatiWrite.setType(createWord(riga[++j]).charAt(0)+" "+ createWord(riga[j]).substring(1));
//						System.out.println(raccoltaDatiWrite.getType());
//						break;
//	
//					}
//				
//				}
//				listaDati.add(raccoltaDatiWrite);
//			}
//		info.setWrite(listaDati);
//		System.out.println("Finito");
//		
//			
//		}

