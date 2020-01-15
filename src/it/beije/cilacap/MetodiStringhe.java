package it.beije.cilacap;

public class MetodiStringhe {
	public static String reverse(String s) {
		char[]parole=s.toCharArray();
		StringBuilder block=new StringBuilder();;
		for(int i=s.length()-1;i>=0;i--) {	
			block.append(parole[i]);
			}
		return block.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println(reverse("ciao"));
		
		
	}

}
