package itBeije.Cilacap.Exercise;

public class ProvaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String miaStringa= "Ciao a tutti";
		String miaStringa2="ciao a tutti";
		System.out.println("la lunghezza di questa stringa è "+ miaStringa.length());
		System.out.println("all'indice 5 si trova la lettera " + miaStringa.charAt(5)); 
		System.out.println("la prima occorrenza di a è all'indice " + miaStringa.indexOf('a'));
		System.out.println("estrapolo una stringa " + miaStringa.substring(7));
		System.out.println("tutto in maiuscolo " + miaStringa.toUpperCase() + " tutto minuscolo " + miaStringa.toLowerCase());
		System.out.println("le 2 stringhe sono esattamente uguali = " + miaStringa.equals(miaStringa2));
		System.out.println("le 2 stringhe sono uguali = " + miaStringa.equalsIgnoreCase(miaStringa2));
		System.out.println("la stringa inizia con ciao?" + miaStringa.startsWith("Ciao") + " finisce con to " + miaStringa.endsWith("to"));
		System.out.println("la stringa contiene ao?" + miaStringa.contains("ao"));
		System.out.println("replace di tutti con tutto" + miaStringa.replace("tutti", "tutto"));
		System.out.println("trimmata " + "      cccc".trim());
		

	}

}

