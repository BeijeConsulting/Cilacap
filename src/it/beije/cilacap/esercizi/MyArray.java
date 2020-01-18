package it.beije.cilacap.esercizi;

public class MyArray {
	
	public void mySortIntVoid(int[] array, String order) {
		int temp = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length - 1; j++) {
				if(order.equals("ASC")) {
					if(array[j] >= array[j+1]) {
						temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
					}
				} else if(order.equals("DESC")) {
					if(array[j] <= array[j+1]) {
						temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
					}
				}
			}
		}
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
	
	public int[] mySortInt(int[] array, String order) {
		int temp = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length - 1; j++) {
				if(order.equals("ASC")) {
					if(array[j] >= array[j+1]) {
						temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
					}
				} else if(order.equals("DESC")) {
					if(array[j] <= array[j+1]) {
						temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
					}
				}
			}
		}
		return array;
	}
	
	public int mySearching(int[] array, int element) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == element) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		MyArray ma = new MyArray();
		
		int[] array = {4, 6, 1, 9, 33, 28, 2, 98};
		
		System.out.println(array.length);
		
		for(int i = 0; i < ma.mySortInt(array, "ASC").length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
		for(int i = 0; i < ma.mySortInt(array, "DESC").length; i++)
			System.out.print(array[i] + " ");
		
		System.out.println();
		
		// void
		ma.mySortIntVoid(array, "DESC");
		System.out.println();
		ma.mySortIntVoid(array, "ASC");
		
		
		// Searching
		System.out.println();
		System.out.println(ma.mySearching(array, 9));
		System.out.println(ma.mySearching(array, 3));
		
	}

}
