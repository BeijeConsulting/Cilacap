package it.beije.cilacap.crystal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "testdata")
public class TestData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "id_computer")
	private String idComputer;
	@Column(name = "version")
	private String version;
	@Column(name = "os")
	private String os;
	@Column(name = "type")
	private String type;
	@Column(name = "iterations")
	private int iterations;
	@Column(name = "interval")
	private int intervalInSeconds;
	@Column(name = "date")
	private String date;

	@Transient
	private List<TestRow> read = new ArrayList<TestRow>();
	@Transient
	private List<TestRow> write = new ArrayList<TestRow>();

	public String getIdComputer() {
		return idComputer;
	}

	public void setIdComputer(String idComputer) {
		this.idComputer = idComputer;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIterations() {
		return iterations;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}

	public int getIntervalInSeconds() {
		return intervalInSeconds;
	}

	public void setIntervalInSeconds(int intervalInSeconds) {
		this.intervalInSeconds = intervalInSeconds;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<TestRow> getRead() {
		return read;
	}

	public void setRead(List<TestRow> read) {
		this.read = read;
	}

	public List<TestRow> getWrite() {
		return write;
	}

	public void setWrite(List<TestRow> write) {
		this.write = write;
	}

	@Override
	public String toString() {

		String outputPrint = "TestData \n{" + "\nidComputer::" + idComputer + "\nVersion::" + version + "\nos::" + os
				+ "\ntype::" + type + "\niteration::" + iterations + "\ninterval::" + intervalInSeconds + "\ndate::"
				+ date + "\nread::" + read + "\nwrite::" + write + "}";
		return outputPrint;
	}

}
