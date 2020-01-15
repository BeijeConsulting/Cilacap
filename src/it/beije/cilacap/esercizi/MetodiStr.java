package it.beije.cilacap.esercizi;

public class MetodiStr {
	


	

	
	
public boolean myEndsWith(String str, String str2) {
	
	for(int a=str.length()-1;a>=str.length()-1;a--) {
		if(str.charAt(a)==str2.charAt(a)) {
			return true;
		}
	}
	return false;
	
	

		
		
	}
	
	public String myTrim(String str) {
		
		String c="";
		for(int i=0; i<str.length();i++) {
		if(str.charAt(i) == ' ') {
		    
			
		}
		}
		return c;
		
			
		}
		
	
	
	public String myReplace(String g,char oldChar, char newChar) {
		
		
		for(int i =0;i<g.length();i++) {
			if(oldChar != newChar) {
				oldChar=newChar;
			}
		}
		return g;
		
		
		
		
	}
	




	
	
		
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Metodi method=new Metodi();
		
		
		String nome="   Riccardo";
		String cognome="Riccardo";
		String nn=new String("Riccardo");
		
		System.out.println(method.myContains(cognome,"Riccar"));

		System.out.println(method.myStartsWith("foschi", "f"));
		
		System.out.println(method.mySubstring(cognome, 2, 5));
		
		System.out.println(method.myEndsWith("pino", "p"));

		
		System.out.println(method.myEquals(nn, cognome));
		
		nome=nome.trim();
		System.out.println(nome.length());
		System.out.println(nome.equals(cognome));
		System.out.println();
		System.out.println();

		System.out.println(nome);
		
		
		
		
		

	}

}
