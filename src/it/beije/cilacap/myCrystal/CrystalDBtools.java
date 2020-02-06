package it.beije.cilacap.myCrystal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CrystalDBtools {

	public static boolean checkInDB(TestData testData) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		Statement stmt = null;
		boolean returnValue = true;

		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);

			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cilacap.rubrica ");

			rs.getFetchSize();

			if(rs.getFetchSize() == 0) {
				returnValue = false;
			} else {
				returnValue = true;
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

		return returnValue;

	}

	public static List<TestData> readCrystalFromDB() throws ClassNotFoundException, SQLException {
		List<TestData> listaTestData = new ArrayList<TestData>();

		Connection connection = null;
		Statement stmt = null;

		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);

			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cilacap.testdata");

			TestData testData = null;
			while (rs.next()) {
				testData = new TestData();
				int id = rs.getInt("id");
				testData.setIdComputer(rs.getString("id_computer"));
				testData.setIntervalInSeconds(rs.getInt("intervall"));
				testData.setIterations(rs.getInt("iterations"));
				testData.setOs(rs.getString("os"));
				testData.setType(rs.getString("type"));
				testData.setVersion(rs.getString("version"));
				testData.setDate(rs.getString("date").trim());


				Statement readStmt = connection.createStatement();
				ResultSet readRs = readStmt.executeQuery("SELECT * FROM cilacap.test_row WHERE id_testdata = '" + id + "' AND mode_type = 'r'");
				List<TestRow> read = new ArrayList<TestRow>();


				while(readRs.next()) {
					TestRow testRowRead = new TestRow();
					testRowRead.setIops(readRs.getDouble("iops"));
					testRowRead.setMbs(readRs.getDouble("mbs"));
					testRowRead.setUs(readRs.getDouble("us"));
					testRowRead.setQ(readRs.getInt("q"));
					testRowRead.setT(readRs.getInt("t"));
					testRowRead.setType(readRs.getString("test_type"));
					read.add(testRowRead);
				}

				Statement writeStmt = null;
				writeStmt = connection.createStatement();
				ResultSet writeRs = writeStmt.executeQuery("SELECT * FROM cilacap.test_row WHERE id_testdata = '" + id + "' AND mode_type = 'w'");
				List<TestRow> write = new ArrayList<TestRow>();
				
				while(writeRs.next()) {
					TestRow testRowWrite = new TestRow();
					testRowWrite.setIops(writeRs.getDouble("iops"));
					testRowWrite.setMbs(writeRs.getDouble("mbs"));
					testRowWrite.setUs(writeRs.getDouble("us"));
					testRowWrite.setQ(writeRs.getInt("q"));
					testRowWrite.setT(writeRs.getInt("t"));
					testRowWrite.setType(writeRs.getString("test_type"));
					write.add(testRowWrite);
				}
				
				testData.setRead(read);
				testData.setWrite(write);	   
				
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

		return listaTestData;
	}

	public static boolean insertTestData(TestData testData) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		boolean esito = false;

		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);

			pstmt = connection.prepareStatement("INSERT INTO cilacap.testdata (id_computer,version,os,testdata.type,iterations,testdata.intervall,testdata.date) VALUES (?,?,?,?,?,?,?)");
			pstmt.setString(1, testData.getIdComputer());
			pstmt.setString(2, testData.getVersion());
			pstmt.setString(3, testData.getOs());
			pstmt.setString(4, testData.getType());
			pstmt.setInt(5, testData.getIterations());
			pstmt.setInt(6, testData.getIntervalInSeconds());
			pstmt.setString(7, testData.getDate());

			esito = pstmt.execute();

			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id FROM cilacap.testdata WHERE testdata.date = '" + testData.getDate() + "'");
			int id_testdata = 0;
			while (rs.next()) {
				id_testdata = rs.getInt("id");
			}

			// test Row read
			PreparedStatement pstmtRead = null;
			for(TestRow testRowRead : testData.getRead()) {
				pstmtRead = connection.prepareStatement("INSERT INTO cilacap.test_row (test_type,mode_type,q,t,mbs,iops,us,id_testdata) VALUES (?,?,?,?,?,?,?,?)");
				pstmtRead.setString(1,testRowRead.getType());
				pstmtRead.setString(2, "r");
				pstmtRead.setInt(3, testRowRead.getQ());
				pstmtRead.setInt(4, testRowRead.getT());
				pstmtRead.setDouble(5, testRowRead.getMbs());
				pstmtRead.setDouble(6, testRowRead.getIops());
				pstmtRead.setDouble(7, testRowRead.getUs());
				pstmtRead.setInt(8, id_testdata);

				pstmtRead.execute();
			}

			// test Row write
			PreparedStatement pstmtWrite = null;
			for(TestRow testRowWrite : testData.getWrite()) {
				pstmtWrite = connection.prepareStatement("INSERT INTO cilacap.test_row (test_type,mode_type,q,t,mbs,iops,us,id_testdata) VALUES (?,?,?,?,?,?,?,?)");
				pstmtWrite.setString(1,testRowWrite.getType());
				pstmtWrite.setString(2, "w");
				pstmtWrite.setInt(3, testRowWrite.getQ());
				pstmtWrite.setInt(4, testRowWrite.getT());
				pstmtWrite.setDouble(5, testRowWrite.getMbs());
				pstmtWrite.setDouble(6, testRowWrite.getIops());
				pstmtWrite.setDouble(7, testRowWrite.getUs());
				pstmtWrite.setInt(8, id_testdata);

				pstmtWrite.execute();
			}



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

}
