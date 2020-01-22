import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {
	static boolean vero = true;
	static boolean copia;
	static Scanner sc=new Scanner(System.in);

	static boolean IsExist(File a, String file) {
		a = new File(file);

		if (a.exists()) {
			vero = true;
			copia = vero;
		} else {
			vero = false;
			copia = false;
		}
		return copia;
	}
	
	static String writeCognome(String cognome) {
		while(cognome.equalsIgnoreCase(" ")) {
			System.out.println("Reinserisci il cognome");
			cognome=sc.next();
		}
		return cognome + "\n";
	}

	static String writeNome(String nome) {
		while(nome.equalsIgnoreCase(" ")) {
			System.out.println("Reinserisci il nome");
			nome=sc.next();
		}
		return nome +  "\n";
	}

	static String writemail(String email) {
		while(email.equalsIgnoreCase(" ")) {
			System.out.println("Reinserisci il email");
			email=sc.next();
		}
		return email +  "\n";
	}

	static String writenumero(String numero) {
		while(numero.equalsIgnoreCase(" ")) {
			System.out.println("Reinserisci il telefono");
			numero=sc.next();
		}
		return numero + "\n";
	}

	public static void main(String[] args) throws IOException {
		File file;
		String filePath = "csv/rubrica.txt";
		StringBuilder stringa = new StringBuilder();
		String risp;
		Scanner sc = new Scanner(System.in);
		if (IsExist(file = new File(filePath), filePath) == true) {
			
			System.out.print("Inserire cognome");
			String cognome = sc.next();
			System.out.print("Inserire nome");
			String nome = sc.next();
			System.out.print("Inserire telefono");
			String telefono = sc.next();
			System.out.print("Inserire email");
			String email = sc.next();
			FileWriter filewrite = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(filewrite);
			stringa.append(writeCognome(cognome));
			stringa.append(writeNome(nome));
			stringa.append(writemail(email));
			stringa.append(writenumero(telefono));
			bufferedWriter.append(stringa);
			System.out.print("Vuoi inserire altri contatti? S/N");
			risp=sc.next();
			while(!risp.equalsIgnoreCase("S")||!risp.equalsIgnoreCase("N")) {
				System.out.print("Vuoi inserire altri contatti? S/N");
				risp=sc.next();
			}
			if(risp.equalsIgnoreCase("S")) {
				System.out.print("Inserire cognome");
				 cognome = sc.next();
				System.out.print("Inserire nome");
				 nome = sc.next();
				System.out.print("Inserire telefono");
				 telefono = sc.next();
				System.out.print("Inserire email");
				 email = sc.next();
				stringa.append(writeCognome(cognome));
				stringa.append(writeNome(nome));
				stringa.append(writemail(email));
				stringa.append(writenumero(telefono));
				bufferedWriter.append(stringa);
			
			}else if(risp.equalsIgnoreCase("N")) {
				System.out.println("Ok chiudo.");
				bufferedWriter.flush();
				bufferedWriter.close();
			}

		
		} else {
			System.out.println("Impossibile trovare il file");
		}

	}
}
