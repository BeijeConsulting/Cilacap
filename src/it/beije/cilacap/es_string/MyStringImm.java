package it.beije.cilacap.es_string;

public class MyStringImm {
	
	private String string;
	
	public MyStringImm(String string) {
		this.string = string;
	}
	
	public String toString() {
		return string;
	}
	
	public boolean myContains(String contenuta) {
		if ( string.indexOf(contenuta) >= 0 ) return true;
		else return false;
	}
	
	public boolean myStartsWith(String begin) {
		if ( string.indexOf(begin) == 0 ) return true;
		else return false;
	}
	
	public boolean myEndsWith(String end) {
		if ( string.indexOf(end) == string.length()-end.length() ) return true;
		else return false;
	}
	
	public MyStringImm myTrim() {	
		int i, j;
		for( i=0; i<string.length() && string.charAt(i)==' '; i++);
		for( j=string.length()-1; j>=0 && string.charAt(j)==' '; j--);
		return mySubstring(i, ++j);
	}
	
	public MyStringImm myReplace(char oldC, char newC) {
		String rep = "";
		for ( int i=0; i<string.length(); i++ ) {
			if ( string.charAt(i) == oldC ) rep += newC;
			else rep += string.charAt(i);
		}
		return new MyStringImm(rep);
	}
	
	public boolean myEquals(String s) {
		if ( s.length() != string.length() ) return false;
		for( int i = 0; i<s.length(); i++) {
			if( s.charAt(i) != string.charAt(i) ) return false;
		}
		return true;
	}
	
	public MyStringImm mySubstring(int start, int end) {
		String s="";
		if ( start > end || end > string.length() ) return null;
		for( int i = start; i<end; i++) s+=string.charAt(i);
		return new MyStringImm(s);
	}
	
	public MyStringImm myReverse() {
		String s = "";
		for (int i=string.length()-1; i>=0; i--) s+=string.charAt(i);
		return new MyStringImm(s);
	}
}
