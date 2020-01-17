package it.beije.cilacap.esercizi;

import java.util.ArrayList;

import java.util.*;


public class Fibonacci {

	public List<Integer> occorrenze(int n) {
		ArrayList<Integer> lista= new ArrayList<Integer>();

		lista.add(0);
		lista.add(1);
		for(int i=2;i<=n;i++){
			lista.add(lista.get(i-1)+lista.get(i-2));
		}
		return lista;
	}


	public void stampaRighe(int n){
		List<Integer>l=this.occorrenze(n);
		for(int i=0;i<n;i++){
			for(int a=0; a<=i;a++) {
				System.out.print(l.get(a));
			}
			System.out.println();	
		}
	}
	public void reverse(int r) {
		List<Integer> lista=this.occorrenze(r);

		for(int i=0;i<=r;i++) {
			for(int f=0;f<=i;f++) {
				System.out.print(lista.get(f)+" ");
			}
			System.out.print("    ");
			for(int a=r-i;a>=0;a--) {
				System.out.print(lista.get(a)+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		Fibonacci m=new Fibonacci();
		ArrayList<Integer> lista= new ArrayList<Integer>();	
		System.out.println("Inserisci un intero: ");
		System.out.println(m.occorrenze(s.nextInt()));
		System.out.println();
		m.stampaRighe(s.nextInt());
		System.out.println();
		m.reverse(s.nextInt());
	}
}
