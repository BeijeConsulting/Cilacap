package it.beije.cilacap.esercizi;

public interface StringManager {

	public boolean myContains(String strToMatch, String character);
	public boolean MyStartWith(String strToMatch, String character);
	public boolean MyEndWith(String strToMatch, char character);
	public String myTrim();
	public boolean myEquals(String strToMatch1, String strToMatch2);
	public String mySubString(int beginIndex, int endIndex);
	
}
