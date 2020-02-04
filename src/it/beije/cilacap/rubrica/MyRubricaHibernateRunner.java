package it.beije.cilacap.rubrica;


public class MyRubricaHibernateRunner {

	public static void main(String[] args) throws Exception {

//		List<Contatto> listaContatti = MyRubricaHibernate.leggiContatti();
//		Utility.visualizzaRubrica(listaContatti);
//		MyRubricaHibernate.writeInDBFromCSV();
//		MyRubricaHibernate.readFromDBWriteInCSV();
//		MyRubricaHibernate.readFromDBWriteInXML();
		MyRubricaHibernate.writeInDBFromXML();
		
	}

}
