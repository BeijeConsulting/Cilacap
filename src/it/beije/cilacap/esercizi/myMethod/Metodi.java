package it.beije.cilacap.esercizi.myMethod;

public class Metodi{
	
	StringBuilder sb=new StringBuilder();

	
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
			String sub1= new String();
			String sub2=new String();
			int i,j;
			
			for(i=0;i<s.length();i++) {
				if(s.charAt(i)!=' ') {  
					sub1= s.substring(i);
				break;
				
				}
				
			}
			for (j=sub1.length()-1;j>=0;j--) {
				if(sub1.charAt(j)!=' ') {
					sub2=sub1.substring(0,j+1);
				break;
				}
				else 
					continue;
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
		
		public boolean myEquals(String s,String t) {
			boolean z=false;
			for (int i=0; i<s.length();i++) {
				if(s.charAt(i)!=t.charAt(i)) {
					z= false;
					break;
					}
				else
					z=true;
				}
			return z;
			}
			
		public String myReverse(String s) {
			for (int i=s.length()-1;i>=0;i--) {
				sb.append(s.charAt(i));
			}
				return sb.toString();
			
				
				
				
			}
				
		public String mySubstring(String s, int beginIndex, int endIndex){
			StringBuilder sub=new StringBuilder();
			for (int i=beginIndex; i<endIndex; i++)
				sub.append(s.charAt(i));
			return sub.toString();
			
			}
		}
		
	
	
	
	





