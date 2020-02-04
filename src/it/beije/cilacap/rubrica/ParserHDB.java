package it.beije.cilacap.rubrica;

import java.io.File;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

public class ParserHDB {
	
	public static List<Contatto> getContattiFromHDB() {
		Configuration configuration = new Configuration();
		configuration = configuration.configure().addAnnotatedClass(Contatto.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		List<Contatto> lista = new ArrayList<>();
		Query<Contatto> q = session.createQuery("SELECT * FROM Contatto");
		lista = q.list();
		session.close();
		return lista;
	}
	
	public static void writeContattiInHDB(List<Contatto> list) {
		Configuration configuration = new Configuration();
		configuration = configuration.configure().addAnnotatedClass(Contatto.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		for(Contatto c : list) {
			try {
				session.save(c);
				transaction.commit();
			}catch(ConstraintViolationException cve) {
				System.out.println("Contatto già presente");
				session.clear();
			}catch(Exception e) {}
		}
		session.close();
		factory.close();
	}

}
