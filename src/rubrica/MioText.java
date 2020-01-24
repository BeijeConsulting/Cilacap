package rubrica;

import static rubrica.Metodi.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MioText {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		boolean s = true;
		int controllo=0;
		Scanner scanner = new Scanner(System.in);
		File f = new File("c:/work/prova.csv");
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
					}
					else
					{
						contatto=impostaContatto();
					
						writeFileContent(stringaB.append(toCSV(contatto)).toString(),f);
					}
				}
				else
					s=false;
			}
			
		}
		
	}
}

	
