package it.beije.cilacap.esercizi;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerCalcolatrice {
	
	public static char[] ammessi = {'0','1','2','3','4','5','6','7','8','9','.','+','-','*','/','%','(',')','=','Q','q'};

	public static int num1=0, intermedio=0;
	
	public static void main(String[] args) {
		System.out.println("Caratteri ammessi : " + Arrays.toString(ammessi));
		
		Scanner s = new Scanner(System.in);
		String st = s.next();
		
		while (!st.equalsIgnoreCase("Q")) {
			//creazione array per controllo dei caratteri ammissibili
			String[] elementi= st.split("");
			char [] caratteri = new char [st.length()];
			for(int i =0; i<caratteri.length; i++) {
				caratteri[i]=st.charAt(i);
			}
			//controllo ammissibilità
			boolean ammissibile=false;
			for(int i=0; i<caratteri.length &!ammissibile; i++) {
				for (int j=0; j< ammessi.length &!ammissibile; j++) {
					if(caratteri[i]==ammessi[j]) {
						ammissibile=true;
					}
				}
			}
			if(ammissibile) {		
				if(elementi.length>1) {
					System.out.println("inserisci un carattere alla volta");
					//espressione(st);
				} else {
//					boolean numero=true;
//					for(int i=0; i<caratteri.length && numero; i++) {
//						switch(caratteri[i]) {
//						case '+': 		numero=false; break;
//						case '/':		numero=false;break;
//						case '-': 		numero=false;break;
//						case '%': 		numero=false;break;
//						case '*': 		numero=false;break;
//						case '=': 		numero=false;break;
//						default: num1= Integer.parseInt(st);
//						}
//					}
					switch(st) {
					case "+": 		calcola(st); break;
					case "/":		calcola(st);break;
					case "-": 		calcola(st);break;
					case "%": 		calcola(st);break;
					case "*": 		calcola(st);break;
					case "=": System.out.println(num1);break;
					case"(": espressione(); break;
					case")": System.out.println("Devi prima aprire la parentesi");
					default: {if (num1==0) num1= Integer.parseInt(st);};
					}
				}
			} else {
				System.out.println("carattere non ammissibile per adesso il risultato è: " + num1);
				}
			
				
			//System.out.println(st);
			//// CALCOLATRICE

			st = s.next();
		}
		
		System.gc();
		System.out.println("BYE!!");
		s.close();

	}
	
	private static void calcola(String simbolo) {
		Scanner s1= new Scanner(System.in);
		
			switch(simbolo) {
			case "+": 
				num1+=Integer.parseInt(s1.next()); 
				System.out.println(num1);
				break;
			case "/": 
				num1/=Integer.parseInt(s1.next());
				System.out.println(num1);
				break;
			case "-": 
				num1-=Integer.parseInt(s1.next());
				System.out.println(num1);
				break;
			case "%": 
				num1%=Integer.parseInt(s1.next());
				System.out.println(num1);
				break;
			case "*": num1*=Integer.parseInt(s1.next());System.out.println(num1);break;
			case "=": System.out.println(num1);break;
			}
	}
	
	private static void espressione() {
		Scanner s = new Scanner(System.in);
		String st = s.next();
		
		while (!st.equalsIgnoreCase("Q")&&!st.equalsIgnoreCase("=") && !st.equalsIgnoreCase(")")) {
			
			switch(st) {
			case "+": 
				intermedio+=Integer.parseInt(s.next());
				System.out.println(intermedio); 
				break;
			case "/": 
				intermedio/=Integer.parseInt(s.next());
				System.out.println(intermedio);
				break;
			case "-": 
				intermedio-=Integer.parseInt(s.next());
				System.out.println(intermedio);
				break;
			case "%": 
				intermedio%=Integer.parseInt(s.next());
				System.out.println(intermedio);
				break;
			case "*": 
				intermedio*=Integer.parseInt(s.next());
				System.out.println(intermedio);
				break;
			case "(": espressione(); break;
			default:
				if(intermedio==0) 
					intermedio=Integer.parseInt(st);
				break;
			}
		st=s.next();	
		}
	}
}