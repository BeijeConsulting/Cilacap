package it.beije.cilacap.esercizi;

public class MetodiStr {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Metodi method=new Metodi();


		String nome="   Riccardo";
		String cognome="Riccardo";
		String nn=new String("Riccardo");



		System.out.println("Il metodo myReverse() restituisce: "+method.myReverse(nn));
		System.out.println("Il metodo myEquals() restituisce: "+method.myEquals("Riccardo", "Sotto"));
		System.out.println("Il metodo myContains() restituisce: "+method.myContains(cognome,"Riccar"));

		System.out.println("Il metodo myStartsWith() restituisce: "+method.myStartsWith("foschi", "f"));
		System.out.println("Il metodo myEndsWith() restituisce: "+method.myEndsWith("pino", "o"));

		System.out.println("Il metodo mySubstring() restituisce : "+method.mySubstring(cognome, 2, 5));


		System.out.println("Il metodo myReplace() restituisce: "+method.myReplace("Rotto", 'o', 'a'));
		System.out.println("Il metodo myTrim() restituisce: "+method.myTrim("   dai  e"));

        nome=nome.trim();
		System.out.println(nome.length());
		System.out.println(nome.equals(cognome));
		System.out.println();
		System.out.println();

		System.out.println(nome);






	}

}
