package it.beije.cilacap.crystal;

import java.util.ArrayList;
import java.util.List;

public class TestData {
	
	private String idComputer; //nome cartella del file. Default 01
	private String version; //versione Crystal presente nella prima riga
	private String os; //sotto la dicitura OS (ultima riga)
	private String type; //quantità RAM
	private String iterations; //valore presente accanto alla RAM
	private String interval; //Indicata in secondi tra parentesi quadre vicino RAM
	private String date; //sotto la dicitura date
	
	private List<TestRow> read = new ArrayList<TestRow>();
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
	
	public String getIterations() {
		return iterations;
	}
	public void setIterations(String iterations) {
		this.iterations = iterations;
	}
	
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
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
