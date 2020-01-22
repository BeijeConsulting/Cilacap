package itBeije.Cilacap.Exercise;

public class ProvaStatic {
	
	static int Puntatore;
	int[] mioArray= {1,2,3};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProvaStatic p = new ProvaStatic();
		ProvaStatic p2 = new ProvaStatic();
		metodo(p,p2);
		
	}
	
	public static void metodo(ProvaStatic p , ProvaStatic p2)
	{
		p.Puntatore=1;
		p2.Puntatore=2;
		System.out.println(p.mioArray[p.Puntatore] +" " + p2.mioArray[p2.Puntatore]);
	}

}
