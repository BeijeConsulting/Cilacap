package it.beije.cilacap.esercizi.calcolatrice;

import java.util.ArrayList;
import java.util.List;

public class StrutturaCalcolatrice {

	private List<Double> numeri;
	private List<String> operatori;
	private int headNumeri;
	private int headOperatori;
	
	public StrutturaCalcolatrice() {
		numeri = new ArrayList<Double>();
		operatori = new ArrayList<String>();
		headNumeri = 0;
		headOperatori = 0;
	}
	
	public double getLastNumber() {
		return numeri.remove(headNumeri--); 
	}
	
	public String getLastOp() {
		return operatori.remove(headOperatori--);
	}
	
	public void pushNumber(String s) {
		numeri.add(Double.parseDouble(s));
		headNumeri++;
	}
	
	public void pushOp(String s) {
		operatori.add(s);
		headOperatori++;
	}
	
	

	public List<Double> getNumeri() {
		return numeri;
	}

	public List<String> getOperatori() {
		return operatori;
	}

	public int getHeadNumeri() {
		return headNumeri;
	}

	public int getHeadOperatori() {
		return headOperatori;
	}
	
}
