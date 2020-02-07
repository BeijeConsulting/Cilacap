package it.beije.cilacap.crystal;

public class TestRow { //per ciascuna iterazione identifica delle variabili

	private String type; //read or write?
	private int q; //valore q
	private int t; //valore t
	private double mbs; //velocità in MB/s
	private double iops; //valore IOPS
	private double us; //valore us
	
	@Override
	public String toString() {
		return "TestRow [type=" + type + ", q=" + q + ", t=" + t + ", mbs=" + mbs + ", iops=" + iops + ", us=" + us
				+ "]";
	}
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
