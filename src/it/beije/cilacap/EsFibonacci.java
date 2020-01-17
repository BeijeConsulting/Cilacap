package it.beije.cilacap;

import java.util.*;

public class EsFibonacci {
	
	public static void main(String[] args) {
		FibonacciRighe(8);
		System.out.println();
		FibonacciOccorrenze(10);
	}
		
	public static void FibonacciRighe(int nRighe){
		
		ArrayList<Integer> list = new ArrayList<Integer>();	
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		for (int i = 0; i < nRighe; i++) {
			if(i == 0) {
				list.add(0,0);
			}
			else if (i == 1) {
				list.add(1,1);
			}
			else {
				list.add(i, (list.get(--i) + list.get(--i)));
				i += 2;
			}	
		}
		
		ArrayList<Integer> reverseList = new ArrayList<Integer>(list);
		Collections.reverse(reverseList);
		int count = 0;
		
		for(int i = 0; i < nRighe; i++) {
			
		    list2.add(i, list.get(i));
			System.out.print(list2 + "     ");
			
			System.out.println(reverseList);
			reverseList.remove(count);
		}
	}
	
	public static void FibonacciOccorrenze(int occorrenze){
		
		ArrayList<Integer> list = new ArrayList<Integer>();	
		
		for (int i = 0; i < occorrenze; i++) {
			if(i == 0) {
				list.add(0,0);
			}
			else if (i == 1) {
				list.add(1,1);
			}
			else {
				list.add(i, (list.get(--i) + list.get(--i)));
				i += 2;
				
				if(list.size() == occorrenze) {
					System.out.println(list);
					break;
				}
			}	
		}
	}
}
