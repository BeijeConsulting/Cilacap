package it.beije.cilacap.crystal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import it.beije.cilacap.rubrica.Contatto;
import it.beije.cilacap.rubrica.DBManager;

public class MyCrystalHibernate {
	
	@SuppressWarnings("unchecked")
	public static List<TestData> leggiTests() { // preleva da DB tutti i contatti. [Hibernate]

		Configuration configuration = DBManager.getHibernateConfiguration();
		SessionFactory factory = configuration.buildSessionFactory();

		// query HQL
		String hql = "SELECT t FROM testdata as t";
		// apro una sessione
		Session session = factory.openSession();

		Query<TestData> query = session.createQuery(hql);
		List<TestData> listaTests = query.list();
		System.out.println(listaTests);
		return listaTests;
	}
	
	

}
