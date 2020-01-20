package itBeije.Cilacap.Exercise;

import java.util.Scanner;

public class Carte {

	
	int [] valoreCarte= {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Carte carta1 = new Carte();
		Carte carta2 = new Carte();
		System.out.println("Inserisci la prima carta ");
		Scanner scanner1 = new Scanner(System.in);
		String stringa= scanner1.nextLine();
		int puntatore=carta1.impostaValore(stringa);
		System.out.println("Inserisci la seconda carta ");
		Scanner scanner2 = new Scanner(System.in);
		String stringa2= scanner2.nextLine();
		int puntatore2= carta2.impostaValore(stringa2 );
		compare(carta1,carta2,puntatore,puntatore2);
	}
	
	public int impostaValore(String stringa)
	{
		Integer intero=new Integer(0);
		
		
			if(stringa.equalsIgnoreCase("J"))
			{
				return 11;
			}
			else
				if(stringa.equalsIgnoreCase("Q"))
					return 12;
				else
					if(stringa.equalsIgnoreCase("K"))
					{
						return 13;
					}
					else
					{
						return Integer.parseInt(stringa);
					}
	}

	public static  void compare(Carte carta1 , Carte carta2 , int puntatore , int puntatore2)
	{
		if(((carta1.valoreCarte[puntatore-1]==1 && carta2.valoreCarte[puntatore2-1]== 13)) || ((carta1.valoreCarte[puntatore-1]==13 && carta2.valoreCarte[puntatore2-1]== 1)))
		{
			System.out.println("l'asso vince sul RE");
		}
			
		else 
		{
			
		
			if(carta1.valoreCarte[puntatore-1]>carta2.valoreCarte[puntatore2-1])
			{
				System.out.println("La prima carta " + carta1.valoreCarte[puntatore-1] + " è più alta della seconda carta " + carta2.valoreCarte[puntatore2-1]);
				
			}
			else
			{
				if(carta1.valoreCarte[puntatore-1]<carta2.valoreCarte[puntatore2-1])
					{
					System.out.println("La prima carta " + carta1.valoreCarte[puntatore-1] + " è più bassa della seconda carta " + carta2.valoreCarte[puntatore2-1] );
					
					}
				else
					System.out.println("hanno lo stesso valore");
				
			}
		}
	}
}
