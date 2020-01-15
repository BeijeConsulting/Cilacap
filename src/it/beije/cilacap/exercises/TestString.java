package it.beije.cilacap.exercises;

public class TestString {
	
	static boolean MyContains(String s) {
		String contains = "MyContains string";
		//System.out.println(contains.indexOf("x"));
		if (contains.indexOf(s) != -1) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	static boolean MyStartsWith(char s) {
		String startsWith = "MyStartWith string";
		if (startsWith.charAt(0) == s) {
			return true;
		}
		
		else {
			return false;
		}	
	}
	
	static boolean MyEndsWith(char s) {
		String endsWith = "MyEndsWith string";
		if (endsWith.charAt(endsWith.length() - 1) == s) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	
	/* static String MyTrim() {
		String trim = "  MyTrim string  ";
		String newtrim = "";
		if (trim.charAt(0) == ' ') {
			for (int i = 0; i < trim.length() - 1; i++) {
				newtrim = newtrim + trim.charAt(i+1);
			}
		}
		
		/* (trim.charAt(trim.length() - 1) == ' ') {
			newtrim.charAt(newtrim.length() - 1) = trim.charAt(trim.length() - 1);
		}
		
		return newtrim;
	}*/
	
	static boolean MyEquals(String s) {
		String equals = "MyEquals string";
		int j = 0;
		
		for (int i = 0; i < equals.length() - 1; i++) {
			if (equals.charAt(i) == s.charAt(i) ) {
				j++;
			}
		}
			if (j == equals.length() - 1 && j == s.length()-1) {
				return true;
			}
			else {
				return false;
			}	
	}
	
	static String MySubstring(int startIndex, int endIndex) {
		String substring = "MySubstring string";
		String newSubstring = "";
		int startI = startIndex;
		int endI = endIndex;
		
		if (startI > endI) {
			return null;
		}
		
		for (int i = 0; i < substring.length() - 1; i++) {
			//char cursor = substring.charAt(i); 
			while (startI >= substring.indexOf(substring.charAt(i)) && endI <= substring.indexOf(substring.charAt(i))) {
				newSubstring += substring.charAt(i);
			}
		}
		return newSubstring;
	} 
	
	static String MyReplace(char oldChar, char newChar) {
		String replace = "MyReplace string";
		String newreplace = "";
		char newcharacter = newChar;
		char oldcharacter = oldChar;

		for (int i = 0; i < replace.length(); i++) {
			
			if (replace.charAt(i) == oldcharacter) {
				newreplace += newcharacter;
			}
			else {
				newreplace += replace.charAt(i);
			}
		}
		return newreplace;
	}
	
	
	public static void main(String[] args) {
		/*String test = "This is a test";
		System.out.println(test.length());
		System.out.println(test.charAt(3));
		System.out.println(test.indexOf("is"));
		System.out.println(test.substring(10));
		System.out.println(test.substring(0, 4));
		System.out.println(test.toLowerCase());
		System.out.println(test.toUpperCase());
		System.out.println("This is not a test".equals("This is a test"));
		System.out.println("This Is A Test".equalsIgnoreCase("This is a test"));
		System.out.println("This is a test".startsWith("T"));
		System.out.println("This is a test".endsWith("t"));
		System.out.println(test.contains("x"));
		System.out.println(test.replace(" ", ""));
		System.out.println(test.trim()); */
		
		/*System.out.println(MyContains("a"));
		System.out.println(MyContains("x"));
		System.out.println(MyContains(" "));
		
		System.out.println(MyStartsWith('M'));
		System.out.println(MyStartsWith('N'));
		
		System.out.println(MyEndsWith('g'));
		System.out.println(MyEndsWith('h'));
		
		System.out.println(MyEquals("MyEquals string"));
		System.out.println(MyEquals("MyEquals strings"));
		System.out.println(MyEquals("MyEquals string "));
		System.out.println(MyEquals("MYEquals string"));*/
		
		System.out.println(MyReplace('M', 'F'));
		System.out.println(MyReplace('y', 'u'));
		System.out.println(MyReplace(' ', 'X'));
		//System.out.println(MySubstring(0, 5));
	}

}
