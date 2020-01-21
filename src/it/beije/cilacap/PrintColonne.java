package it.beije.cilacap;

public class PrintColonne {

	
	public static void main(String[] args) {
		File f=new File("csv/rubrica1.csv");
		System.out.println("Il file è "+f.exist());
		FileReader fileReader=new FileReader(f);
		BufferedReader reader=new BufferedReader(fileReader);
		
	}
}
