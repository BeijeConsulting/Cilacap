

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.File;
import java.io.IOException;

public class myCSV {
	
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		//Scanner sc=new Scanner(System.in);
		//System.out.println("Inserisci il percorso desisderato: ");
		//			
		//	   
		//	   
		//	    String [] array=righe.split(";");
		//	    
		//        System.out.println("Nome: "+array[1]);
		//	    System.out.println("Cognome: "+array[0]);
		//	    System.out.println("Telefono: "+array[2]);                    
		//	    System.out.println("Email: "+array[3]);                       
		//	    System.out.println("Indirizzo: "+array[4]);                   
		//        System.out.println();                                       
		//		}


		File mioFile=new File("csv/rubrica3.csv");
		FileReader fileReader=new FileReader(mioFile);
		BufferedReader reader= new BufferedReader(fileReader); 

		String righe=reader.readLine();
		String[] ar=righe.split(";");
		int nome=0;
		int cognome=0;
		int email=0;
		int telefono=0;
		int indirizzo=0;

		for(int i=0; i<ar.length; i++) {
			
			String intestazione=ar[i].toUpperCase();
			switch (intestazione) {
			case "NOME":
				nome=i;
				break;
			case "COGNOME":
				cognome=i;
				break;
			case "EMAIL":
				email=i;
				break;
			case "TELEFONO":
				telefono=i;
				break;
			case "INDIRIZZO":
				indirizzo=i;
				break;
			default:
				break;

//			if(ar[i].equalsIgnoreCase("nome")) {
//				nome=i;
//			}else if (ar[i].equalsIgnoreCase("cognome")) {
//				cognome=i;
//			} else if (ar[i].equalsIgnoreCase("email")) {
//				email=i;
//			}else if(ar[i].equalsIgnoreCase("telefono")) {
//				telefono=i;
//			}else if(ar[i].equalsIgnoreCase("indirizzo")) {
//				indirizzo=i;
     		}
		}
		
		while((righe)!=null){
			righe=reader.readLine();
			if(righe !=null) {

			String[] array1=righe.split(";");
			String[] array2= new String[5];
			

			for(int a=0; a<array1.length; a++) {
				if(a==nome) {
					array2[a]=array1[a];
				}
				if(a==cognome) {
					array2[a]=array1[a];
				} if(a==email) {
					array2[a]=array1[a];
				} if(a==telefono) {
					array2[a]=array1[a];
				} if(a==indirizzo) {
					array2[a]=array1[a];
				}
			}
				System.out.println();
				System.out.println("Nome: "+array2[nome]);
				System.out.println("Cognome: "+array2[cognome]);
				System.out.println("Email: "+array2[email]);
				System.out.println("Telefono: "+array2[telefono]);
				System.out.println("Indirizzo: "+array2[indirizzo]);
			
				

			}
		}
	}
}




		
		
		
		
		
			
			
	    
		

	
		
		
		
		
		


