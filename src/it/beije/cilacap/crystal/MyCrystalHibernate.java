package it.beije.cilacap.crystal;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.beije.cilacap.rubrica.DBManager;

public class MyCrystalHibernate {

	@SuppressWarnings("unchecked")
	public static List<TestData> leggiTests() throws HibernateException, ClassNotFoundException { // preleva da DB tutti i contatti. [Hibernate]

		Configuration configuration = DBManager.getHibernateConfigurationCrystal();

		SessionFactory factory = configuration.buildSessionFactory();

		// query HQL		
		String hql1 = "SELECT t FROM TestData as t";
		// apro una sessione
		Session session = factory.openSession();
		
		Query<TestData> query = session.createQuery(hql1);
		List<TestData> listaTests = query.list();
		
		for (TestData test:listaTests) {
			
			Query<TestRow> queryRead = session.createQuery("SELECT t FROM TestRow as t WHERE type = 'r' AND idTestData='"+ test.getIdComputer() +"'");
			test.setRead(queryRead.list());
			
			Query<TestRow> queryWrite = session.createQuery("SELECT t FROM TestRow as t WHERE type = 'w' AND idTestData='"+ test.getIdComputer() +"'");
			test.setWrite(queryWrite.list());
		}
		
		
		return listaTests;
	}

}
