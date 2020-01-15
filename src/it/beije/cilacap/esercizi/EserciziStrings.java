package it.beije.cilacap.esercizi;

public class EserciziStrings {

	private String string = "";
	
	public void setString(String str) {
		string = str;
	}
	
	public String getString() {
		return string;
	}
	public static void main(String[] args) {		
		
		StringManagerImpl string = new StringManagerImpl();
		System.out.println(string.myContains("ciao", "iaf"));
		System.out.println(string.MyStartWith("facile", "f"));
//		System.out.println(string.MyEndWith("ciao", "o"));

	}

	

	public boolean MyStartWith(String strToMatch, String character) {

		if (strToMatch.charAt(0) == character.charAt(0)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean MyEndWith(String strToMatch, String character) {
		
		return true; //TODO		
	}

	public String myTrim() {
			
		int begin = 0;
		int end = string.length();
		while (begin < end && string.charAt(begin) == ' ') {
			begin++;
		}
		while(end > begin && string.charAt(end-1)== ' ') {
			end--;
		}
		String s = mySubString(begin, end);
		return s;

	}

	public boolean myEquals(String strToMatch1, String strToMatch2) {
		int i = 0;
		while (i != strToMatch1.length() - 1 && strToMatch1.charAt(i) == strToMatch2.charAt(i)) {
			i++;
		}
		if (i == strToMatch1.length() - 1) {
			return true;
		} else {
			return false;
		}
	}

	public String mySubString(int beginIndex, int endIndex) {
		int begin = string.indexOf(string.charAt(beginIndex));
		int end = beginIndex != endIndex ? string.indexOf(string.charAt(endIndex - 1)) : -1;
		String s = "";
		if (end == -1)
			return s;
		while (begin <= end) {
			s += string.charAt(begin);
			begin++;
		}
		return s;

	}

//	public static String myReplace(char oldChar, char newChar) {
//		
//		String resulString = "";
//		
//		//ritorno una stringa che al posto di oldChar possiede newChar
//	}
}
