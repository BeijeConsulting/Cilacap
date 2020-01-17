package it.beije.cilacap.esercizi.FibonacciSeq;
import java.util.*;

import it.beije.cilacap.esercizi.EserciziStringMethod;

public class FibonacciSeq {
	
	

	
	public int[] fibonacciSeq(int index) {
		int[] seq ;
		seq = new int[index];
		
		if (index < 2) {
			seq[1]= 1;
			return seq;
		}
		else {
			for (int i = 0; i < index-1; i++) {
			
				if (i == 0) {
					seq[i]= 1;
					seq[i+1]= 1;
					continue;
				}
				else 
					seq[i+1] = seq[i-1] + seq[i];
				
			}
		}
		
		return seq;
	}
	
	public String[] fibonacciSeqRawPrint(int[] seq) {
		String[] seqPrint = new String[seq.length];
		int x;
		
		for(int i = 0; i < seq.length; i++) {
			seqPrint[i] = "";
		}
		
		for(int i = seq.length-1; i >= 0; i--) {
			for (x = 0; x<=i; x++) {
				seqPrint[i] += seq[x] + " ";
			}
		}
		
		return seqPrint;
	}
	
	public void fiboList(int index) {
		String[] seqPrint = fibonacciSeqRawPrint(fibonacciSeq(index));
		for(int i = 0 ; i < seqPrint.length; i++) 
			System.out.println(seqPrint[i] + " " + myReverse(seqPrint[((seqPrint.length-1)-i)]));
	}
	//myReverse(seqPrint[((seqPrint.length-1)-i)]));
	public void fiboRaw(int index) {
		String[] seqPrint = fibonacciSeqRawPrint(fibonacciSeq(index));
		System.out.println(seqPrint[index-1]);
	}
	
	public String myReverse(String str1) {
		StringBuilder response = new StringBuilder();
		
		for (int i = str1.length()-1; i >= 0; i--) 
			response.append(Character.toString(str1.charAt(i)));
		
		return response.toString();
	}
}
	
	
	


