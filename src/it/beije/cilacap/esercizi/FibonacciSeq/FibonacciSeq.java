package it.beije.cilacap.esercizi.FibonacciSeq;

public class FibonacciSeq {
	
	int[] seq = null;

	
	public int[] fibonacciSeq(int index) {
		
		seq = new int[index];
		
		if (index < 2) {
			seq[1]= 1;
			return seq;
		}
		else {
			for (int i = 0; i < index-1; i++) {
			
				if (i == 0) {
					seq[i]= 1;
					seq[i+1]= 1;
					continue;
				}
				else 
					seq[i+1] = seq[i-1] + seq[i];
				
			}
		}
		
		return seq;
	}
	
	public void fibonacciSeqRawPrint(int[] seq) {
		ArrayList<String> seqPrintSxToDx = new ArrayList <> ();
		ArrayList<String> seqPrintDxToSx = new ArrayList <> ();
		
		for (int i = 0; i < seq.length; i++) {
			seqPrintSxToDx.set(i,"  " + seq[i]);
			seqPrintDxToSx.set((seq.length-1) - i,"  " + seq[(seq.length-1)-i]);
		}
		
		
	}
}
	
	
	


