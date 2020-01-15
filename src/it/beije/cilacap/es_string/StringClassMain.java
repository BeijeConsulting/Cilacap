package it.beije.cilacap.es_string;

public class StringClassMain {

	public static void main(String[] args) {
		MyStringImm s = new MyStringImm(" \n  abcdeffk \r   \t   ");
		MyStringMut t = new MyStringMut("   abcdeffk  ");
		System.out.println(s);
		System.out.println("contiene la stringa?  "+s.myContains("t"));
		System.out.println("comincia con ?   "+s.myTrim().myStartsWith("a"));
		System.out.println("finisce con ?   "+s.myEndsWith("e"));
		System.out.println("è uguale? "+s.myEquals("abcdef"));
		System.out.println(s.mySubstring(7, 20));
		System.out.print(s.myTrim());System.out.println("[verifica]");
		System.out.println(s.myReplace('c', 'k'));
		System.out.println(s.myTrim().myReplace('d', 't'));
		t.mySubstring(2, 7);
		System.out.println(t);
	}
	
	

}