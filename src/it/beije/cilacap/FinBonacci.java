package it.beije.cilacap;

import java.util.ArrayList;

public class FinBonacci {
	static ArrayList<Integer> MyFinBonacci(int occorenze, int righe,ArrayList<Integer> array) {
		String n1 = "0";
		String n2 = "1";
		String result = "0";
		String count = "0";
		int pn1 = Integer.parseInt(n1);
		int pn2 = Integer.parseInt(n2);
		int presult = Integer.parseInt(result);

	    array = new ArrayList<>();

		for (int i = 0; i < righe; i++) {
			presult = pn1 + pn2;
			pn1 = pn2;
			pn2 = presult;
			Integer in1 = Integer.valueOf(pn1);
			Integer in2 = Integer.valueOf(pn2);
			Integer in3 = Integer.valueOf(presult);
			if (i == 1) {
				array.add(in1);
			}
			array.add(in3);

			if (array.size() - 1 != occorenze) {
				System.out.println(array);
			}

		}
		return array;
	}

	public static String[] myReverse(ArrayList<Integer> array1) {

		String[] str = new String[array1.size()];
		for (int i = 0; i < array1.size() - 1; i++)
			str[i] = "";

		for (int i = array1.size() - 1; i >= 0; i--) {
			for (int x = 0; x <= i; x++)
				str[i] += Integer.toString(array1.get(x));
		}
		return str;
	}

	public static void main(String[] args) {

		ArrayList<Integer> arrayFine = MyFinBonacci(5, 5,new ArrayList<>());
		String[] strFine = myReverse(arrayFine);
		StringBuilder str ;
		for (int i = 0; i < strFine.length - 1; i++) {
			str = new StringBuilder((strFine[(strFine.length - 1) - i-1]));
			System.out.println(strFine[i] + " " + str.reverse());
			str.delete(0, str.length());
		}

	}

}
