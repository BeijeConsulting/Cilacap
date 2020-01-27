package it.beije.cilacap.crystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TestData {
	
	private String pathDestination;
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd H:mm:ss");
	
	private String idComputer; 
	private String version;  
	private String os;    
	private String type;    
	private int iterations;  
	private String interval;
	private LocalDateTime date;

	private static final String regexVersion = "CrystalDiskMark[ ][0-9]+[\\.][0-9]+[\\.][0-9][ ]+[x][0-9]+[ ]\\(C\\)"; 
	private static final String regexOs = "([ ]+)?OS:[ ]+";
	private static final String regexTypeIterInt = "([ ]+)?Test:[ ]+";
	private static final String regexDate = "([ ]+)?Date:[ ]+";
	
	private List<TestRow> read = new ArrayList<TestRow>();
	private List<TestRow> write = new ArrayList<TestRow>();
	
	public TestData(File file) throws IOException {
		String pathFile = file.getAbsolutePath().toString();
		System.out.println("Elaboro il file: "+ pathFile);
		String backSlashPattern = Pattern.quote(System.getProperty("file.separator"));
		idComputer = pathFile.split("crystal"+backSlashPattern)[1].split(backSlashPattern)[0];
		pathDestination = pathFile.split(idComputer+backSlashPattern)[0]+"XML\\"+idComputer+"\\"+file.getName().replace(".txt", ".xml"); 
		ArrayList<String> splitted = fromFileToArray(file);
		for(int i=0; i<splitted.size(); i++) {
			String s = splitted.get(i);
		///ricerca versione
			if(Pattern.compile(regexVersion).matcher(s).find()) 
				this.version=s.split("\\(C\\)")[0].split("CrystalDiskMark")[1].trim();
		//ricerca os
			else if(Pattern.compile(regexOs).matcher(s).find()) 
				this.os=s.split("\\[")[0].split("S:")[1].trim();
		// ricerca type, iteration e interval
			else if(Pattern.compile(regexTypeIterInt).matcher(s).find()) {
				String presplit = s.split("\\]")[0].split("Test:")[1].trim();
				this.type=presplit.split("\\(")[0].trim();
				this.iterations=Integer.parseInt(presplit.split("\\)")[0].split("\\(x")[1]);
				this.interval=presplit.split("Interval:")[1].trim();
			}
		//ricerca data ( elimina toString() per cambiare tipo)
			else if(Pattern.compile(regexDate).matcher(s).find())
				this.date=LocalDateTime.parse(s.split("ate: ")[1].trim(), formatter);
		//crea testRow read e testRow write
			else if(s.equals("[Read]")) {
				int j=0;
				for(j=i+1; j<splitted.size()&&!splitted.get(j).equals(""); j++)
					read.add(new TestRow(splitted.get(j)));
			}
			else if(s.equals("[Write]")) {
				int j=0;
				for(j=i+1; j<splitted.size()&&!splitted.get(j).equals(""); j++)
					write.add(new TestRow(splitted.get(j)));
			}
		}
	}
	
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
	
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
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
	
	public String getPathFile() {
		return pathDestination;
	}
	
	public Element toXML(Document document) throws ParserConfigurationException {
        Element crystal = document.createElement("CrystalDiskMark");
        Element test = document.createElement("test");
        test.setAttribute("date", date.format(formatter));
        test.setAttribute("interval", interval);
        test.setAttribute("iterations", iterations+"");
        test.setAttribute("type", type);
        test.setAttribute("os", os);
        test.setAttribute("version", version);
        test.setAttribute("id_computer", idComputer);
        Element read = document.createElement("read");
        for(TestRow tr : this.read)
        	read.appendChild(tr.toXML(document));
        test.appendChild(read);
        Element write = document.createElement("write");
        for(TestRow tr : this.write)
        	read.appendChild(tr.toXML(document));
        test.appendChild(write);
        crystal.appendChild(test);
        return crystal;
	}
	
	private static ArrayList<String> fromFileToArray(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String line;
		ArrayList<String> splitted = new ArrayList<>();
		while((line=reader.readLine()) != null) {
			splitted.add(line.replace((char) 0+"", "").trim());
			reader.readLine();
		}
		reader.close();
		return splitted;
	}
}
