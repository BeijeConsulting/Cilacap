package it.beije.cilacap.crystal;

import java.util.ArrayList;

public class TestRow {

	private String type;
	private int q;
	private int t;
	private double mbs;
	private double iops;
	private double us;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getQ() {
		return q;
	}
	public void setQ(int q) {
		this.q = q;
	}
	
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
	}
	
	public double getMbs() {
		return mbs;
	}
	public void setMbs(double mbs) {
		this.mbs = mbs;
	}
	
	public double getIops() {
		return iops;
	}
	public void setIops(double iops) {
		this.iops = iops;
	}
	
	public double getUs() {
		return us;
	}
	public void setUs(double us) {
		this.us = us;
	}
	
	public TestRow Popolo(ArrayList<String> File,int riga) {
		TestRow test = new TestRow();
		String app= new String();
		int Q=File.get(riga).indexOf("Q=")+2,QF = File.get(riga).indexOf(",");
		int T=File.get(riga).indexOf("T=")+2,TF=File.get(riga).indexOf(")");
		int MB= File.get(riga).indexOf(":")+1,MBF = File.get(riga).indexOf("MB");
		int Iops = File.get(riga).indexOf("[")+1,IopsF = File.get(riga).indexOf("IOPS");
		int Us = File.get(riga).indexOf("<")+1,UsF= File.get(riga).indexOf("us");
		if(File.get(riga).contains("Sequential")) {
			test.setType("Sequential_1MiB");
		}else test.setType("Random_4KiB");
		test.setQ(Integer.parseInt(app+=File.get(riga).substring(Q, QF).trim()));
		app = "";
		test.setT(Integer.parseInt(app+=File.get(riga).substring(T,TF).trim()));
		app = "";
		test.setMbs(Double.parseDouble(app+=File.get(riga).substring(MB,MBF).trim()));
		app = "";
		test.setIops(Double.parseDouble(app+=File.get(riga).substring(Iops,IopsF).trim()));
		app = "";
		test.setUs(Double.parseDouble(app+=File.get(riga).substring(Us, UsF).trim()));
		return test;
	}
	
}
