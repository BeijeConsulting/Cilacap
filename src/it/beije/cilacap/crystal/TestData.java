package it.beije.cilacap.crystal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
@Table(name="testdata")
public class TestData {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="id_computer")
	private String idComputer;
	
	@Column(name="version")
	private String version;
	
	@Column(name="os")
	private String os;
	
	@Column(name="type")
	private String type;
	
	@Column(name="iterations")
	private int iterations;
	
	@Column(name="intervall")
	private String intervalInSeconds;
	
	@Column(name="date")
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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIntervalInSeconds() {
		return intervalInSeconds;
	}
	public void setIntervalInSeconds(String intervalInSeconds) {
		this.intervalInSeconds = intervalInSeconds;
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
		return intervalInSeconds;
	}
	public void setInterval(String string) {
		this.intervalInSeconds = string;
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
	
	public static void InserisciInDB(TestData Test) throws ClassNotFoundException{
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = DBManagerCrystal.getMySqlConnection(DBManagerCrystal.DB_URL, DBManagerCrystal.DB_USER, DBManagerCrystal.DB_PASSWORD);
			stmt = connection.prepareStatement("INSERT into cilacap.testdata (id_computer,version,os,type,iterations,testdata.interval,date) VALUES (?,?,?,?,?,?,?)");
			stmt.setString(1, Test.getIdComputer());
			stmt.setString(2, Test.getVersion());
			stmt.setString(3, Test.getOs());
			stmt.setString(4, Test.getType());
			stmt.setInt(5, Test.getIterations());
			stmt.setString(6, Test.getInterval());
			stmt.setString(7, Test.getDate());
			
			stmt.execute();
		}catch (SQLException sqlEx) {
			System.out.println("PROBLEMA : " + sqlEx);
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException finEx) {
				System.out.println("PROBLEMA : " + finEx);
			}
		}		
	}
	
	
	public static void InserisciReadWrite (TestData Test) throws ClassNotFoundException{
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement stmt2 = null;
		
		try {
			connection = DBManagerCrystal.getMySqlConnection(DBManagerCrystal.DB_URL, DBManagerCrystal.DB_USER, DBManagerCrystal.DB_PASSWORD);
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id FROM cilacap.testdata where date='"+Test.getDate()+"'");
			rs.next();
			int id_testdata = rs.getInt("id");
			for(int i=0;i<Test.getRead().size();i++) {
				stmt2 = connection.prepareStatement("INSERT into cilacap.test_row (test_type,mood_type,q,t,mbs,iops,us,id_testdata) VALUES (?,?,?,?,?,?,?,?)");
				stmt2.setString(1, Test.getRead().get(i).getType());
				stmt2.setString(2, "r");
				stmt2.setInt(3,Test.getRead().get(i).getQ());
				stmt2.setInt(4,Test.getRead().get(i).getT());
				stmt2.setDouble(5, Test.getRead().get(i).getMbs());
				stmt2.setDouble(6, Test.getRead().get(i).getIops());
				stmt2.setDouble(7,Test.getRead().get(i).getUs());
				stmt2.setInt(8,id_testdata );
				stmt2.execute();
			}
			for(int i=0;i<Test.getWrite().size();i++) {
				stmt2 = connection.prepareStatement("INSERT into cilacap.test_row (test_type,mood_type,q,t,mbs,iops,us,id_testdata) VALUES (?,?,?,?,?,?,?,?)");
				stmt2.setString(1, Test.getWrite().get(i).getType());
				stmt2.setString(2, "w");
				stmt2.setInt(3,Test.getWrite().get(i).getQ());
				stmt2.setInt(4,Test.getWrite().get(i).getT());
				stmt2.setDouble(5, Test.getWrite().get(i).getMbs());
				stmt2.setDouble(6, Test.getWrite().get(i).getIops());
				stmt2.setDouble(7,Test.getWrite().get(i).getUs());
				stmt2.setInt(8,id_testdata );
				stmt2.execute();
			}
			
		}catch (SQLException sqlEx) {
			System.out.println("PROBLEMA : " + sqlEx);
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException finEx) {
				System.out.println("PROBLEMA : " + finEx);
			}
		}	
		
		
	}
	
	
	
	
	
	
}
