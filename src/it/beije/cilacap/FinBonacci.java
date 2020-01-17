package it.beije.cilacap;

import java.util.ArrayList;

public class FinBonacci {
	static void MyFinBonacci(int occorenze,int righe) {
		String n1 = "0";
		String n2 = "1";
		String result = "0";
		String count = "0";
		int pn1 = Integer.parseInt(n1);
		int pn2 = Integer.parseInt(n2);
		int presult = Integer.parseInt(result);
		ArrayList<Integer> array = new ArrayList<>(occorenze);
		ArrayList<Integer> arrayinverso = new ArrayList<>(occorenze);
		for (int i = 0; i < righe; i++) {
			presult = pn1 + pn2;
			pn1 = pn2;
			pn2 = presult;
			Integer in1 = Integer.valueOf(pn1);
			Integer in2 = Integer.valueOf(pn2);
			Integer in3 = Integer.valueOf(presult);
			if(i==1) {
				array.add(in1);	
			}
			array.add(in3);
			
			if(array.size()-1!=occorenze) {
				System.out.print(" ");
			System.out.println(array);
			;
			}else
				i=righe;
			

		}
		
	
	}

	public static void main(String[] args) {
		MyFinBonacci(20, 20);

	}

}
