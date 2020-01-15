package it.beije.cilacap;

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    TestString ms = new TestString();
	String prova = "bellaziobella";
	
	boolean provina = ms.Mycontains(prova,"bella");
	
	System.out.println(provina);
		
		
		
		
		
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

		return false;
		
	}
	public boolean MyEndWhit(String s) {
		return false;
		
	}
	public String MyTrim(String s) {
		return s;
		
		
	}
	public boolean MyEquals(String s) {
		return false;
		
	}
	public String Myreplace(String s) {
		return s;
		
	}
	
	public String MySubString(int startIndex,int endIndex) {
		return null;
	
		
	}

}
