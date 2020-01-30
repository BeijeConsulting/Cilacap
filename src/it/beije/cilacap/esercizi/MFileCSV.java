package it.beije.cilacap.esercizi;
import java.io.*;
import java.util.StringTokenizer;

public class MFileCSV {

	public static void main(String[] args) throws IOException {
		
		File f=new File("C:\\work\\pippo.txt");
		
		File f2=new File("C:/work/pippo.txt");        //path Linux compatibile anche con Windows
		
		System.out.println(f.exists());
		System.out.println(f.getAbsolutePath());

		
		FileReader fileReader=new FileReader(f);     //Oggetto creato per mettere a disposizione dei metodi per leggere il file
	
//	    int c;
//		while((c=fileReader.read()) > -1) {       Leggo carattere per carattere
//			System.out.println((char)c);
		
//		int c=fileReader.read();                    è più comodo da fare
//		int numeroriga=0;
//		StringBuilder riga=new StringBuilder();
//		while(c>-1) {
//			char character=(char)c;
//			
//			if(character == '\n') {
//				System.out.println(numeroriga ++ +" : "+riga.toString());
//				riga=new StringBuilder();
//			}else {
//				riga.append(character);
//			}
//			System.out.println((char)c);
//			c=fileReader.read();
//		}
		
		BufferedReader reader= new BufferedReader(fileReader);           //Oggetto che si istanzia su un altro oggetto
		String row;
		while((row=reader.readLine()) != null) {
			System.out.println(row);
//			String [] array=row.split(";");
//			System.out.println("Nome: "+array[0]);
//			System.out.println("Cognome: "+array[1]);
//			System.out.println("Telefono: "+array[2]);
//			System.out.println("Email: "+array[3]);
			
			StringTokenizer tokenizer= new StringTokenizer(row,";");
			System.out.println("Nome: "+tokenizer.nextToken());
			System.out.println("Cognome: "+tokenizer.nextToken());
			System.out.println("Telefono: "+tokenizer.nextToken());
			System.out.println("Email: "+tokenizer.nextToken());
			System.out.println('\n');
			
		}
	}
}
