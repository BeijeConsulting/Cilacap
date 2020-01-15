package it.beije.cilacap.esercizi;

public class MetodiString {
	
	public boolean myContains(String s, char c) { // OK
		for(int j = 0; j < s.length(); j++) {
			if(s.charAt(j) == c) {
				return true;
			}
		}
		return false;
		
		/*
		if(s.indexOf(c) != -1) return true;
		else return false;
		*/
	}
	
	public boolean myContains(String s, String ss) {
		
		// Solo con cahrAt()
		for(int i = 0; i <= s.length() - ss.length(); i++) {
			int counter = 0;
			if(s.charAt(i) == ss.charAt(counter)) {
				for(int j = counter; j < ss.length(); j++) {
					if(s.charAt(i + j) == ss.charAt(j)) {
						counter++;
					} else {
						break;
					}
				}
				if(counter == ss.length()) {
					return true;
				}
			}
		}
		return false;
		
		
		/*
		// con indexOf()
		if(s.indexOf(ss) != -1) {
			return true;
		} else {
			return false;
		}
		*/
	}

	
	public boolean myStartsWith(String s, String ss) { // OK
		for(int i = 0; i < ss.length(); i++) {
			if(s.charAt(i) != ss.charAt(i)) {
				return false;
			}
		}
		return true;
		
		/*
		if(s.indexOf(ss) == 0) {
			return true;
		} else {
			return false;
		}
		*/
	}
	
	public boolean myEndsWith(String s, String ss) { // OK
		int counter = 0;
		for(int i = s.length() - ss.length(); i < s.length(); i++) {
			if(s.charAt(i) != ss.charAt(counter)) {
				return false;
			}
			counter++;
		}
		return true;
		
		/*
		if(s.indexOf(ss) == s.length() - ss.lenght()) {
			return true;
		} else {
			return false;
		}
		*/
	}
	
	public String myTrim(String s) { // OK
		String newString = "";
		int startIndex = 0;
		int endIndex = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c != ' ' && c != '\t' && c != '\n' && c != '\r') {
				startIndex = i;
				break;
			}
		}
		for(int i = s.length()-1; i >= 0; i--) {
			char c = s.charAt(i);
			if(c != ' ' && c != '\t' && c != '\n' && c != '\r') {
				endIndex = i;
				break;
			}
		}
		for(int i = startIndex; i <= endIndex; i++) {
			newString += s.charAt(i);
		}
		return newString;
	}
	
	public boolean myEquals(String s, String ss) { // OK
		 // case sensitive
		if(s.length() == ss.length()) {
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) != ss.charAt(i)) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public String myReplace(String s, char oldChar, char newChar) { // OK
		String newStr = "";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == oldChar) {
				newStr+= newChar;
			} else {
				newStr += s.charAt(i);
			}
		}
		return newStr;
	}
	
	public String mySubString(String s, int startIndex, int endIndex) { // OK
		String newString = "";
		for(int i = startIndex; i < endIndex; i++) {
			newString += s.charAt(i);
		}
		return newString;
	}
	
	
	public String myReverse(String s) {
		String newStr = "";
		for(int i = s.length()-1; i >= 0; i--) {
			newStr += s.charAt(i);
		}
		return newStr;
	}

	public static void main(String[] args) {
		
		
		String s = "pippo";
		
		MetodiString ms = new MetodiString();
		
		// myContains
		System.out.println(ms.myContains(s, "po"));
		System.out.println(ms.myContains(s, "op"));
		
		// myTrim
		System.out.println(ms.myTrim("\n\n   \t \rpippo pluto  paperino \n\n\n\t\r"));
		
		// mySubstring
		System.out.println(ms.mySubString(s, 2, 4));
		
		// myReplace
		System.out.println(ms.myReplace(s, 'p', 'c'));
		System.out.println(ms.myReplace(s, 'a', 'c'));
		
		// myEquals
		System.out.println(ms.myEndsWith(s, "pippo"));
		
		// myStartswith
		System.out.println(ms.myStartsWith(s, "pi"));
		System.out.println(ms.myStartsWith(s, "c"));
		
		// myEndswith
		System.out.println(ms.myEndsWith(s, "po"));
		System.out.println(ms.myEndsWith(s, "ciao"));
		
		// reverse
		System.out.println(ms.myReverse(s));
		
	}

}
