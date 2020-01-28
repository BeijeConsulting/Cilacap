package it.beije.cilacap.es_zoo;

import java.util.ArrayList;

import it.beije.cilacap.es_zoo.animali.Aquila;
import it.beije.cilacap.es_zoo.animali.Balena;
import it.beije.cilacap.es_zoo.animali.Gallina;
import it.beije.cilacap.es_zoo.animali.PesceRosso;
import it.beije.cilacap.es_zoo.animali.Piccione;
import it.beije.cilacap.es_zoo.animali.Ragno;
import it.beije.cilacap.es_zoo.animali.Rana;
import it.beije.cilacap.es_zoo.animali.Serpente;
import it.beije.cilacap.es_zoo.animali.TigreSiberiana;
import it.beije.cilacap.es_zoo.extenders.Animale;
import it.beije.cilacap.es_zoo.extenders.vivente;

public class ZooMain {

	public static void main(String[] args) {
		ArrayList<Animale> animaliPresenti = new ArrayList<>();
		animaliPresenti.add(new Balena(40));
		animaliPresenti.add(new TigreSiberiana(12));
		animaliPresenti.add(new Aquila(10));
		animaliPresenti.add(new Serpente(4));
		animaliPresenti.add(new Rana(2));
		
		ArrayList<vivente> cibo = new ArrayList<>();
		cibo.add(new Gallina(7));
		cibo.add(new Ragno(1));
		cibo.add(new Piccione(2));
		cibo.add(new PesceRosso(3));
		
		for(Animale a : animaliPresenti) {
			for(vivente v : cibo) {
				System.out.println("Animale selezionato: "+a+"; cibo selezionato: "+v);
				System.out.println("L'animale ha mangiato?   "+a.mangio(v));
			}
		}

	}

}
