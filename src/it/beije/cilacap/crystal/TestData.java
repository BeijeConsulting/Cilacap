package it.beije.cilacap.crystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.annotations.Where;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javassist.expr.NewArray;


@Entity
@Table(name="testdata")
public class TestData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="id_computer")
	private String idComputer; 
	
	@Column(name="versionData")
	private String version; 
	
	@Column(name="osData")
	private String os;  
	
	@Column(name="typeData")
	private String type;
	
	@Column(name="iterationsData")
	private int iterations;
	
	@Column(name="intervalData")
	private int intervalInSeconds;
	
	@Column(name="dateData")
	private LocalDateTime date;
	
	@OneToMany(targetEntity=TestRow.class, cascade= CascadeType.ALL)
	@Where(clause="test_type='r'")
	@JoinColumn(name="testdata_id")
	private List<TestRow> read = new ArrayList<TestRow>();
	
	@OneToMany(targetEntity=TestRow.class, cascade= CascadeType.ALL)
	@Where(clause="test_type='w'")
	private List<TestRow> write = new ArrayList<TestRow>();

	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd H:mm:ss");
	private static final String regexVersion = "CrystalDiskMark[ ][0-9]+[\\.][0-9]+[\\.][0-9][ ]+[x][0-9]+[ ]\\(C\\)"; 
	private static final String regexOs = "([ ]+)?OS:[ ]+";
	private static final String regexTypeIterInt = "([ ]+)?Test:[ ]+";
	private static final String regexDate = "([ ]+)?Date:[ ]+";
	@Transient
	ArrayList<ArrayList<String>> strRead = new ArrayList<>();
	@Transient
	ArrayList<ArrayList<String>> strWrite = new ArrayList<>();
	
	public TestData(File file) throws IOException {
		String pathFile = file.getAbsolutePath().toString();
		System.out.println("Elaboro il file: "+ pathFile);
		String backSlashPattern = Pattern.quote(System.getProperty("file.separator"));
		idComputer = pathFile.split("crystal"+backSlashPattern)[1].split(backSlashPattern)[0];
		String pathDestination = pathFile.split(idComputer+backSlashPattern)[0]+"XML\\"+idComputer+"\\"+file.getName().replace(".txt", ".xml"); 
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
				String presplit = s.split("sec\\]")[0].split("Test:")[1].trim();
				this.type=presplit.split("\\(")[0].trim();
				this.iterations=Integer.parseInt(presplit.split("\\)")[0].split("\\(x")[1]);
				this.intervalInSeconds=Integer.parseInt(presplit.split("Interval:")[1].trim());
			}
		//ricerca data
			else if(Pattern.compile(regexDate).matcher(s).find())
				this.date=LocalDateTime.parse(s.split("ate: ")[1].trim(), formatter);
		//crea testRow read e testRow write
			else if(s.equals("[Read]")) {
				int j=0;
				ArrayList<String> tempR = new ArrayList<>();
				for(j=i+1; j<splitted.size()&&!splitted.get(j).equals(""); j++) {
					tempR.add(splitted.get(j));
				}
				strRead.add(tempR);
			}
			else if(s.equals("[Write]")) {
				int j=0;
				ArrayList<String> tempW = new ArrayList<>();
				for(j=i+1; j<splitted.size()&&!splitted.get(j).equals(""); j++) {
					tempW.add(splitted.get(j));
				}
				strRead.add(tempW);
			}
		}
	}
	
	public void addRW() {
		for(ArrayList<String> arrRead : strRead) {
			for(String sRead : arrRead) read.add(new TestRow(sRead, "r", id));
		}
		for(ArrayList<String> arrWrite : strWrite) {
			for(String sWrite : arrWrite) write.add(new TestRow(sWrite, "w", id));
		}
	}
	
	public static void createTestDataJPDB(File file, EntityManager em) throws IOException {
		TestData test = new TestData(file);
		em.getTransaction().begin();
		em.persist(test);
		test.addRW();
		em.persist(test);
		em.getTransaction().commit();
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
	
	public int getIntervalInSeconds() {
		return intervalInSeconds;
	}
	public void setInterval(int intervalInSeconds) {
		this.intervalInSeconds = intervalInSeconds;
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
	
	public void toDB(Connection conn) throws SQLException {
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO testdata (id_computer, versionData, osData, typeData, iterationsData, intervalData, dateData) "
					+ "VALUES ('"+idComputer+"','"+version+"','"+os+"','"+type+"',"+iterations+","+intervalInSeconds+",'"+java.sql.Date.valueOf(date.toLocalDate())+"')");
			ps.execute();
			ResultSet rId = conn.createStatement().executeQuery("SELECT id FROM testdata WHERE id=LAST_INSERT_ID()");
			rId.next();
			int id = rId.getInt(1); 
			for(TestRow tr : read) tr.toDB(conn, id, "r");
			for(TestRow tr : write) tr.toDB(conn, id, "r");
		}catch(NullPointerException e) {
			System.out.println("File non valido");
		}
	}
	
	public Element toXML(Document document) throws ParserConfigurationException {
        Element crystal = document.createElement("CrystalDiskMark");
        Element test = document.createElement("test");
        test.setAttribute("date", date.format(formatter));
        test.setAttribute("interval", intervalInSeconds+"");
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
