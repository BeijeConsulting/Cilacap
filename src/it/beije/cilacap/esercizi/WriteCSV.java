package it.beije.cilacap.esercizi;
import it.beije.cilacap.rubrica.Contatto;

import java.util.ArrayList;
import java.util.List;




public class WriteCSV {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String separatore=";";
		Contatto rubrica=new Contatto();
		List <Contatto> contatto=new ArrayList<>();
        contatto=rubrica.scheletroCsv();
        rubrica.scrivisuFile(contatto, separatore);
		rubrica.settoFile();
		rubrica.fileXML();
		
		rubrica.scriviXml();

	}
}


		
		
	
		
	




