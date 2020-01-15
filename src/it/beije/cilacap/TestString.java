package it.beije.cilacap;

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    TestString ms = new TestString();
	String prova = "bellaziobella";
	String buona = new String();
	boolean provina = ms.Mycontains(prova,"bella");
	
	System.out.println(provina);
	buona = ms.Reverse(prova);
	System.out.println(buona);
	
		
		
		
		
	}
	
	public boolean Mycontains(String s,String s1) {
		int j=0;
		int controllo=0;
		for(int i=0;i<s.length();) {
			if(s.charAt(i)==s1.charAt(j)) {
				j++;
				i++;
				if(j==s1.length()) {
					return true;
				}
			}else {
				if(controllo==1) {
					i++;
					controllo=0;
				}else {
					j=0;
					controllo=1;
				}
			}	
		}
		return  false;
	}
	
	public boolean MyStartWhit(String s,String s1) {
		if(s.indexOf(s1,0)!=-1) {
			return true;
		}else return false;	
	}
	
	public boolean MyEndWhit(String s,String s1) {
		int we = s.length() - s1.length();
		if(s.indexOf(s1,we)!=-1) {
			return true;
		}else return false;
		
	}
	
	public boolean MyEquals(String s,String s1) {
		if(s.length()==s1.length()) {
			for(int i=0;i<s1.length();i++) {
				if(s.charAt(i)!=s1.charAt(i)) {
					return false;
				}
			}
			return false;
		}
		return false;
	}
	
	public String Myreplace(String parola,char s1,char s2) {
		String nuova = new String();
		for(int i=0;i<parola.length();i++) {
			if(parola.charAt(i)==s1) {
				nuova+=s2;
			}else {
				nuova+=parola.charAt(i);
			}
		}
		return nuova;	
	}
	
	public String MySubString(String s,int startIndex,int endIndex) {
		String buona = new String();
		for(int i=startIndex;i<endIndex;i++) {
			buona += s.charAt(i);
		}
		return buona;	
	}
	
	public String Reverse(String s) {
		String nuova = new String();
		for(int i=s.length()-1;i>=0;i--)
			nuova += s.charAt(i);
		return nuova;
	}
	
	public String MyTrim(String s) {
		String buona = new String();
		int capo=0, coda = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!=' ') {
				capo = i;
				break;
			}
		}
		for(int i=s.length()-1;i>=0;i--) {
			if(s.charAt(i)!=' ') {
				coda=i;
				break;
			}
		}
		for(int i=capo;i<=coda;i++) {
			buona+=s.charAt(i);
		}
		return buona;	
	}

}
