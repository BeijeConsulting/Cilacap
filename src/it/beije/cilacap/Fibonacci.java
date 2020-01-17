package it.beije.cilacap;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fibonacci prova = new Fibonacci();
		List<Integer> Fibo = new ArrayList<>();
		
		prova.Robafinale(10);
		
	}
	public void Robafinale(int arg) {
		int prova=--arg;
		List<Integer> Fibo = new ArrayList<>();
		for(int i=0;i<=arg;i++) {
			Fibo = this.Occorrenze(i);
			System.out.print(Fibo);
			System.out.print("    ");
			Fibo = this.Occorrenze(prova--);
			System.out.print("[");
			for(int z=prova+1;z>=0;z--) {
				System.out.print(Fibo.get(z)+ " ");
				if(z!=0)
					System.out.print(",");
			}	
			System.out.print("]");
			System.out.println();
		}
			
	}

	
	public void Righe(int numrighe) {
		List<Integer> Fibo = new ArrayList<>();
		for(int i=0;i<numrighe;i++) {
			Fibo = this.Occorrenze(i);
			System.out.println(Fibo);
		}
	}
	
	
	
	public List <Integer> Occorrenze (int occ){
		List<Integer> Fibo = new ArrayList<>();
		int start1=0;
		int start=1;
		Fibo.add(start1);
		if(occ!=0) {
			Fibo.add(start);
			for(int i=start+1;i<=occ;i++) {
				int somma= Fibo.get(i-1)+Fibo.get(i-2);
				Fibo.add(somma);
			}
		}else return Fibo;
		
		return Fibo;
		
	}
	

}
