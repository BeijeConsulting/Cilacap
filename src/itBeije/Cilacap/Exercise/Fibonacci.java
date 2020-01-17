package itBeije.Cilacap.Exercise;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
	
	List<Integer> occorrenze = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//fibonacci - n di occorrenze ,poi  di righe complete . da n metodi e iniz da arg fn=fn-1 + fn-2
		//1 \t 11 \t 112\t 1123\t 11235\t 1 11 211 3211 53211
		Fibonacci Fibo=new Fibonacci();
		Integer intero = Integer.parseInt(args[0]);
 		System.out.println(Fibo.metodoOccorrenze(intero));
 		Fibo.metodoRighe(intero);
		Fibo.reverse(intero);
	}

	
	
	public List<Integer> metodoOccorrenze(int occorrenze)
	{
		int i,nminore=0,nminore2=0;
		StringBuilder stringa= new StringBuilder();
		List<Integer> lista=new ArrayList<>();
		for(i=1;i<=occorrenze;i++)
		{
			if(i==1 || i==2)
			{
				lista.add(1);
				
			}
			else
			{
				nminore=lista.get(i-2);
				nminore2=lista.get(i-3);
				lista.add((nminore+nminore2));
			}
				
		}
				
			return lista;			
	}
	
	public List metodoRighe(int righe)
	{
		int i,nminore=0,nminore2=0 , n=0;
		StringBuilder stringa= new StringBuilder();
		List<Integer> lista=new ArrayList<>();
		for(i=1;i<=righe;i++)
		{
			if(i==1 || i==2)
			{
				lista.add(1);
				System.out.println(lista);
			}
			else
			{
				nminore=lista.get(i-2);
				nminore2=lista.get(i-3);
				n=nminore+nminore2;
				lista.add(n);
				System.out.println(lista);
			}
				
		}
				
			return lista;		
	}
	
	public void reverse(int r) {
		  List<Integer> lista=this.metodoOccorrenze(r);
		  
		  for(int i=0;i<=r;i++) {
		   for(int f=0;f<=i;f++) {
			   if(f==lista.size())
				   System.out.print(lista.get(f-1)+" ");
			   else
				   System.out.print(lista.get(f)+" ");
		  }
		  System.out.print("    ");
		  for(int a=r-i;a>=0;a--) {
			  if(a==lista.size())
				  System.out.print(lista.get(a-1)+" ");
			  else
				  System.out.print(lista.get(a)+" ");
		  }
		  System.out.println();
		  }
		 }
}
