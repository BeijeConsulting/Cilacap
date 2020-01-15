package it.beije.cilacap.esercizi;

public class Metodi{

	
		public boolean myContains(String sequence, String s){ 
		return sequence.indexOf(s)> -1;
		}

		public boolean myStartsWith(String s,char c) {
			if (s.charAt(0)==c)
			return true;
			else
			return false;
			}
		
		public boolean myEndsWith(String s,char c) {
			if (s.charAt(s.length()-1)==c)
				return true;
			else 
				return false;
			}
		
		public String myTrim(String s) {
			String sub1,sub2= new String();
			int i,j;
			
			for(i=0;i<s.length();i++) {
				if(s.charAt(i)==' ') 
					continue;
				else 
					sub1= s.substring(i,s.length());
			}
			for (j=s.length()-1;j==0;j--) {
				if(s.charAt(j)==' ')
					continue;
				else 
					sub2=s.substring(0,j+1);
			}
			return sub2;
		}
		

		public String myReplace(String s,char oldchar, char newchar) {
			StringBuilder sb= new StringBuilder();
			for(int i=0;i<=s.length()-1;i++) {
				if (s.charAt(i)==oldchar)
					sb.append(newchar);
				
				else 
					sb.append(s.charAt(i));
			}
				return  sb.toString();
				
			}
		
//		public boolean myEquals(String s){
//			
//		}
//	
	
	
	

}



