package it.beije.cilacap.esercizi;

public class MetodiMorra {

	public void sasso(String a, String b) {
		while(a.equalsIgnoreCase("Sasso")){
			if(b.equalsIgnoreCase("Carta")){
				System.out.println("Vince il giocatore 2");
			}else if(b.equalsIgnoreCase("Sasso")) {
				System.out.println("Pareggio");
			}else {
				System.out.println("Vince il giocatore 1");
			}
			break;
		}
	}

	
	public void carta(String a,String b) {

		while(a.equalsIgnoreCase("Carta")){
			if(b.equalsIgnoreCase("Sasso")){
				System.out.println("Vince il giocatore 1");
			}else if(b.equalsIgnoreCase("Carta")) {
				System.out.println("Pareggio");
			}else {
				System.out.println("Vince il giocatore 2");
			}
			break;
		}
	}

	
	public void forbice(String a,String b) {
		while(a.equalsIgnoreCase("Forbice")){
			if(b.equalsIgnoreCase("Sasso")){
				System.out.println("Vince il giocatore 2");
			}else if(b.equalsIgnoreCase("Carta")) {
				System.out.println("Vince il giocatore 1");
			}else {
				System.out.println("Pareggio");
			}
			break;
		}
	}
}



