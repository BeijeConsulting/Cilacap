package it.beije.cilacap.crystal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBtools {

	public static List<TestData> leggiTestData() throws ClassNotFoundException, SQLException {
		List<TestData> listaTestData = new ArrayList<TestData>();
		
		Connection connection = null;
		Statement stmt = null;
		
		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
			
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cilacap.testdata JOIN cilacap.test_row ON id_testdata=id_computer");
			
			TestData testData= null;
			while (rs.next()) {
				testData = new TestData();
				testData.setIdComputer(rs.getInt("id_computer")); 
	        	testData.setDate(rs.getString("date"));
	        	testData.setIntervalInSeconds(rs.getInt("interval"));
	        	testData.setIterations(rs.getInt("iterations"));
	        	testData.setOs(rs.getString("os"));
	        	testData.setType(rs.getString("type"));
	        	testData.setVersion(rs.getString("version"));
	        	
	        	System.out.println("id = " + testData.getDate());
	        	System.out.println("nome = " + testData.getIdComputer());
	        	System.out.println("cognome = " + testData.getIntervalInSeconds());
	        	System.out.println("telefono = " + testData.getIterations());
	        	System.out.println("email = " + testData.getOs());
	        	System.out.println("email = " + testData.getType());
	        	System.out.println("email = " + testData.getVersion());

	        	
	        	listaTestData.add(testData);
			}
			
		} catch (SQLException sqlEx) {
			System.out.println("PROBLEMA : " + sqlEx);
			throw sqlEx;
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException finEx) {
				System.out.println("PROBLEMA : " + finEx);
			}
		}
		
		System.out.println("contatti letti : " + contatti.size());
		
		return contatti;
	}
	
	public static boolean insertTestData(TestData testData) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean esito = false;
		
		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);
			
//			StringBuilder insert = new StringBuilder("INSERT into cilacap.rubrica VALUES (null,")
//					.append('\'').append(contatto.getNome()).append("\',")
//					.append('\'').append(contatto.getCognome()).append("\',")
//					.append('\'').append(contatto.getTelefono()).append("\',")
//					.append('\'').append(contatto.getEmail()).append('t').append("\')");
//			System.out.println(insert.toString());
			
			//CE 20200302: inserimento test data in db
			pstmt = connection.prepareStatement("INSERT into cilacap.testdata (date,id_computer,testdata.interval,iterations,os,type,version) VALUES (?,?,?,?,?,?,?)");
			pstmt.setString(1, testData.getDate());
			pstmt.setString(2, testData.getIdComputer());
			pstmt.setInt(3, testData.getIntervalInSeconds());
			pstmt.setInt(4, (testData.getIterations()));
			pstmt.setString(5,testData.getOs());
			pstmt.setString(6,testData.getType());
			pstmt.setString(7,testData.getVersion());
			
			esito = pstmt.execute();
//			System.out.println(pstmt.getUpdateCount());
			
			//pstmt.executeUpdate();
			
			List <TestRow>listaRead=new ArrayList<TestRow>();
			listaRead=testData.getRead();
			
			for(int i=0; i<listaRead.size(); i++) {
				
				TestRow testRow= listaRead.get(i);
				pstmt = connection.prepareStatement("INSERT into cilacap.test_row (id_testdata,iops,mbs,mode_type,q,t,test_type,us) VALUES (?,?,?,?,?,?,?,?)");
				pstmt.setString(1, testData.getIdComputer());
				pstmt.setDouble(2, testRow.getIops());
				pstmt.setDouble(3, testRow.getMbs());
				pstmt.setString(4, testRow.getType());
				pstmt.setInt(5,testRow.getQ());
				pstmt.setInt(6,testRow.getT());
				pstmt.setString(7,"r");
				pstmt.setDouble(8,testRow.getUs());
				
				esito = pstmt.execute();

				
			}
			
			List <TestRow>listaWrite=new ArrayList<TestRow>();
			listaWrite=testData.getWrite();
			
			for(int i=0; i<listaRead.size(); i++) {
				
				TestRow testRow= listaWrite.get(i);
				pstmt = connection.prepareStatement("INSERT into cilacap.test_row (id_testdata,iops,mbs,mode_type,q,t,test_type,us) VALUES (?,?,?,?,?,?,?,?)");
				pstmt.setString(1, testData.getIdComputer());
				pstmt.setDouble(2, testRow.getIops());
				pstmt.setDouble(3, testRow.getMbs());
				pstmt.setString(4, testRow.getType());
				pstmt.setInt(5,testRow.getQ());
				pstmt.setInt(6,testRow.getT());
				pstmt.setString(7,"w");
				pstmt.setDouble(8,testRow.getUs());
				
				esito = pstmt.execute();

				
			}
			
			
//			
		} catch (SQLException sqlEx) {
			System.out.println("PROBLEMA : " + sqlEx);
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException finEx) {
				System.out.println("PROBLEMA : " + finEx);
			}
		}
		
		return esito;
	}
	
	public static void main(String[] args) {
		
		try {
			//insertContatto(leggiContatti().get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
