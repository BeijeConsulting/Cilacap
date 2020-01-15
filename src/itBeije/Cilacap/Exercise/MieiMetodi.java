package itBeije.Cilacap.Exercise;

public class MieiMetodi {
	String miaStringa;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MieiMetodi m = new MieiMetodi();
		m.miaStringa="pippo";
		System.out.println(m.myContains("p"));
		System.out.println(m.myStartsWith("pi"));
		System.out.println(m.myEndsWith("pippo"));
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
		if(i==-1)
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
		return null;
		
	}
	public boolean myEquals(String stringa) {
		
		if(miaStringa.indexOf(stringa)!=-1 && stringa.length()==miaStringa.length())
		{
			return true;
		}
		else
			
		return false;
		
	}
	public String myReplace() {
		return null;
		
	}
	
	public String mmySubstring() {
		return null;
		
	}
	
	
}
