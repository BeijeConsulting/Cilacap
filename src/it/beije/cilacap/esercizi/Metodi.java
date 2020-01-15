package it.beije.cilacap.esercizi;

public class Metodi {

	public boolean myContains(String str, String d) {
		if(str.indexOf(d) !=-1) {
			return true;
			
		}else {
			return false;
			}
		}
	

		/**int count=0;

		for(int a=0;a<=str.length();a++) {
			for(int i=0;i<=str.length();i++) {
				while(count<=str.length()) {
					if(str.charAt(i) == d.charAt(a)) {
						count++;
						return true;
					}else {
						count++;
						return false;
					}
				}
			}
		}
		return false;*/
	
	
	
	
	public String myReplace(String g,char oldChar, char newChar) {
		String c="";
		
		
		
		for(int i =0;i<g.length();i++) {
			
			}
			if(oldChar != newChar) {
				oldChar=newChar;
				
				c=g +=newChar;
				
			}
		
		return c;
	}
	
	
	
	public boolean myStartsWith(String str,String str2 ) {
		
		
		for (int a=0;a<str.length();a++) {
			
			if(str.charAt(0)==str2.charAt(0)) {
				return true;
			}else if(str.charAt(0)!=str2.charAt(0)){
				return false;
			}
			
		
	
}
		return false;
}	
	
public boolean myEquals(String str, String asd) {
            boolean b=false;
		
			if(str.charAt(0)==asd.charAt(0)) {
				for(int i=0;i<str.length();i++) {
					if(str.charAt(i) == asd.charAt(i))
					b= true;
			}
		
		}else {
			b= false;
		}
			return b;
}
	
	public boolean myEndsWith(String str, String str2) {
		boolean b=false;
		int c=0;
		for(int a=str.length()-str2.length();a<str.length()-1;a--) {
			if(str.charAt(a)!=str2.charAt(c)) {
				b=false;
			}else {
				b=true;
			}
			c++;
		}
		return b;
		
		

			
			
		}
	
	public String mySubstring(String str,int beginIndex, int endIndex) {
		String con="";
		for(int i=beginIndex;i<endIndex;i++) {
			con +=str.charAt(i);
		}
		return con;
		
		
	}
	
public String myTrim(String str) {
		int inzio=0;
		int fine=0;
		String c="";
		for(int i=0; i<str.length();i++) {
		if(str.charAt(i) == ' ') {
			
		   
			
		}
		}
		return c;
		
			
		}




}
