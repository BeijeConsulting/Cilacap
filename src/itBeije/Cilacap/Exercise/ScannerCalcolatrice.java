package itBeije.Cilacap.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;



public class ScannerCalcolatrice {
	
	public static char[] ammessi = {'0','1','2','3','4','5','6','7','8','9','.','+','-','*','/','%','(',')','=','Q','q'};

	public static void main(String[] args) {
		System.out.println("Caratteri ammessi : " + Arrays.toString(ammessi));
		
		Scanner scanner = new Scanner(System.in);
		String stringa = scanner.nextLine();
		
		while (!stringa.equalsIgnoreCase("Q")) 
		{
			StringTokenizer tokenizer = new StringTokenizer(stringa , ";");	
			String[] stringaPlus = stringa.split("+");
			String[] stringaMinus = stringa.split("-");
			String[] stringaMultip = stringa.split("*");
			String[] stringaDivis = stringa.split("/");
			String[] stringaResto = stringa.split("%");
			
			System.out.println(stringaPlus + " " + stringaMinus);

			stringa = scanner.nextLine();
		}
		
		System.gc();
		System.out.println("BYE!!");
		scanner.close();

	}
	public int operazione(String primoAdd , String secondoAdd , String operatore)
	{
		Integer membro1= Integer.parseInt(primoAdd);
		Integer membro2= Integer.parseInt(secondoAdd);
		int risultato = 0;
		return risultato;
		
		
	}

}
