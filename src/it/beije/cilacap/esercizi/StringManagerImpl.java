package it.beije.cilacap.esercizi;

public class StringManagerImpl implements StringManager {

	@Override
	public boolean myContains(String strToMatch, String character) {
		if (strToMatch.indexOf(character) != -1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean MyStartWith(String strToMatch, String character) {
		if (strToMatch.charAt(0) == character.charAt(0)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean MyEndWith(String strToMatch, char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String myTrim() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean myEquals(String strToMatch1, String strToMatch2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String mySubString(int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
