package it.beije.cilacap.esercizi.Fibonacci;
import java.io.*;

public class FiboMain  {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i;
		OccorrenzaFibo occ= new OccorrenzaFibo();
		System.out.println("Inserire un intero >=0");
		i=Integer.parseInt(br.readLine());
		System.out.println("L'occorrenza Fibonacci relativa al numero inserito è: " + occ.Fibo(i));
		System.out.println("Il triangolo di Fibonacci con "+i+" occorrenze è:");
		System.out.println(occ.FiboTriangle(i));
		}

}