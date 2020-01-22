package it.beije.cilacap.es_arrayList;

import java.util.ArrayList;

public class MyArrayList<E> {
	
	private ArrayList<E> list = new ArrayList<>();
	
	public MyArrayList(ArrayList<E> list) {
		this.list=list;
	}
	
	public ArrayList<E> getList() {
		return list;
	}
	
	public void myClear() {
		for(int i=0; i<list.size(); i++) {
			list.remove(i);
		}
	}
	
	public MyArrayList<E> myReverse() {
		ArrayList<E> rev = new ArrayList<>();
		for(int i=list.size()-1; i>=0; i--) {
			rev.add(list.get(i));
		}
		list=rev;
		return this;
	}
	
	public boolean myEquals(MyArrayList<E> comp) {
		if(list.size()!=comp.getList().size()) return false;
		for(int i=0; i<list.size(); i++) {
			if(!list.get(i).equals(comp.getList().get(i))) return false;
		}
		return true;
	}

	public boolean myEqualsToString(MyArrayList<E> comp) {
		if(list.size()!=comp.getList().size()) return false;
		for(int i=0; i<list.size(); i++) {
			if(!list.get(i).toString().equals(comp.getList().get(i).toString())) return false;
		}
		return true;
	}

}
