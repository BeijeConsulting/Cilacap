package it.beije.cilacap.crystal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


@Entity
@Table(name="testrow")
public class TestRow {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="testdata_id")
	private int testdata;
	
	@Column(name="testType")
	private String rw;
	
	@Column(name="modType")
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

	public TestRow(String s, String rw, int testdataId) {
		this.testdata=testdataId;	
		this.rw = rw;
		this.type = s.split("\\(")[0].trim().replace(" ", "_");
		this.q = Integer.parseInt(s.split("Q=")[1].split(",")[0].trim());
		this.t = Integer.parseInt(s.split("T=")[1].split("\\)")[0].trim());
		this.mbs = Double.parseDouble(s.split("\\):")[1].split("MB/s")[0].trim());
		this.iops = Double.parseDouble(s.split("\\[")[1].split("IOPS")[0].trim());
		this.us = Double.parseDouble(s.split("<")[1].split("us>")[0].trim());
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

	public Element toXML(Document document) {
		Element type = document.createElement(this.type);
		type.setAttribute("t", t+"");
		type.setAttribute("q", q+"");
		Element mb = document.createElement("MBs");
		Element io = document.createElement("IOPs");
		Element us = document.createElement("us");
		mb.setTextContent(mbs+"");
		io.setTextContent(iops+"");
		us.setTextContent(this.us+"");
		type.appendChild(mb);
		type.appendChild(io);
		type.appendChild(us);
		return type;
	}
	
	public void toDB(Connection conn, int idTestData, String s) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO test_row (test_type, mood_type, q, t, mbs, iops, us, testdata_id)"
				+ " VALUES ('"+s+"', '"+type+"', "+q+", "+t+","+mbs+", "+iops+", "+us+", (SELECT id FROM testdata WHERE id="+idTestData+"))");
		ps.execute();
	}
	
}
