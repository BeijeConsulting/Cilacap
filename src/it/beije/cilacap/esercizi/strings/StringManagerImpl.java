package it.beije.cilacap.esercizi.strings;

public class StringManagerImpl implements StringManager {

	private String string;

	public StringManagerImpl(String string) {
		this.string = string;
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

		int begin = 0;
		int end = 0;

		for (int i = 0; i < string.length(); i++) {
			if ((string.charAt(i) != ' ') && (string.charAt(i) != '\t') && (string.charAt(i) != '\n')
					&& (string.charAt(i) != '\r')) {
				begin = i; // trovato indice del primo carattere posso uscire
				break;
			}
		}
		for (int i = string.length() - 1; i >= 0; i--) {
			if ((string.charAt(i) != ' ') && (string.charAt(i) != '\t') && (string.charAt(i) != '\n')
					&& (string.charAt(i) != '\r')) {
				end = i;
				break;
			}
		}
		return this.mySubString(begin, ++end);
	}

	@Override
	public StringManagerImpl mySubString(int beginIndex, int endIndex) {

		String subbed = "";
		while (beginIndex < endIndex) {
			subbed += string.charAt(beginIndex);
			beginIndex++;
		}
		return new StringManagerImpl(subbed);
	}

	@Override
	public boolean MyStartWith(String prefixStr) {
		if (string.indexOf(prefixStr, 0) != -1) { // se trova che l'indice
			return true; // con la stringa desiderata parte dalla pos
							// 0 allora ritorna true
		} else {
			return false;
		}
	}

	@Override
	public boolean MyEndWith(String suffixStr) {
		if (string.indexOf(suffixStr, string.length() - 1) != -1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean myEquals(String strToMatch) {
//		boolean equals(String str)
//      boolean equalsIgnoreCase(String str)
//		if (string.indexOf(strToMatch, posizione) != -1) 
		boolean response = false;
		for(int i = 0; i < string.length(); i++) {
			if((string.indexOf(strToMatch.charAt(i)) != -1)) {
				if(i==string.length()-1) {
					response = true;
				}else {
					break;
				}
			}
		}
		return response;
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
