package rubrica;

import static rubrica.Metodi.*;
import rubrica.DBManager;
import static rubrica.DBManager.*;
import static rubrica.DBtools.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static rubrica.ParserXML.*;
import rubrica.DBtools;
public class MioText {
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		boolean s = true;
		int controllo=0;
		Scanner scanner = new Scanner(System.in);
		File f = new File("c:/work/prova.csv");
		File fdbcsv = new File("c:/work/dbtocsv.csv");
		File fxml = new File("c:/work/prova.xml");
		File fcsv = new File("c:/work/provaToCsv.csv");
		List<Contatto> listaContatti= new ArrayList<>();
		List<Contatto> DBContatti= new ArrayList<>();
		StringBuilder stringaB = new StringBuilder();
		System.out.println("f.exists() ? " + f.exists());
		Contatto contatto=new Contatto();
		
		while(s)
		{
			
			System.out.println("vuoi inserire un contatto? Si/No ");
			if(scanner.hasNext())
			{
				if(scanner.nextLine().equalsIgnoreCase("Si"))
				{
					if(f.exists() && controllo==0)
					{
						
						stringaB.append(readFileContent(f).toString());
						contatto=impostaContatto();
						stringaB.append(toCSV(contatto));
						writeFileContent(stringaB.toString(), f);
						controllo++;
						listaContatti.add(contatto);
					}
					else
					{
						
						contatto=impostaContatto();
						writeFileContent(stringaB.append(toCSV(contatto)).toString(),f);
						listaContatti.add(contatto);
					}
				}
				else
					s=false;
			}
			
			DBContatti.addAll(listaContatti);
			
		}
		
		toXML(f);
		xmlToCSV(fxml,fcsv);
		System.out.println("caricare csv nel database? ");
		if(scanner.nextLine().equalsIgnoreCase("si"))
		{
			try {
				int i=0;
				for(i=0;i<generaLista(f).size();i++)
				{
					insertContatto(generaLista(f).get(i));
				}
			} catch (Exception e) {
				e.printStackTrace();
			
			}
		}
		
			System.out.println("caricare xml nel database? ");
			if(scanner.nextLine().equalsIgnoreCase("si"))
			{
				try {
					int i=0;
					for(i=0;i<getContattiFromFile(fxml).size();i++)
					{
						insertContatto(getContattiFromFile(fxml).get(i));
					}
				} catch (Exception e) {
					e.printStackTrace();
				
				}
			}
		
		System.out.println("esportare csv dal database? ");
		if(scanner.nextLine().equalsIgnoreCase("si"))
		{
			try
			{
				
				writeFileContent(generaLista(leggiContatti()), fdbcsv);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
			System.out.println("esportare xml dal database? ");
			if(scanner.nextLine().equalsIgnoreCase("si"))
			{
				writeContattiInFile(leggiContatti(), "c:/work/dbtoxml.xml");
				
			}
	}
}

	
