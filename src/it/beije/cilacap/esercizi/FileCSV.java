package it.beije.cilacap.esercizi;
import java.io.*;
import java.util.StringTokenizer;

public class FileCSV {

	public static void main(String[] args) throws IOException{
		File f = new File("C:/temp/prova.txt");
		
		System.out.println("f exist "+ f.exists());
		System.out.println("f.getAbsolutePath(): "+ f.getAbsolutePath());
		
		FileReader fileReader = new FileReader(f); //reader del file
		int r=0;
//		int c=fileReader.read(); //legge un carattere alla volta
		StringBuilder riga =new StringBuilder();
//		while(c > -1) {
//			char character=((char)c);
//			
//			if(character=='\n' ) {
//				System.out.print(++r + " "+ riga.toString());
//				riga=new StringBuilder();
//			} else {
//				riga.append(character);
//			}
//			
//			c=fileReader.read();
//		}
		
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		
		while ((row=reader.readLine())!=null) {
//			System.out.println(row);
//			String [] array= row.split(";");
			StringTokenizer tokenizer= new StringTokenizer(row, ";");
			System.out.print("nome :" + tokenizer.nextToken());
			System.out.print(" cognome :" + tokenizer.nextToken());
			System.out.print(" telefono :" + tokenizer.nextToken());
			System.out.print(" email:" + tokenizer.nextToken());
			System.out.print('\n');
		}

	}

}
