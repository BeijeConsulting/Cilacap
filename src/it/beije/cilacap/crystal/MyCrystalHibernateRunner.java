package it.beije.cilacap.crystal;

import java.util.List;

import org.hibernate.HibernateException;

public class MyCrystalHibernateRunner {

	public static void main(String[] args) {

		try {
			List<TestData> listaTests = MyCrystalHibernate.leggiTests();
			for(TestData test : listaTests)
				System.out.println(test);
			
		
			
		} catch (HibernateException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
