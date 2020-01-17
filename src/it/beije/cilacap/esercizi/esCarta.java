package it.beije.cilacap.esercizi;
import java.util.Scanner;


public class esCarta {


	
	public void cartaAlta(int a, int b) {

		int [] carta= {1,2,3,4,5,6,7,8,9,10,11,12,13};
		if(a==carta[0] && b ==carta[12]){
			System.out.println("Vince la prima carta");
		} else if(b==carta[0] && a==carta[12]) {
			System.out.println("Vince la seconda carta");
		}else if(a < b) {
			System.out.println("Vince la seconda carta"); 
		}else {
			System.out.println("Vince la prima carta");
		}
	}
	
	
		
	
	public static void main(String[] args) {
		esCarta c=new esCarta();
		// TODO Auto-generated method stub
		int valore1;
		int valore2;
		int[] carte= {1,2,3,4,5,6,7,8,9,10,11,12,13};

		Scanner scan=new Scanner(System.in);
		System.out.println("Prima carta: \n");
		valore1=scan.nextInt();
		System.out.println("Seconda carta: \n");
		valore2=scan.nextInt();
		c.cartaAlta(valore1, valore2);
	}

}
