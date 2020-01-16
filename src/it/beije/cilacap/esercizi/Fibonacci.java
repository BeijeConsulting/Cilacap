package it.beije.cilacap.esercizi;

import java.util.ArrayList;

import java.util.*;


public class Fibonacci {
	
	public List<Integer> occorrenze(int n) {
		ArrayList<Integer> lista= new ArrayList<Integer>();
		for(int i=0;i<=n;i++) {
			lista.add(0);
			lista.add(1);
			for(int j=2;j<=n;j++){
				lista.add(lista.get(j-1)+lista.get(j-2));
			  }
			break;
		 }
		return lista;
}
	
	public List<Integer> righe(int n) {
		ArrayList<Integer> lista= new ArrayList<Integer>();
		for(int i=0;i<=n;i++) {
			lista.add(0);
			lista.add(1);
			for(int j=1;j<=n;j++){
				lista.add(j);
				lista.add(lista.get(j-1) + lista.get(j-2));
			}
		}
		return lista;
	}
	
	/*public void stampaRighe(int n){
		List<Integer>l=this.occorrenze(n);
		System.out.println(l);
	}*/
		public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        Fibonacci m=new Fibonacci();
		ArrayList<Integer> lista= new ArrayList<Integer>();	
		System.out.println("Inserisci un intero: ");
		System.out.println(m.occorrenze(s.nextInt()));
		System.out.println(m.righe(s.nextInt()));
		//m.stampaRighe(s.nextInt());

	}
}
