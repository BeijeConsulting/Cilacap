package it.beije.cilacap.esercizi;

public class Main {
	public static void main (String[] args) {
		EserciziStringMethod s = new EserciziStringMethod("  \r \t  inte \t rista 9  7   r   \r \n\n ");
		System.out.println(s.myContains("9  7"));																			//true
		System.out.println(s.myContains("\t"));																				//true
		System.out.println(s.myContains("bella"));																			//false
		System.out.println(s.myEndsWith("\n\n "));																			//true
		System.out.println(s.myEndsWith("rsds"));																			//false
		System.out.println(s.myTrim().myEquals("inte \t rista 9  7   r")); 													//true
		System.out.println(s.myTrim().myEquals("Inte \t rista 9  7   r")); 													//false
		System.out.println("INIZIO|" + s.myTrim() + "|FINE"); 																//"inte rista 9  7  \t  \tr"
		System.out.println(s.myStartsWith("  \r"));																			//true
		System.out.println(s.myStartsWith("adsdd"));																		//false
		System.out.println("|" + s.mySubString(15,19) + "|");																//"inte"							
		System.out.println(s.myTrim().myReplace('r','c'));																	//"   inte cista 9  7   c "
		System.out.println("INIZIO|" + s.myTrim().myReplace('i','X').mySubString(1, 4) + "|FINE");							//
		System.out.println("INIZIO|" + s.myReplace('\n','X').myReplace('\r','Y').myReplace('\t','Z') + "|FINE");            //
		System.out.println("INIZIO|" + s.myTrim().myReplace('\n','X').myReplace('\r','Y').myReplace('\t','Z') + "|FINE");	//
	}
}
