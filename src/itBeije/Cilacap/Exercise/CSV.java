package itBeije.Cilacap.Exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CSV {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("C:/work/rubrica4.csv");
		System.out.println(f.exists());
		System.out.println(f.getAbsolutePath());
		FileReader fileReader = new FileReader(f);
		BufferedReader reader = new BufferedReader(fileReader);
		String row="";
		
		int i;
		int contatoreSwitch=0;
		row= reader.readLine();
		String[] array = row.split(";");
		int nome=0,cognome=0,indirizzo=0,telefono=0,email=0;
//		for(i=0;(row = reader.readLine()) != null;i++)
//		{
//			
//			System.out.println(row);
//		}
		
		for(contatoreSwitch=0;contatoreSwitch<array.length;contatoreSwitch++)
		{
			switch(array[contatoreSwitch]) 
			{
			case "NOME":{
							nome=contatoreSwitch;
							break;
						}
			case "COGNOME":
						{
							cognome=contatoreSwitch;
							break;
						}
			case "TELEFONO":{
								telefono=contatoreSwitch;
								break;			
							}
			case "INDIRIZZO":{
								indirizzo=contatoreSwitch;
								break;
							 }
			case "EMAIL":{
							email=contatoreSwitch;
							break;
						 }
			}
		}
		
		i=0;
		while((row = reader.readLine()) != null)
		{
			
			System.out.println(row);
			String[] array1 = row.split(";");
			//List<String> list = Arrays.asList(array1);
			if((i+nome > array1.length-1) || (array1[i+nome].equals(null)))
			{
				System.out.println("nome : ");
			}
			else
				System.out.println("nome : " + array1[i+nome]);
			if((i+cognome > array1.length-1) || (array1[i+cognome].equals(null)))
			{
				System.out.println("cognome : ");
			}
			else
				System.out.println("cognome : " + array1[i+cognome]);
			if( (i+telefono > array1.length-1) || (array1[i+telefono].equals(null)))
			{
				System.out.println("telefono : ");
			}
			else
				System.out.println("telefono : " + array1[i+telefono]);
			if((i+email > array1.length-1) || (array1[i+email].equals(null)))
			{
				System.out.println("email : ");
			}
			else
				System.out.println("email : " + array1[i+email]);
			if((i+indirizzo > array1.length-1) || (array1[i+indirizzo].equals(null)))
			{
				System.out.println("indirizzo : ");
			}
			else
				System.out.println("indirizzo : " + array1[i+indirizzo]);
			
			System.out.println('\n');
	
			
		}

	}

	
//	BufferedReader reader = new BufferedReader(fileReader);
//	String row;
//	System.out.println(row);
//	String[] array = row.split(";");
//	System.out.println("nome : " + array[0]);
//	System.out.println("cognome : " + array[1]);
//	System.out.println("telefono : " + array[2]);
//	System.out.println("email : " + array[3]);
//	System.out.println('\n');
}
