package it.beije.cilacap.esercizi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class MyArrayList {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(1));
		list.add(2);
		list.add(100);
		System.out.println(list);
		list.remove(new Integer(1));
		list.remove(0);
		System.out.println(list);
		
		int i = Integer.parseInt("3");
		Integer integer = Integer.valueOf(5);
		Boolean b = Boolean.valueOf("true");
		System.out.println(b);
		System.out.println(i);
		System.out.println(integer);
		System.out.println(list.contains(new Integer(2)));
		
		
		List<String> str = new ArrayList<String>();
		str.add("ciao4");
		str.add("ciao2");
		str.add("ciao3");
		str.add("ciao1");
		str.add("ciao6");
		str.add("ciao5");
		
		System.out.println(str.size());
		
		// START myClear()
		for(i = 0; i < str.size()+i; i++) {
			System.out.println(str.remove(0));
		}
		System.out.println(str);
		// END myClear()
		
		List<String> sl = new ArrayList<String>();
		String[] sa = {"10", "9", "100"};
		sl = Arrays.asList(sa);
		Collections.sort(sl);
		System.out.println(sl);
		
		Integer[] arrayInt = new Integer[5];
		Random r = new Random();
		for(int a = 0; a < arrayInt.length; a++) {
			arrayInt[a] = r.nextInt(21);
			System.out.println(arrayInt[a]);
		}
		
		List<Integer> listInteger = Arrays.asList(arrayInt);
		
		System.out.println(listInteger);
		Collections.sort(listInteger);
		System.out.println(listInteger);
		
		ArrayList<String> listStr = new ArrayList<String>();
		List<String> listStr2 = new ArrayList<String>();
		
		listStr.add("pippo");
		listStr.add("pluto");
		listStr.add("paperino");
		listStr.add("topolino");
		
		listStr2.add("pippo");
		listStr2.add("pluto");
		listStr2.add("paperino");
		listStr2.add("topolino");
		
		System.out.println(listStr.equals(listStr2));
		
		
		System.out.println(listStr.contains("pippo"));
		System.out.println(listStr.set(0, "ciccio"));
		System.out.println(listStr);
		
	
	}
	
}
