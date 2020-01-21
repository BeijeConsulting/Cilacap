package it.beije.cilacap.es_arrayList;

import java.util.ArrayList;

public class MyArrayList {
	
	private ArrayList list = new ArrayList();
	
	public MyArrayList(ArrayList list) {
		this.list=list;
	}
	
	public ArrayList getList() {
		return list;
	}
	
	public void myClear() {
		for(int i=0; i<list.size(); i++) {
			list.remove(i);
		}
	}
	
	public MyArrayList myReverse() {
		ArrayList rev = new ArrayList();
		for(int i=list.size()-1; i>=0; i--) {
			rev.add(list.get(i));
		}
		list=rev;
		return this;
	}
	
	public boolean myEquals(MyArrayList comp) {
		if(list.size()!=comp.getList().size()) return false;
		for(int i=0; i<list.size(); i++) {
			if(!list.get(i).equals(comp.getList().get(i))) return false;
		}
		return true;
	}

	public boolean myEqualsToString(MyArrayList comp) {
		if(list.size()!=comp.getList().size()) return false;
		for(int i=0; i<list.size(); i++) {
			if(!list.get(i).toString().equals(comp.getList().get(i).toString())) return false;
		}
		return true;
	}

}
