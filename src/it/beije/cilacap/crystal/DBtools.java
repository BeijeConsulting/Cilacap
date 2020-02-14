package it.beije.cilacap.crystal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
//import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.beije.cilacap.crystal.DBManager;

public class DBtools {

	public static TestData leggiTestDataJDBC() throws ClassNotFoundException, SQLException {

		TestData testData = null;

		Connection connection = null;
		Statement stmt = null;

		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);

			stmt = connection.createStatement();
			// CE 20200602: lo statement probabilmente � unico, e viene sovrascritto se
			// utilizzo lo stesso
			Statement stmt2 = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cilacap.testdata ");
			while (rs.next()) {
				int i = 0;
				System.out.println(i);
				i++;
				testData = new TestData();
				testData.setIdComputer(rs.getString("id_computer"));
				testData.setDate(rs.getString("date"));
				testData.setIntervalInSeconds(rs.getInt("interval"));
				testData.setIterations(rs.getInt("iterations"));
				testData.setOs(rs.getString("os"));
				testData.setType(rs.getString("type"));
				testData.setVersion(rs.getString("version"));

				ResultSet row = stmt2.executeQuery(
						"SELECT * FROM cilacap.test_row, cilacap.testdata WHERE testdata.id_computer = test_row.id_testdata");

				TestRow testRow = null;
				List<TestRow> listRead = new ArrayList<TestRow>();
				List<TestRow> listWrite = new ArrayList<TestRow>();

				while (row.next()) {
					testRow = new TestRow();
					testRow.setIdTestData(row.getString("id_testdata"));
					testRow.setIops(row.getDouble("iops"));
					testRow.setMbs(row.getDouble("mbs"));
					testRow.setQ(row.getInt("q"));
					testRow.setT(row.getInt("t"));
					testRow.setType(row.getString("mode_type"));
					testRow.setUs(row.getDouble("us"));

					if (row.getString("test_type").equalsIgnoreCase("r"))
						listRead.add(testRow);
					else
						listWrite.add(testRow);
				}

				testData.setRead(listRead);
				testData.setWrite(listWrite);
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

		return testData;
	}

	public static boolean insertTestDataJDBC(TestData testData) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean esito = false;

		try {
			connection = DBManager.getMySqlConnection(DBManager.DB_URL, DBManager.DB_USER, DBManager.DB_PASSWORD);

			// CE 20200302: inserimento test data in db
			pstmt = connection.prepareStatement(
					"INSERT into cilacap.testdata (date,id_computer,testdata.interval,iterations,os,type,version) VALUES (?,?,?,?,?,?,?)");
			pstmt.setString(1, testData.getDate());
			pstmt.setString(2, testData.getIdComputer());
			pstmt.setInt(3, testData.getIntervalInSeconds());
			pstmt.setInt(4, (testData.getIterations()));
			pstmt.setString(5, testData.getOs());
			pstmt.setString(6, testData.getType());
			pstmt.setString(7, testData.getVersion());

			esito = pstmt.execute();

			List<TestRow> listaRead = new ArrayList<TestRow>();
			listaRead = testData.getRead();

			for (int i = 0; i < listaRead.size(); i++) {

				TestRow testRow = listaRead.get(i);
				pstmt = connection.prepareStatement(
						"INSERT into cilacap.test_row (id_testdata,iops,mbs,mode_type,q,t,test_type,us) VALUES (?,?,?,?,?,?,?,?)");
				pstmt.setString(1, testData.getIdComputer());
				pstmt.setDouble(2, testRow.getIops());
				pstmt.setDouble(3, testRow.getMbs());
				pstmt.setString(4, testRow.getType());
				pstmt.setInt(5, testRow.getQ());
				pstmt.setInt(6, testRow.getT());
				pstmt.setString(7, "r");
				pstmt.setDouble(8, testRow.getUs());

				esito = pstmt.execute();

			}

			List<TestRow> listaWrite = new ArrayList<TestRow>();
			listaWrite = testData.getWrite();

			for (int i = 0; i < listaWrite.size(); i++) {

				TestRow testRow = listaWrite.get(i);
				pstmt = connection.prepareStatement(
						"INSERT into cilacap.test_row (id_testdata,iops,mbs,mode_type,q,t,test_type,us) VALUES (?,?,?,?,?,?,?,?)");
				pstmt.setString(1, testData.getIdComputer());
				pstmt.setDouble(2, testRow.getIops());
				pstmt.setDouble(3, testRow.getMbs());
				pstmt.setString(4, testRow.getType());
				pstmt.setInt(5, testRow.getQ());
				pstmt.setInt(6, testRow.getT());
				pstmt.setString(7, "w");
				pstmt.setDouble(8, testRow.getUs());

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

	public static List<TestData> leggiTestDataHibernate() {
		Configuration configuration = DBManager.getHibernateConfiguration();
//		Configuration configurationTestRow = DBManager.getHibernateConfigurationTestRow();

		SessionFactory factory = configuration.buildSessionFactory();
//		SessionFactory factoryTestRow = configurationTestRow.buildSessionFactory();

		Session session = factory.openSession();
//		System.out.println("is open? " + factory.isOpen());
//		Session sessionTestRow = factoryTestRow.openSession();

		String hql = "SELECT c FROM TestData as c ";
		List<TestData> listaTestData = new ArrayList<TestData>();
		@SuppressWarnings("unchecked")
		Query<TestData> queryTestData = session.createQuery(hql);
//		System.out.println(queryTestData.list());

		int i = 0;

		for (TestData testData : queryTestData.list()) {
			System.out.println(i++);
			TestData testDataCrystal = testData;

			hql = "SELECT t FROM TestRow as t WHERE  type='r'";
			Query<TestRow> queryTestRow = session.createQuery(hql);
			List<TestRow> listaTestRow = new ArrayList<TestRow>();
			int j = 0;
			System.out.println(queryTestRow.list());
			System.out.println(queryTestData.list());
			for (TestRow testRow : queryTestRow.list()) {
				if (testRow.getIdTestData().equalsIgnoreCase(testDataCrystal.getIdComputer())) {
					System.out.println(j++);
					listaTestRow.add(testRow);
				}
			}
			testDataCrystal.setRead(listaTestRow);

			hql = "SELECT t FROM TestRow as t WHERE type='w'";
			queryTestRow = session.createQuery(hql);
			listaTestRow = new ArrayList<TestRow>();
			j = 0;

			for (TestRow testRow : queryTestRow.list()) {
				if (testRow.getIdTestData().equalsIgnoreCase(testDataCrystal.getIdComputer())) {
					System.out.println(j++);
					listaTestRow.add(testRow);
				}
			}
			testDataCrystal.setWrite(listaTestRow);

			listaTestData.add(testDataCrystal);

		}
		return listaTestData;

	}

	public static void scriviTestDataHibernate(TestData testData) throws SecurityException, RollbackException,
			HeuristicMixedException, HeuristicRollbackException, SystemException {

		Configuration configuration = DBManager.getHibernateConfiguration();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(testData);
		transaction.commit();
		session.close();
		System.out.println("fatto");

	}

	public static void insertTestDataJPA(TestData testData) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(testData);

		for (int i = 0; i < testData.getRead().size(); i++)
			entityManager.persist(testData.getRead().get(i));

		for (int i = 0; i < testData.getWrite().size(); i++)
			entityManager.persist(testData.getRead().get(i));

		entityManager.close();
	}
}