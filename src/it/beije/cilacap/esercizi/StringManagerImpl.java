package it.beije.cilacap.esercizi;

public class StringManagerImpl implements StringManager {

	private  String string;

	public String getString() {
		return string;
	}

	public StringManagerImpl(String str) {
		string = str;
	}

	@Override
	public boolean myContains(String character) {
		if (string.indexOf(character) != -1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public StringManagerImpl myTrim() {
//		int begin = 0;
//		int end = string.length();
//		while (begin < end && string.charAt(begin) == ' ') {
//			begin++;
//		}
//		while (end > begin && string.charAt(end - 1) == ' ') {
//			end--;
//		}
//		String subStringed = mySubString(begin, end);
//		return new StringManagerImpl(subStringed);
		
		int begin = 0;
		int end = 0;
		
		for(int i = 0; i< string.length(); i++) {
			if((string.charAt(i) != ' ') && (string.charAt(i) != '\t') && (string.charAt(i) != '\n') && (string.charAt(i) != '\r')) {
				begin = i;
				break;
			}
		}
		for(int i = string.length()-1; i>= 0; i--) {
			if((string.charAt(i) != ' ') && (string.charAt(i) != '\t') && (string.charAt(i) != '\n') && (string.charAt(i) != '\r')) {
				end = i;
				break;
			}
		}
		return this.mySubString(begin + 1, end + 1 );
	}

	@Override
	public StringManagerImpl mySubString(int beginIndex, int endIndex) {

		int begin = string.indexOf(string.charAt(beginIndex));
		int end = beginIndex != endIndex ? string.indexOf(string.charAt(endIndex - 1)) : -1;
		String s = "";
		if (end == -1)
			return this;
		while (begin <= end) {
			s += string.charAt(begin);
			begin++;
		}
		return new StringManagerImpl(s);
	}

	@Override
	public boolean MyStartWith(String prefixStr) {
		if (string.indexOf(prefixStr, 0) != -1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean MyEndWith(String suffixStr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean myEquals(String strToMatch) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String reverse(String strToReverse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return string;
	}

	@Override
	public void String() {
		// TODO Auto-generated method stub

	}

}
