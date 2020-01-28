package it.beije.cilacap.crystal;

import java.util.ArrayList;
import java.util.List;

public class TestData {
	
	private String idComputer;
	private String version;
	private String os;
	private String type;
	private int iterations;
	private String interval;
	private String date;
	
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
	
	public int getIterations() {
		return iterations;
	}
	public void setIterations(int iterations) {
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

	public TestData Popola(ArrayList<String> File) {
		String app = new String();
		TestData test = new TestData();
		for(int i=0;i<File.size();i++) {
			if(File.get(i).contains("Date:")) {
				test.setDate(File.get(i).substring(9, 28));
			}
			if(File.get(i).contains("Interval:")) {
				test.setInterval(app+=File.get(i).charAt(31));
				app = "";
				test.setIterations(Integer.parseInt(app+=File.get(i).charAt(17)));
				test.setType(File.get(i).substring(9,14));
			}
			if(File.get(i).contains("(C)")) {
				test.setVersion(File.get(i).substring(16, 21));
			}
			if(File.get(i).contains("Professional")) {
				test.setOs(File.get(i).substring(9, 19));
			}
		}
		test.setIdComputer("03");
		test.read = test.CreaRead(File);
		test.write = test.CreaWrite(File);
		return test;
	}
	
	public List<TestRow> CreaRead(ArrayList<String> File){
		 List<TestRow> read = new ArrayList<TestRow>();
		 TestRow test = new TestRow();
		for(int i=0,z=0;i<File.size();i++) {
			if(File.get(i).contains("Read")) {
				i++;
				z++;
				while(File.get(i).contains("Q=")) {
					read.add(test.Popolo(File,i));
					i++;
				}
			}else if(z!=0) break;
		}
		return read;
	}
	public List<TestRow> CreaWrite(ArrayList<String> File){
		 List<TestRow> read = new ArrayList<TestRow>();
		 TestRow test = new TestRow();
		for(int i=0,z=0;i<File.size();i++) {
			if(File.get(i).contains("Write")) {
				i++;
				z++;
				while(File.get(i).contains("Q=")) {
					read.add(test.Popolo(File,i));
					i++;
				}
			}else if(z!=0) break;
		}
		return read;
	}
	
	
	
	
	
	
	
	
}
