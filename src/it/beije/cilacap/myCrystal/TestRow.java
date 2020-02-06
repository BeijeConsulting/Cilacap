package it.beije.cilacap.myCrystal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_row")
public class TestRow {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="test_type")
	private String type;
	
	@Column(name="q")
	private int q;
	
	@Column(name="t")
	private int t;
	
	@Column(name="mbs")
	private double mbs;
	
	@Column(name="iops")
	private double iops;
	
	@Column(name="us")
	private double us;
	
	@Column(name="id_testdata")
	private int id_testdata; 
	
	
	public int getId_testdata() {
		return id_testdata;
	}
	public void setId_testdata(int id_testdata) {
		this.id_testdata = id_testdata;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
