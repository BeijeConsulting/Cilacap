package it.beije.cilacap.crystal;

import java.util.ArrayList;
import java.util.List;

public class TestData {
	
	private String idComputer;
	private String version;
	private String os;
	private String type;
	private int iterations;
	private int intervalInSeconds;
	private String date;
	
	private List<TestRow> read = new ArrayList<TestRow>();
	private List<TestRow> write = new ArrayList<TestRow>();
	
	
	public String getIdComputer() {
		return idComputer;
	}
	public void setIdComputer(String i) {
		this.idComputer = i;
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

}
