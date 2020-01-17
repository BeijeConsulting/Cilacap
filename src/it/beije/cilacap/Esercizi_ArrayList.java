package it.beije.cilacap;

import java.util.ArrayList;

public class Esercizi_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <String> prova = new ArrayList<>();
		boolean uguali;
		ArrayList <String> prova2 = new ArrayList<>();
		Esercizi_ArrayList provina = new Esercizi_ArrayList();
		prova.add("weee");
		prova.add("comea");
		prova.add("va");
		prova.add("andrea");
		prova2.add("weee");
		prova2.add("come");
		prova2.add("va");
		prova2.add("andrea");
		System.out.println(prova);
		System.out.println(prova2);
		
		
		
		uguali=provina.myEquals(prova, prova2);
		System.out.println(uguali);

		
	}
	void myClear(ArrayList<String> list) {
		for(int i=0;!list.isEmpty();) {
			list.remove(i);
		}
	}

	void reverse(ArrayList<String> list) {
		ArrayList <String> appoggio = new ArrayList<>();
		for(int i=list.size()-1;i>=0;i--) {
			appoggio.add(list.get(i));
		}
		System.out.println(appoggio);
	}
	
	boolean myEquals(ArrayList<String> list,ArrayList<String> list2) {
		String n,m;
		if(list.size()==list2.size()) {
			for(int i=0;i<list.size();i++) {
				if(!(list.get(i).equals(list2.get(i)))) {
					return false;
				}
			}
			return true;
			
		} else return false;
		
	}
}
