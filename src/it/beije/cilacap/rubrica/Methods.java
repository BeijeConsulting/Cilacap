package it.beije.cilacap.rubrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.sun.xml.internal.org.jvnet.fastinfoset.ExternalVocabulary;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Methods {
	Scanner input = new Scanner(System.in);
	
		public static List<String[]> getFileCsvContent(String csvSplitBy, String filepath) throws IOException{
			
			//Mi ritorna una lista di array contenenti le varie righe contatto del CSV
			
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
	        List<String[]> list = new ArrayList<>();
	        String line = "";
	        while((line = reader.readLine()) != null){
	            String[] array = line.split(csvSplitBy);
	            list.add(array);
	        }
	        reader.close();
	        return list;
	        }
	

		public static void writeToCsvFile(List<String[]> thingsToWrite, String csvSplitBy, String fileName){
		//Riceve una lista di array da scrivere nel CSV.
	    try (FileWriter writer = new FileWriter(fileName)){
	        for (String[] strings : thingsToWrite) {
	            for (int i = 0; i < strings.length; i++) {
	                writer.append(strings[i]);
	                if(i < (strings.length-1))
	                    writer.append(csvSplitBy);
	            }
	            writer.append(System.lineSeparator());
	        }
	        writer.flush();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	    public List<String[]> setContatto(String[]intestazioneFile, List<String[]> lc){
	    // Riceve la stringa di come'è intestato il CSV in cui bisogna aggiungere il contatto e la lista dei contatti già presenti nel CSV a cui bisogna accodare i nuovi contatti.

	    	String[]contatto= new String[5];
	    	boolean again=true;
	    	while(again) {
	    		
	    		for (int i=0;i<intestazioneFile.length;i++) {
	    	
	    		
	    			if(intestazioneFile[i].equalsIgnoreCase("nome")) {
	    			System.out.println("Inserisci nome del nuovo contatto:");
	    			contatto[i]=input.nextLine();
	    			}
	    			else if(intestazioneFile[i].equalsIgnoreCase("cognome")) {
	    				System.out.println("Inserisci cognome del nuovo contatto:");
	    				contatto[i]=input.nextLine();
	    			}
	    			else if(intestazioneFile[i].equalsIgnoreCase("telefono")) {
	    				System.out.println("Inserisci telefono del nuovo contatto:");
	    				contatto[i]=input.nextLine();
	    			}
	    			else if(intestazioneFile[i].equalsIgnoreCase("indirizzo")) {
	    				System.out.println("Inserisci indirizzo del nuovo contatto:");
	    				contatto[i]=input.nextLine();
	    			}
	    			else if(intestazioneFile[i].equalsIgnoreCase("email")) {
	    				System.out.println("Inserisci email del nuovo contatto:");
	    				contatto[i]=input.nextLine();
	    			}
	    		
	    		}
	    		lc.add(contatto);
	    		
	    		System.out.println("Inserire un altro contatto? S/N");
	    		if(input.next().equalsIgnoreCase("n"))
	    			again=false;
	    	}
	    	input.close();
	    	return lc;
	    	}
	    
	    public static List<Contatto> getContattiFromFileXml(File file) throws Exception {
	    	//Di Ivo
			List<Contatto> listaContatti = new ArrayList<Contatto>();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();

	        // Load the input XML document, parse it and return an instance of the
	        // Document class.
	        Document document = builder.parse(file);
	        Element element = document.getDocumentElement();       
//	        System.out.println(element.getTagName());
	        
//	        System.out.println(element.getChildNodes().getLength());
	        NodeList contatti = element.getElementsByTagName("contatto");
//	        System.out.println("contatti : " + contatti.getLength());

	        for (int i = 0; i < contatti.getLength(); i++) {
	        	Element utente = (Element)contatti.item(i);
//	        	System.out.println(utente.getTagName() + " " + i);
//	        	System.out.println("\tanni = " + utente.getAttribute("anni"));
	 
	        	Element nome = (Element)utente.getElementsByTagName("nome").item(0);
	        	Element cognome = (Element)utente.getElementsByTagName("cognome").item(0);
	        	Element telefono = (Element)utente.getElementsByTagName("telefono").item(0);
	        	Element email = (Element)utente.getElementsByTagName("email").item(0);
	       	
	        	Contatto contatto = new Contatto();
	        	contatto.setNome(nome.getTextContent());
	       	    contatto.setCognome(cognome.getTextContent());
	        	contatto.setTelefono(telefono.getTextContent());
	        	contatto.setEmail(email.getTextContent());
	        	
//	        	System.out.println("\tnome = " + contatto.getNome());
//	        	System.out.println("\tcognome = " + contatto.getCognome());
//	        	System.out.println("\ttelefono = " + contatto.getTelefono());
//	        	System.out.println("\temail = " + contatto.getEmail());
//	        	
	        	listaContatti.add(contatto);
	        }
	        
	        return listaContatti;
		}
	 
        public static void writeContattiInFileXml(List<Contatto> contatti, String pathfile) throws Exception  {
	    	//Di Ivo
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();

	        Document document = builder.newDocument();
	        Element docElement = document.createElement("rubrica");
	        document.appendChild(docElement);
	        
	        for (Contatto c : contatti) {
	        	Element contatto = document.createElement("contatto");
	        	Element nome = document.createElement("nome");
	        	Element cognome = document.createElement("cognome");
	        	Element telefono = document.createElement("telefono");
	        	Element email = document.createElement("email");
	        	
	        	nome.setTextContent(c.getNome());
	        	cognome.setTextContent(c.getCognome());
	        	telefono.setTextContent(c.getTelefono());
	        	email.setTextContent(c.getEmail());
	        	
	        	contatto.appendChild(nome);
	        	contatto.appendChild(cognome);
	        	contatto.appendChild(telefono);
	        	contatto.appendChild(email);

	        	docElement.appendChild(contatto);
	        }

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(pathfile));

			// Output to console for testing
			//StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");
		}
	  
        public static List<Contatto> getContattiFromFileXml(String pathfile) throws Exception {
	    	//Di Ivo
			File file = new File(pathfile);
			
			return getContattiFromFileXml(file);
		}

		public static List<String[]> getCsvListFromXmlFile(List<Contatto> xmlList){
			List<String[]> csvList = new ArrayList<String[]>();
			String[]array= new String[4];
			for(int i=0;i<xmlList.size();i++) {
					array[0]=xmlList.get(i).getNome();
					array[1]=xmlList.get(i).getCognome();
					array[2]=xmlList.get(i).getTelefono();
					array[3]=xmlList.get(i).getEmail();
					csvList.add(i,array);		
			}
			return csvList;
			
			}
		
        public static List<Contatto> getXmlListFromCsvFile(String csvSplitBy, String filepath) throws IOException{
        List<String[]> ls= new ArrayList<>();	
        List<Contatto> lc= new ArrayList<Contatto>();
        ls= getFileCsvContent(csvSplitBy,filepath);
        String[]intestazione= new String[5];
        String[]array=new String[5];
        
        //controllo l'ordine dell'intestazione del csv così che se i campi fossero in un diverso ordine non imposto nel campo cognome della lista il nome magari.
       
        intestazione=ls.get(0);
       
        //Scorro la lista di array contenenti ognuno un contatto, parto dall'indice 1 siccome l'indice 0 contiene "nome cognome telefono email" 
       
        for(int i=1; i<ls.size();i++) {
        	array=ls.get(i);
        	//scorro l'array  che ho estratto dalla lista che corrisponde ad un cotatto e controllo il campo in base all'intestazione ed aggiungo alla lista contatto.
        	for(int j=0;j<array.length;j++) {
        	if(intestazione[j].equalsIgnoreCase("nome")) {
        		lc.get(i-1).setNome(array[j]);
        	}
        	else if(intestazione[j].equalsIgnoreCase("cognome")) {
        		lc.get(i-1).setCognome(array[j]);
        	}
        	else if(intestazione[j].equalsIgnoreCase("telefono")){
        		lc.get(i-1).setTelefono(array[j]);
        	}
        	else if(intestazione[j].equalsIgnoreCase("email")){
        		lc.get(i-1).setEmail(array[j]);
        	}
        		
        	}
        	}
        //A questo punto dovrei avere la mia lista contatto con tutti i contatti della lista del csv.
        return lc;
        }
}



//	    prova di una possibile trasforazione da xml a csv non andata bene
//	    public Result getCSVToXML(String path) throws TransformerException, Exception {
//	    	File xmlSource= new File(path);
//	    	File stylesheet= new File("C:\\Users\\Padawan07\\git\\Cilacap\\xml\\rubricastyle.xsl");
//	    	stylesheet.createNewFile();
//			DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = factory.newDocumentBuilder();
//		    Document document = builder.parse(xmlSource);
//		    StreamSource stylesource = new StreamSource(stylesheet);
//		    Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
//		    Source source = new DOMSource(document);
//		    Result outputTarget = new StreamResult(new File("C:\\Users\\Padawan07\\git\\Cilacap\\xml\\rubrica_copia.csv"));
//		    transformer.transform(source, outputTarget);
//		    return outputTarget;
//	    }
	     

