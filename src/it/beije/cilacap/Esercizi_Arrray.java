package it.beije.cilacap;

public class Esercizi_Arrray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vett[]= {4,6,7,9,8,1,2};
		Esercizi_Arrray prova = new Esercizi_Arrray();
		prova.mySorting(vett, "ASC");
		

	}

	int mySearching(int[] vett,int a) {
		for(int i=0;i<vett.length;i++) {
			if(vett[i]==a) {
				return i;
			}
		}
		return -1;
	}
	void mySorting(int[] vett,String come) {
		int temp=0;
		for(int i=0;i<vett.length;i++) {
			for(int j=0;j<vett.length-1;j++) {
				if(come.equals("DESC")) {
					if(vett[j]<=vett[j+1]) {
						temp = vett[j];
						vett[j]=vett[j+1];
						vett[j+1]= temp;
					}
				}
				if(come.equals("ASC")) {
					if(vett[j]>=vett[j+1]) {
						temp = vett[j];
						vett[j]=vett[j+1];
						vett[j+1]= temp;
					}
					
				}
			}
		}
		for(int i=0;i<vett.length;i++) {
			System.out.println(vett[i]);
		}
	}
}
