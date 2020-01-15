package it.beije.cilacap;

public class ProvaStringa {

	String p = "bellabro";

	boolean MyContains(String s) {

		boolean ok = true;
		for (int i = 0; i < p.length(); i++) {

			if (p.indexOf(s) != -1) {
				System.out.println("trovato");
				return true;
			} else {
				ok = false;
			}
		}
		if (ok == false) {
			System.out.println("non trovato");
		}
		return false;
	}

	public void MyStartWith(String s) {
		int cont = 0;
		char a = ' ';
		char b;
		for (int i = 0; i < p.length(); i++) {
			if (i < s.length()) {
				a = s.charAt(i);
			}
			b = p.charAt(i);
			if (a == b)
				cont++;

			if (cont == s.length()) {
				System.out.println("ok");
				break;

			}
		}
		if (cont != s.length())
			System.out.println("no");
	}

	public void MyEndWith(String s) {
		int cont = 0;

		char b;
		char a = ' ';
		int j = s.length() - 1;
		boolean k = false;
		for (int i = p.length() - 1; i >= 0; i--) {
			b = p.charAt(i);

			if (j >= 0) {
				a = s.charAt(j);
			}
			j--;
			if (a == b) {
				cont++;

			} else {
				k = false;
				break;
			}

			if (cont == s.length()) {
				System.out.println("ok");
				break;
			}

		}
		if (k == false && cont != s.length())
			System.out.println("no");
	}

	String MyTrim() {
		char a;
		char b;
		int cont1 = 0;
		for (int i = 0; i < p.length(); i++) {
			a = p.charAt(i);

			if (a == ' ') {

			} else {
				cont1 = i;
				break;
			}

		}

		int cont2 = 0;
		for (int j = p.length() - 1; j >= 0; j--) {
			b = p.charAt(j);

			if (b == ' ') {

			} else {
				cont2 = j;
				break;
			}
		}
		String c = p.substring(cont1, cont2 + 1);
		System.out.println(c);
		return c;
	}

	boolean MyEquals(String s) { // case sensitive
		char a;
		char b;
		if (s.length() != p.length()) {
			System.out.println("diversi");
			return false;
		}
		for (int i = 0; i < p.length(); i++) {
			a = p.charAt(i);
			b = p.charAt(i);
			if (a != b) {
				System.out.println("diversi");
				return false;
			}
		}
		System.out.println("uguali");
		return true;
	}

	String MyReplace(char oldChar, char newChar) {
		char a;
		String parola = " ";
		for (int i = 0; i < p.length(); i++) {
			a = p.charAt(i);
			if (a != oldChar) {
				parola += a;
			} else {
				parola += newChar;
			}
		}
		System.out.println(parola);
		return null;
	}

	String MySubstring(int indexB, int indexE) {
		char a;
		for (int i = indexB; i < indexE; i++) {
			a = p.charAt(i);
			System.out.print(a);
		}

		return null;
	}

	String reverse(String s) {
		char a;
		for (int i = s.length()-1; i >= 0; i--) {
			a = s.charAt(i);
			System.out.print(a);
		}
		return null;
	}

	public static void main(String[] args) {

		ProvaStringa pr = new ProvaStringa();
		pr.reverse("remare");

	}
}