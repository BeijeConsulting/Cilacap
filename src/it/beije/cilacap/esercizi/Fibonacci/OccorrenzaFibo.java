package it.beije.cilacap.esercizi.Fibonacci;
import java.util.*;

public class OccorrenzaFibo { 
	    
	public List<Integer> Fibo(int x) {   
		List<Integer> list = new ArrayList<>();
		if(x==0 || x==1) {
			list.add(0,1);
			return list;
		}
		else {
			list.add(0,1);
			list.add(1,1);
			for(int i=2;i<x;i++) 
			list.add(list.get(i-1)+list.get(i-2));
		}
		return list;
		
		
		
	}
//FINO A QUI OK, STAMPA CORRETTAMENTE L'OCCORRENZA
	
	public List<Integer> FiboTriangle(int x){
		StringBuilder sb1,sb2= new StringBuilder();
		for(int i=0;i<x;i++) {
			sb2=new StringBuilder(Fibo(i+1).toString());
			sb1=new StringBuilder(Fibo(x-i).toString());
			sb1.deleteCharAt(0);
			sb1.deleteCharAt(sb1.length()-1);
			String s= sb1.reverse().toString();
			String g=sb2.toString();
			
			System.out.println(g+"   "+ s);
			}
		System.out.println("Occorrenza richiesta:");
		
		return (Fibo(x));
	}
}
	
	
		
	     



			
	
				
				
			
				
		
		
		
	


