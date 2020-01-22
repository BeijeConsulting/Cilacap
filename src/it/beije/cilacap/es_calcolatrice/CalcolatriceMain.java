package it.beije.cilacap.es_calcolatrice;

import java.util.Arrays;
import java.util.Scanner;

public class CalcolatriceMain {
	
	public static char[] ammessi = {'0','1','2','3','4','5','6','7','8','9','.','+','-','*','/','%','(',')','=','Q','q'};

	public static void main(String[] args) {
		System.out.println("Caratteri ammessi : " + Arrays.toString(ammessi));
		Scanner s = new Scanner(System.in);
		String st = s.next();
		System.out.println(calcolo(st));
		s.close();
	}
	
	private static String calcolo(String st) {
		String t = st.replace("-", "+-");
		return calcoloPattern(t);
	}
	
	private static String calcoloPattern(String esp) {
		String regNumber = "[-]?+[0-9]+(\\.[0-9]+)?";
		int i = esp.indexOf("(");
		if(i>-1) {
			int j = esp.length()-new StringBuilder(esp).reverse().indexOf(")")-1;
			if(j!=esp.length()) return calcoloPattern(esp.substring(0, i) + calcoloPattern(esp.substring(i+1, j)) + esp.substring(j+1));
			else return "error";
		}
		if(esp.matches(regNumber)) return esp;
		i = esp.length()-new StringBuilder(esp).reverse().indexOf("+")-1;
		if(i!=esp.length()) return Double.parseDouble(calcoloPattern(esp.substring(0, i)))+Double.parseDouble(calcoloPattern(esp.substring(i+1, esp.length())))+"";
		i = esp.length()-new StringBuilder(esp).reverse().indexOf("*")-1;
		if(i!=esp.length()) return Double.parseDouble(calcoloPattern(esp.substring(0, i)))*Double.parseDouble(calcoloPattern(esp.substring(i+1, esp.length())))+"";
		i = esp.length()-new StringBuilder(esp).reverse().indexOf("/")-1;
		if(i!=esp.length()) return Double.parseDouble(calcoloPattern(esp.substring(0, i)))/Double.parseDouble(calcoloPattern(esp.substring(i+1, esp.length())))+"";
		i = esp.length()-new StringBuilder(esp).reverse().indexOf("%")-1;
		if(i!=esp.length()) return Integer.parseInt(calcoloPattern(esp.substring(0, i)))%Integer.parseInt(calcoloPattern(esp.substring(i+1, esp.length())))+"";
		return "error";
	}

}