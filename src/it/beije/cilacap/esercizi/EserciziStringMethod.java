package it.beije.cilacap.esercizi;

public class EserciziStringMethod {

	private String s1;
	
	public String toString() {
		return s1;
	}

	public EserciziStringMethod(String s) {
		s1 = s;
	}

	public boolean myContains(String s) {
		boolean response = false;
		if (s1.indexOf(s) != -1)
			response = true;
		else
			response = false;
		return response;
	}

	public boolean myStartsWith(String prefix) {
		boolean response = false;
		if (s1.indexOf(prefix, 0) != -1)
			response = true;
		else
			response = false;
		return response;
	}

	public boolean myEndsWith(String suffix) {
		boolean response = false;
		if (s1.indexOf(suffix, ((s1.length() - suffix.length()) - 1)) != -1)
			response = true;
		else
			response = false;
		return response;
	}

	public EserciziStringMethod myTrim() {
		int firstLetter = 0;
		int lastLetter = 0;
		
		forFirstLetter: 
		for (int i = 0; i < s1.length(); i++) {
			if ((s1.charAt(i) != ' ') && (s1.charAt(i) != '\t') && (s1.charAt(i) != '\n') && (s1.charAt(i) != '\r')) {
				firstLetter = i;
				break forFirstLetter;
			}
		}
		forLastLetter:
		for (int x = (s1.length() - 1); x >= 0; x--) {
			if ((s1.charAt(x) != ' ') && (s1.charAt(x) != '\t') && (s1.charAt(x) != '\n') && (s1.charAt(x) != '\r')) {
				lastLetter = x;
				break forLastLetter;
			}
		}
		return this.mySubString(firstLetter + 1, lastLetter + 2);
	}

	public boolean myEquals(String s) {
		boolean response = false;
		/*s1 = s1.replace(" ", "a");
		s1 = s1.replace("\r", "a");
		s1 = s1.replace("\n ", "a");
		s1 = s1.replace("\t", "a");
		s = s.replace(" ", "a");
		s = s.replace("\r", "a");
		s = s.replace("\n ", "a");
		s = s.replace("\t", "a");*/
		System.out.println(s1);
		System.out.println(s);
		if ((s.length() - s1.length()) != 0)
			response = false;
		else {
			forEquals:
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s.charAt(i)) {
					response = false;
					break forEquals;
				}
				else {
					response = true;
					continue forEquals;
				}
			}
		}
		return response;
	}

	public EserciziStringMethod myReplace(char oldChar, char newChar) {
		String response = "";
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == oldChar)
				response += Character.toString(newChar);
			else
				response += Character.toString(s1.charAt(i));
				
		}
		return new EserciziStringMethod(response);
	}

	public EserciziStringMethod mySubString(int indexBegin, int indexEnd) {
		String response = "";
		for (int i = indexBegin -1 ; i < indexEnd - 1; i++) 
			response += Character.toString(s1.charAt(i));
		
		return new EserciziStringMethod(response);
	}
	
	public EserciziStringMethod myReverse() {
		String response = "";
		for (int i = s1.length()-1; i >= 0; i--) 
			response += Character.toString(s1.charAt(i));
		
		return new EserciziStringMethod(response);
	}
	
}
	
