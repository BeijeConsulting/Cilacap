package it.beije.cilacap.esercizi;

public class ProvaSB {
	
	public static void main(String[] args) {
		
		
		Metodi m=new Metodi();
		
		StringBuilder st=new StringBuilder("And");
		
		StringBuilder st2=st.append("E").append("oggi");
		int len=st2.length();
		System.out.println(len+" "+st2);
		
		System.out.println(st.capacity());
		System.out.println(st2.insert(1, "BBB").delete(1, 3));
		StringBuilder s3=st2.insert(2, "Pino".charAt(3)).insert(4, "Pino");
		System.out.println(s3);
		System.out.println(s3.toString().charAt(5));
		System.out.println(s3.toString());
		
		StringBuilder sb=new StringBuilder("Nessuno");
		StringBuilder sb2=new StringBuilder("Nessuno");
		System.out.println(sb.equals(sb2));
		//StringBuilder a=m.myToString(st, st2, s3);
		
		
	}

}



