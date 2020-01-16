package itBeije.Cilacap.Exercise;

import java.util.ArrayList;

public class MieiMetodi {
	static String miaStringa;
	static StringBuilder miaStringaBuild=new StringBuilder("Testo");
	String[] mioArray= {"Testo","i","metodi"};
	String[] tuoArray= {"Testo","i","metodi"};
	ArrayList<String> lista= new ArrayList<>();
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
 		
 		
		MieiMetodi m = new MieiMetodi();
		m.miaStringa=" p i p p o ";	
		System.out.println("contains " + m.myContains("p"));
		System.out.println("StartsWith " + m.myStartsWith("pi"));
		System.out.println("EndsWith" + m.myEndsWith("pippo"));
		System.out.println("Equals " + m.myEquals("pippo"));
		System.out.println("replace "+ m.myReplace('p','P'));
		System.out.println("substring " + m.mySubstring(0,5));
		System.out.println(m.myTrim());
		System.out.println("reverse" + m.myReverse(miaStringa));
		System.out.println(m.mioArray.equals(m.tuoArray));
		System.out.println(m.mioArray==m.tuoArray);
		System.out.println(miaStringaBuild.append("as"));
		System.out.println(miaStringaBuild.delete(3,4));
		System.out.println(miaStringaBuild.insert(2, 2));
		System.out.println(miaStringaBuild.length());
		System.out.println(m.lista.add("taa") + " " + m.lista);
		
		
//		Integer i = new Integer(null);
//		System.out.println(i);NullPointerException
		
//		List<Integer> heights=new ArrayList<>();
//		heights.add(null);
//		Integer provaa = heights.get(0);
//		int h = heights.get(0); 
	}

	
	public boolean myContains(String stringa) {
		int i=0;
		
		
		if(stringa.length()<=miaStringa.length())
		{
			i=miaStringa.indexOf(stringa);
			
		}
		if(i==-1)
			return false;
		else
			return true;
		
//		PARENT: for(i=0;stringa.length()<=miaStringa.length() && i<miaStringa.length();i++)
//		{
//			ii=i; //ii è una variabile per aumentare l'indice della stringa da cercare dopo aver trovato 1 carattere
//			contatore=0;
//			for(j=0;j<stringa.length() && (miaStringa.charAt(ii)==stringa.charAt(j));j++)
//			{
//				
//				contatore++;
//				if(ii<miaStringa.length()-1)
//					ii++;
//				else
//					break PARENT;
//			}
//		}
//		
//		if(contatore==stringa.length()) 
//		{
//			return true;
//		}
//		else
//			return false;
		
	}
	
	public boolean myStartsWith(String stringa) {
		int i,j,contatore=0;
		for(i=0;i<miaStringa.length() && contatore == 0;i++)
		{
			for(j=0;j<stringa.length() && (miaStringa.charAt(i)==stringa.charAt(j));j++)
			{
				
				contatore++;
				if(i<miaStringa.length()-1)
					i++;
				
			}
		}
		
		if(contatore==stringa.length())
		{
			return true;
		}
		else
			return false;
		
		
		
	}
	
	public boolean myEndsWith(String stringa) {
		int i=0;
		if(stringa.length()<=miaStringa.length())
		{
			i=miaStringa.indexOf(stringa, miaStringa.length()-stringa.length());
		}
		
		if(i==-1 || stringa.length()>miaStringa.length())
		{
			return false;
		}
		else
			return true;
//			for(i=(miaStringa.length()-stringa.length()-1);i<miaStringa.length() && contatore == 0;i++)
//			{
//				contatore=0;
//				for(j=miaStringa.length()-stringa.length();j<stringa.length() && (miaStringa.charAt(i)==stringa.charAt(j));j++)
//				{
//					
//					contatore++;
//						i++;
//					
//						
//					
//				} 
//			}
//		}
//		if(contatore==stringa.length())
//		{
//			return true;
//		}
//		else
	}
	
	public String myTrim() {
		int i,j=0,cont=0;
		String copiaMiaStringa="";
		String finalString="";
		if(miaStringa.charAt(0)!=' ' && miaStringa.charAt(miaStringa.length()-1)!=' ')
		{
			return miaStringa;
		}
		for(i=0;i<miaStringa.length();i++)
		{
			
			if(miaStringa.charAt(i)==' ' && j==0)
			{
				
			}
			else
				{
					copiaMiaStringa= copiaMiaStringa + miaStringa.charAt(i);
					j=2;
				}
			
			
		}
		i=0;
		for(cont=copiaMiaStringa.length()-1;copiaMiaStringa.charAt(cont)==' ';cont--)
		{
			i++;
					
		}
		
		for(j=0;j<copiaMiaStringa.length()-i;j++)
		{
			finalString=finalString + copiaMiaStringa.charAt(j);
		}
		
		return finalString;
		
	}
	public boolean myEquals(String stringa) {
		
		if(miaStringa.indexOf(stringa)!=-1 && stringa.length()==miaStringa.length())
		{
			return true;
		}
		else
			return false;
		
	}
	public String myReplace(char oldChar , char newChar) {
		int i=0;
		String copiaMiaStringa = "";
		for(i=0;i<miaStringa.length() && miaStringa.length()>0;i++)
		{
			if(miaStringa.indexOf(oldChar)!=-1)
			{
				if(i!=miaStringa.indexOf(oldChar,i)) 
				{
					copiaMiaStringa= copiaMiaStringa + miaStringa.charAt(i);
					
				}
				else 
					copiaMiaStringa= copiaMiaStringa + newChar;
			}
			else
				return miaStringa;
//			c=miaStringa.charAt(miaStringa.indexOf(oldChar,i));
			
			
		}
			return copiaMiaStringa;
		
	}
	
	public String mySubstring(int startIndex , int endIndex) {
		
		int i;
		String copiaMiaStringa="";
		
		if(startIndex==endIndex)
		{
			return "";
		}
		else 
			if(endIndex < startIndex || miaStringa.length()<=0 || endIndex>miaStringa.length())
			{
				return "input non validi";
			}
			else
			{
				for(i=0;i<miaStringa.length();i++)
				{
					if(i>=startIndex && i<endIndex)
					{
						copiaMiaStringa= copiaMiaStringa + miaStringa.charAt(i);
						
					}
					
				}
				return copiaMiaStringa;
			}
		
	}
	
	public String myReverse(String stringa)
	{
		String copiaMiaStringa="";
		for(int i=miaStringa.length()-1;i>=0;i--)
		{
			copiaMiaStringa+=miaStringa.charAt(i);
		}
		return copiaMiaStringa;
	}
	
}
