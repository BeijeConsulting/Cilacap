package it.beije.cilacap.crystal;

public class TestRow {

	private String type; //sequential/random
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
	
}
