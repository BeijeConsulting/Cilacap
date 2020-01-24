package rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;



public class TestFileCSVmio {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
		File f = new File("C:/work/prova.txt");
		System.out.println(f.exists());
		System.out.println(f.getAbsolutePath());
		FileReader fileReader = new FileReader(f);
//		char c ;
//		while ((  c = (char) fileReader.read()) > -1)
//		{
//			System.out.println((char) c);
//		}
		
		
//		int numeroRiga=0;
//		int c = fileReader.read();
//		StringBuilder riga = new StringBuilder();
//		while ( c > -1)
//		{
//			char character = (char) c;
//			
//			if(character == '\n')
//			{
//				System.out.println(numeroRiga++ + " : " + riga.toString());
//				riga= new StringBuilder();
//			}
//			else
//				riga.append(character);
//			
//			//System.out.println((char) c);
//			c = fileReader.read();
//		}
		
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		while((row = reader.readLine()) != null)
		{
//			System.out.println(row);
//			String[] array = row.split(";");
//			System.out.println("nome : " + array[0]);
//			System.out.println("cognome : " + array[1]);
//			System.out.println("telefono : " + array[2]);
//			System.out.println("email : " + array[3]);
//			System.out.println('\n');


			StringTokenizer tokenizer = new StringTokenizer(row , ";");	
			System.out.println("nome : " + tokenizer.nextToken());
			System.out.println("cognome : " + tokenizer.nextToken());
			System.out.println("telefono : " + tokenizer.nextToken());
			System.out.println("email : " + tokenizer.nextToken());
			System.out.println('\n');
		}
		
	}

}
