package it.beije.cilacap.esercizi;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList2 {
		
		public void myClear(List listStr) { // OK
			while(!listStr.isEmpty()) {
				listStr.remove(0);
			}
		}
		
		public List myReverse(List list) { // OK
			List lista = new ArrayList();
			for(int i = list.size() - 1; i >= 0; i--) {
				lista.add(list.get(i));
			}
			return lista;
		}
		
		public boolean myEquals(List list1, List list2) {
			if(list1.size() == list2.size()) {
				for(int i = 0; i < list1.size(); i++) {
					if(!list1.get(i).equals(list2.get(i))) {
						return false;
					}
				}
				return true;
			} else {
				return false;
			}
		}

		public static void main(String[] args) {
			List<String> listStr = new ArrayList<String>();
			listStr.add("pippo");
			listStr.add("pluto");
			listStr.add("paperino");
			listStr.add("topolino");
			
			MyArrayList2 mals = new MyArrayList2();
			
			// myClear()
			System.out.println(listStr.size());
			mals.myClear(listStr);
			System.out.println(listStr.size());
			
			// myReverse()
			listStr.add("pippo");
			listStr.add("pluto");
			listStr.add("paperino");
			listStr.add("topolino");
			
			List<String> listStr2 = new ArrayList<String>();
			listStr2.add("pippo");
			listStr2.add("pluto");
			listStr2.add("paperino");
			listStr2.add("topolino");
			
			List<String> listStr3 = new ArrayList<String>();
			listStr3.add("pippo");
			listStr3.add("pluto");
			listStr3.add("paperino");
			listStr3.add("topolino");
						
			System.out.println(listStr2);
			System.out.println(mals.myReverse(listStr2));
			
			// myEquals()
			System.out.println(mals.myEquals(listStr3, listStr));
			listStr3.set(2, "qui quo qua");
			System.out.println(mals.myEquals(listStr3, listStr));
			
			
		}
}
