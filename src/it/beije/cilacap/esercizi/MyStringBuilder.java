package it.beije.cilacap.esercizi;

public class MyStringBuilder {
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder(" Andrea Gargarone  \n\n\n\t");
		
		// trim().charAt()
		System.out.println("charAt(1): " + sb.charAt(1));
		System.out.println("charAt(10): " + sb.charAt(10) + "\n");
		
		// length()
		System.out.println("length: " + sb.length() + "\n");
		
		// substring
		System.out.println("substring: " + sb.substring(1, 7));
		System.out.println("substring: " + sb.substring(8, 17) + "\n");
		
		// indexOf()
		System.out.println("indexOf(\"A\"): " + sb.indexOf("A"));
		System.out.println("indexOf(\"G\"): " + sb.indexOf("G"));
		System.out.println("indexOf(\"g\"): " + sb.indexOf("g"));
		System.out.println("indexOf(\"e\"): " + sb.indexOf("e") + "\n");
		
		// converto sb in String e applico trim
		String s = sb.toString();
		System.out.println("Da StringBuilder a String");
		String sTrimmed = s.trim();
		System.out.println("trim() su string: " + sTrimmed);
		
		// ritorno a StringBuilder
		StringBuilder newSb = new StringBuilder(sTrimmed);
		System.out.println();
		
		// append()
		System.out.println(newSb.append("\n-Data di Nascita: ").append("22/09/1992").append(" ").append(true));
		System.out.println();
		
		// insert()
		System.out.println(newSb.insert(0, "Nome e Cognome: "));
		System.out.println();
		
		// delete()
		int startIndex = newSb.indexOf("true");
		System.out.println(newSb.delete(startIndex, newSb.length()));
		
		// deleteCharAt()
		int index = newSb.indexOf("-");
		System.out.println(newSb.deleteCharAt(index));
		System.out.println();
		
		// reverse()
		System.out.println(newSb.reverse());
		
	}
	
}
