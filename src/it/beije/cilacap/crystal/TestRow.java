package it.beije.cilacap.crystal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.Type;

@Entity
@Table(name="test_row")
public class TestRow {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id_testRow;
	
	@Column(name = "testdata_id")
	private int testdataId;
	
	@Column(name="mood_type")
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
	
	@Column(name="test_type")
	private String testType;
	
	
	
	
	
	public int getId() {
		return id_testRow;
	}
	public void setId(int id) {
		this.id_testRow = id;
	}
	public int getTestdataId() {
		return testdataId;
	}
	public void setTestdataId(int id_computer) {
		this.testdataId = id_computer;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
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
