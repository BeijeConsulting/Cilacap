package it.beije.cilacap.esercizi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProvaArList {

	public List<String> myClear(ArrayList<String> st) {
		ArrayList <String> s=new ArrayList<String>(); 
		int index=s.size();
		for(int i=0; i<index;i++) {                 //myClear
			s.remove(0);
		}
		return s;
	}


	public static void main(String [] args) {



		ProvaArList m=new ProvaArList();
		ArrayList<Integer> ar=new ArrayList<>();
		try{
			Integer p=new Integer("hello");
			ar.add(0, p);
			ar.add(0, 1);
			Collections.sort(ar);
		}catch (NumberFormatException e) {
			System.out.println("NumberFormatException.");
		}




		ArrayList<Integer> num=new ArrayList<Integer>();
		num.add(10);
		num.add(8);
		num.add(7);
		num.add(3);
		num.add(1);
		num.add(90);
		Collections.sort(num);

		System.out.println(num.clone());

		ArrayList<String> string=new ArrayList<>();
		string.add("oaic");
		string.add("ciao");
		string.add("ciao");
		string.add("oaic");
		string.add("ciao");
		System.out.println(string);
		System.out.println(m.myClear(string));
		System.out.println(string.isEmpty());
		System.out.println(string.size());
		System.out.println();
		int intero=Integer.parseInt("10");
		int int2=Integer.parseInt("12");
		System.out.println(intero+int2);
		for(int i=0;i<3;i++) {
			try{
				double d=Double.parseDouble("ae");
				System.out.println(d);
			}catch(NumberFormatException e) {
				System.out.println("YOU CAN'T");
			}
		}
		List<Double> r =new ArrayList<>();
		r.add(new Double(0));
		System.out.println(r);
		r.add(10.5);

	}
}




		

