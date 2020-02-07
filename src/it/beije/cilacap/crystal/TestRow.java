package it.beije.cilacap.crystal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_row")
public class TestRow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "test_type")
	private String type; // sequential/random

	@Column(name = "mode_type")
	private String modeType;

	@Column(name = "id_testdata")
	private String idTestData;

	@Column(name = "q")
	private int q;
	@Column(name = "t")
	private int t;
	@Column(name = "mbs")
	private double mbs;
	@Column(name = "iops")
	private double iops;
	@Column(name = "us")
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

	@Override
	public String toString() {
		return "{\ntype::" + type + " Q::" + q + ", T::" + t + ", mbs::" + mbs + ", iops::" + iops + ", us::" + us
				+ "}";
	}

}
