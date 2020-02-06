package it.beije.cilacap.rubrica;

import java.util.List;

public class MyRubricaJPARunner {

	public static void main(String[] args) {
		
		List<Contatto> listaContatti = MyRubricaJpa.leggiContatti();
		Utility.visualizzaRubrica(listaContatti);
		
	}
}
