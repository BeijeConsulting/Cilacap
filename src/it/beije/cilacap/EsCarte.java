package it.beije.cilacap;

public class EsCarte {
	public static void main(String[] args) {
	GiocoCarte("1", "K");
}

public static void GiocoCarte(String sceltaGiocatore1, String sceltaGiocatore2){
		String[] Carte = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		int indexSceltaGiocatore1 = 1;
		int indexSceltaGiocatore2 = 1;
		

		 for(int i = 1; i < (Carte.length - 3); i++) {
			 String controllo = "" + i + "";
			 if(sceltaGiocatore1.contentEquals(controllo)) {
				 indexSceltaGiocatore1 = i - 1;
				 
			 }  else if(sceltaGiocatore1.contentEquals("J"))
					indexSceltaGiocatore1 = 10;
				else if(sceltaGiocatore1.contentEquals("Q") || sceltaGiocatore1.contentEquals("D"))
					indexSceltaGiocatore1 = 11;
				else if(sceltaGiocatore1.contentEquals("K") || sceltaGiocatore1.contentEquals("R"))
					indexSceltaGiocatore1 = 12;
		 }
		 
		
		 for(int i = 1; i < (Carte.length - 3); i++) {
			 String controllo = "" + i + "";
			 if(sceltaGiocatore2.contentEquals(controllo)) {
				 indexSceltaGiocatore2 = i - 1;
				 
			 }  else if(sceltaGiocatore2.contentEquals("J"))
					indexSceltaGiocatore2 = 10;
				else if(sceltaGiocatore2.contentEquals("Q") || sceltaGiocatore2.contentEquals("D"))
					indexSceltaGiocatore2 = 11;
				else if(sceltaGiocatore2.contentEquals("K") || sceltaGiocatore2.contentEquals("R"))
					indexSceltaGiocatore2 = 12;
		}

		 
		
		if (indexSceltaGiocatore1 > indexSceltaGiocatore2) {
			
			if(indexSceltaGiocatore1 == 12 && indexSceltaGiocatore2 == 0) {
				System.out.println(Carte[indexSceltaGiocatore1] + " Perde su " + Carte[indexSceltaGiocatore2]);
			} else {
				System.out.println(Carte[indexSceltaGiocatore1] + " Vince su " + Carte[indexSceltaGiocatore2]);	
			}
			
		} else if  (indexSceltaGiocatore1 == indexSceltaGiocatore2) {
			System.out.println(Carte[indexSceltaGiocatore1] + " E' uguale a " + Carte[indexSceltaGiocatore2]);
		
		} else if(indexSceltaGiocatore1 < indexSceltaGiocatore2) {
			
			if(indexSceltaGiocatore1 == 0 && indexSceltaGiocatore2 == 12) {
				System.out.println(Carte[indexSceltaGiocatore1] + " Vince su " + Carte[indexSceltaGiocatore2]);
			} else {
				System.out.println(Carte[indexSceltaGiocatore1] + " Perde su " + Carte[indexSceltaGiocatore2]);	
			}
		}
	}
}