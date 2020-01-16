package it.beije.cilacap.exercises;

import java.util.Arrays;
import java.util.ArrayList;

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
	
	static String MyReplace(char oldChar, char newChar) {
		String replace = "MyReplace string";
		String newReplace = "";
		char newcharacter = newChar;
		char oldcharacter = oldChar;

		for (int i = 0; i < replace.length(); i++) {
			
			if (replace.charAt(i) == oldcharacter) {
				newReplace += newcharacter;
			}
			else {
				newReplace += replace.charAt(i);
			}
		}
		return newReplace;
	}
	
	static String MySubstring(int startIndex, int endIndex) {
		String substring = "MySubstring string";
		String newSubstring = "";
		int startI = startIndex;
		int endI = endIndex;
		
		if (startI > endI) {
			return null;
		}
		
		for (int i = 0; i < substring.length(); i++) {
			if (i >= startI && i < endI) {
				newSubstring += substring.charAt(i);
			}
		}
		return newSubstring;
	} 
	
	static String MyTrim() {
		String trim = "  MyTrim string  ";
		String newtrim = "";
		int countInitial = 0;
		int countFinal = trim.length() -1;
		
		while (trim.charAt(countInitial) == ' ') {
			countInitial++;
		}
		
		while (trim.charAt(countFinal) == ' ') {
			countFinal--;
		}
	
		for ( ; countInitial < countFinal+1; countInitial++) {
			newtrim += trim.charAt(countInitial);
			}	
		return newtrim;
		}
		
	
	static String MyReverse() {
		String reverse = "MyReverse string";
		String newReverse = "";
		int j = reverse.length() -1;
		
		for (int i=0; i<reverse.length();i++) {
			newReverse += reverse.charAt(j);
			j--;
		}
		
		return newReverse;
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
		System.out.println(test.replace(" ", ""));*/
		
	/*	StringBuilder testSB = new StringBuilder("This is a test");
		System.out.println(testSB.length());
		System.out.println(testSB.charAt(2));
		System.out.println(testSB.indexOf("a"));
		System.out.println(testSB.substring(3, 11));
		System.out.println(testSB.append('!'));
		System.out.println(testSB.insert(7, " not"));
		System.out.println(testSB.delete(8,12));
		System.out.println(testSB.deleteCharAt(8));
		System.out.println(testSB.reverse());
		System.out.println(testSB.toString()); */
		
	/*	int numbers[] = new int[] {106, 235, 23, 63};
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i] + " ");
		}
		System.out.println(Arrays.binarySearch(numbers, 3));
		System.out.println(Arrays.binarySearch(numbers, 55));
		System.out.println(Arrays.binarySearch(numbers, 23)); */
		
		ArrayList<String> testAL = new ArrayList<>(); 
		testAL.add("A");
		testAL.add("B");
		testAL.add("C");
		testAL.add("D");
		testAL.add("E");
		System.out.println(testAL);
		testAL.remove(4);
		System.out.println(testAL);
		testAL.set(2, "c");
		System.out.println(testAL);
		System.out.println(testAL.isEmpty());
		System.out.println(testAL.size());
		System.out.println(testAL.contains("A"));
		System.out.println(testAL.contains("C"));
		ArrayList<String> testAL2 = new ArrayList<>();
		testAL2.add("A");
		testAL2.add("B");
		testAL2.add("c");
		testAL2.add("D");
		System.out.println(testAL.equals(testAL2));
		testAL2.clear();
		System.out.println(testAL2);
		
	 /* System.out.println(MyContains("a"));
		System.out.println(MyContains("x"));
		System.out.println(MyContains(" "));
		
		System.out.println(MyStartsWith('M'));
		System.out.println(MyStartsWith('N'));
		
		System.out.println(MyEndsWith('g'));
		System.out.println(MyEndsWith('h'));
		
		System.out.println(MyEquals("MyEquals string"));
		System.out.println(MyEquals("MyEquals strings"));
		System.out.println(MyEquals("MyEquals strin"));
		System.out.println(MyEquals("MYEquals string"));
		
		System.out.println(MyReplace('M', 'F'));
		System.out.println(MyReplace('l', 'r'));
		System.out.println(MyReplace(' ', 'X'));
		
		System.out.println(MySubstring(5, 7));
		System.out.println(MySubstring(0, 7));
		System.out.println(MySubstring(4, 9));
		
		System.out.println(MyTrim());
		
		//System.out.println(MyReverse());*/
	}

}
