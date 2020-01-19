package it.beije.cilacap.esercizi.strings;

public class MainStrings {

	public static void main(String[] args) {
		StringManagerImpl sin = new StringManagerImpl("\n\t\t   ciaoSo no  \t\n\r "); 		
//		System.out.println(sin.myTrim());
//		StringManagerImpl  strafare= sin.myTrim();
//		System.out.println(sin.mySubString(2, 5));	
//		System.out.println(strafare.MyEndWith("no"));
		System.out.println(sin.myEquals("ciao"));		
	}

}
