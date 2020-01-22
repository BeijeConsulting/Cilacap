package it.beije.cilacap.es_array;

public class ArrayMain {

	private static final String CRESCENTE="ASC";
	private static final String DECRESCENTE="DESC";
	
	public static void main(String[] args) {
		double[] arr = {2, 65, 1, 9, 3};
		System.out.println(mySearching(arr, 1));
		mySorting(arr, CRESCENTE);
		mySorting(arr, DECRESCENTE);
	}
	
	public static int mySearching(Object[] array, Object e) {
		for(int i=0; i<array.length; i++) {
			if(array[i].equals(e)) return i;
		}
		return -1;
	}
	
	private static int mySearching(double[] array, double e) {
		for(int i=0; i<array.length; i++) {
			if(array[i]==e) return i;
		}
		return -1;
	}
	
	private static void mySorting(double[] array, String mode) {
		double[] sorted = array;
		double temp;
		boolean done=false;
		while(!done) {
			for(int i=0; i<array.length-1;i++) {
				if(sorted[i]>sorted[i+1]) {
					temp=sorted[i];
					sorted[i]=sorted[i+1];
					sorted[i+1]=temp;
					done=false;
				}
				else done=true;
			}
		}
		switch(mode) {
		case CRESCENTE:
			break;
		case DECRESCENTE:
			sorted=myReverse(sorted);
			break;
		default:
			System.out.println("errore");
			done=true;
			return;
		}
		for(int i=0;i<sorted.length; i++) System.out.println(sorted[i]);
	}

	private static double[] myReverse(double[] sorted) {
		double[] rev = new double[sorted.length];
		int j=0;
		for(int i=sorted.length-1; i>=0; i--) {
			rev[j++]=sorted[i];
		}
		return rev;
	}

}
