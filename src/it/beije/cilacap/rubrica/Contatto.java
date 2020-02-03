package it.beije.cilacap.rubrica;
import it.beije.cilacap.rubrica.ParserXML;
import jdk.internal.org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.beije.cilacap.esercizi.TextFileManager;


public class Contatto {

	private int id;
	private String nome;
	private String cognome;
	private String telefono;
	private String email;


	public Contatto() {

	}
	public Contatto(String c, String n, String t, String e) {
		this.nome=n;
		this.cognome=c;
		this.telefono=t;
		this.email=e;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;

	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("cognome : ").append(cognome).append('\n');
		builder.append("nome : ").append(nome).append('\n');
		builder.append("telefono : ").append(telefono).append('\n');
		builder.append("email : ").append(email).append('\n');
		return builder.toString();
	}

	public List<Contatto> scheletroCsv() throws IOException {

		Scanner sc=new Scanner(System.in);
		String cognome="";
		String nome=""; 
		String telefono="";
		String email="";
		String scelta="";


		List<Contatto> contatti=new ArrayList<Contatto>();
		while(!scelta.equalsIgnoreCase("n")) {

			Contatto mioContatto=new Contatto();

			while(cognome.equals("")) {
				System.out.println("Inserisci il cognome: ");
				cognome=sc.nextLine();
				mioContatto.setCognome(cognome);
			}

			while(nome.equals("")) {
				System.out.println("Inserisci il nome: ");
				nome=sc.nextLine();
				mioContatto.setNome(nome);
			}

			while(telefono.equals("")) {
				System.out.println("Inserisci il telefono: ");
				telefono=sc.nextLine();
				mioContatto.setTelefono(telefono);
			}

			while(email.equals("")) {
				System.out.println("Inserisci l'email: ");
				email=sc.nextLine();
				mioContatto.setEmail(email);
			}
			contatti.add(mioContatto);



			System.out.println("Vuoi inserire un altro contatto? Se sì premi S, altrimenti N.");

			scelta=sc.nextLine();

			if(scelta.equalsIgnoreCase("s")) {
				cognome="";
				nome="";
				telefono="";
				email="";
			}
		}
		return contatti;
	}

	public void scrivisuFile(List<Contatto> contenuto,String separatore) throws IOException {

		TextFileManager tfm=new TextFileManager();

		StringBuilder sb=new StringBuilder();
		String intestazione=("COGNOME;NOME;TELEFONO;EMAIL");
		sb.append("COGNOME;NOME;TELEFONO;EMAIL");
		sb.append('\n');
		for(int i=0; i<contenuto.size(); i++) {
			sb.append(contenuto.get(i).getCognome());
			sb.append(separatore);

			sb.append(contenuto.get(i).getNome());
			sb.append(separatore);

			sb.append(contenuto.get(i).getTelefono());
			sb.append(separatore);

			sb.append(contenuto.get(i).getEmail());
		
			sb.append('\n');
		}
		tfm.writeFileContent(sb.toString(), "C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.csv");
	}

	public List<String> settoFile() throws IOException{
		Contatto c=new Contatto();
		TextFileManager tfx=new TextFileManager();
		List<String> file=tfx.readFileRows("C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.csv");
		ArrayList<Contatto> contatticaricati=new ArrayList <Contatto>();
		String separatore=(";");
		String[] righe;
		for(int i=1;i<file.size();i++) {
			Contatto nuovo=new Contatto();
			righe=file.get(i).split(separatore);
			for(int a=0;a<righe.length;a++) {
				switch (a) {
				case 0:
					nuovo.setCognome(righe[i]);
					break;
				case 1:
					nuovo.setNome(righe[i]);
					break;
				case 2:
					nuovo.setTelefono(righe[i]);
					break;
				case 3:
					nuovo.setEmail(righe[i]);
					break;
				default:
					break;
				}
			}
			contatticaricati.add(nuovo);
		}
		return file;
	}

	public  void fileXML() throws Exception{

		Contatto c=new Contatto();
		List<Contatto> lista= c.scheletroCsv();
		ParserXML.writeContattiInFile(lista,"C:\\Users\\Padawan05\\Desktop\\Esercizio\\rubrica.xml" );


	}

	public  List<Contatto> scriviXml()throws Exception{
		File mioFile=new File("C:\\Users\\Padawan05\\Desktop\\Esercizio\\Rubrica.csv");
		List<Contatto> lista=new ArrayList<Contatto>();
//		try {
		lista=Contatto.dammiContattoDaFile(mioFile );
//		}catch(SAXParseException e) {
//			System.out.println("a");
//		}
		return lista;
	}
	
	
	
	
	
public static List<Contatto> dammiContattoDaFile(File file) throws Exception {
		
		List<Contatto> listaContatti = new ArrayList<Contatto>();
		try {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the
        // Document class.
        Document document = builder.parse(file);
        Element element = document.getDocumentElement();       
        System.out.println(element.getTagName());
        
        //System.out.println(element.getChildNodes().getLength());
        NodeList contatti = element.getElementsByTagName("contatto");
        System.out.println("contatti : " + contatti.getLength());

        for (int i = 0; i < contatti.getLength(); i++) {
        	Element utente = (Element)contatti.item(i);
        	System.out.println(utente.getTagName() + " " + i);
        	System.out.println("\tanni = " + utente.getAttribute("anni"));
 
        	Element nome = (Element)utente.getElementsByTagName("nome").item(0);
        	Element cognome = (Element)utente.getElementsByTagName("cognome").item(0);
        	Element telefono = (Element)utente.getElementsByTagName("telefono").item(0);
        	Element email = (Element)utente.getElementsByTagName("email").item(0);
        	
        	Contatto contatto = new Contatto();
        	contatto.setNome(nome.getTextContent());
        	contatto.setCognome(cognome.getTextContent());
        	contatto.setTelefono(telefono.getTextContent());
        	contatto.setEmail(email.getTextContent());
        	
        	System.out.println("\tnome = " + contatto.getNome());
        	System.out.println("\tcognome = " + contatto.getCognome());
        	System.out.println("\ttelefono = " + contatto.getTelefono());
        	System.out.println("\temail = " + contatto.getEmail());
        	
        	listaContatti.add(contatto);
        }
		}catch(Exception e) {
			System.out.println("a");
		}
        
	
        
        return listaContatti;
	}
	

}

