package it.beije.cilacap.esercizi;

public class Metodi {

	public boolean myContains(String str, String d) {       //MYCONTAINS
		if(str.indexOf(d) !=-1) {
			return true;

		}else {
			return false;
		}
	}




	public String myReplace(String g,char oldChar, char newChar) {        //MYREPLACE
		String c="";

		for(int i =0;i<g.length();i++) {
			if(g.charAt(i)==oldChar) {
				c +=newChar;
			}else {
				c +=g.charAt(i);

			}
		}

		return c;
	}



	public boolean myStartsWith(String str,String str2 ) {        //MYSTARTSWIH


		for (int a=0;a<str.length();a++) {

			if(str.charAt(0)==str2.charAt(0)) {
				return true;
			}else if(str.charAt(0)!=str2.charAt(0)){
				return false;
			}



		}
		return false;
	}	

	public boolean myEquals(String str, String asd) {           //EQUALS
		boolean b=false;

		if(str.length()==asd.length()) {
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i) == asd.charAt(i))
					b= true;
			}

		}else {
			b= false;
		}
		return b;
	}

	public boolean myEndsWith(String str, String str2) {       //MYENDSWITH
		boolean b=false;
		int c=0;
		for(int a=str.length()-str2.length();a<str.length()-1;a--) {
			if(str.charAt(a)!=str2.charAt(c)) {
				b=true;
			}else {
				b=false;
			}
			c++;
		}
		return b;





	}

	public String mySubstring(String str,int beginIndex, int endIndex) {        //MYSUBSTRING
		String con="";
		for(int i=beginIndex;i<endIndex;i++) {
			con +=str.charAt(i);
		}
		return con;


	}

	public String myTrim(String str) {     //MYTRIM
		
		int inizio=0;
		int fine=0;
		String d="";

		for(int i=0; i<str.length();i++) {
			char carattere=str.charAt(i);
			if(carattere !=  ' ') {
				inizio=i;
				
				break;
			}
		}
		for(int i=str.length()-1;i>=str.length()-1;i--) {
			char carattere=str.charAt(i);
			if(carattere!=  ' ') {
				fine=i;
				
				break;
			}
		}
		for(int i=inizio; i<=fine;i++) {

			d+=str.charAt(i);
		}


		return d;
	}




	public String myReverse(String s) {          //MYREVERSE
		String c="";
		for(int a=s.length()-1;a>=0;a--) {
			c +=s.charAt(a);
       }
		return c;
	}



}




