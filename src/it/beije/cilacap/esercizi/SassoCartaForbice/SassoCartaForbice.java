package it.beije.cilacap.esercizi.SassoCartaForbice;

public  class SassoCartaForbice {

	public static enum Mosse {
		SASSO,
		CARTA,
		FORBICE}
		
	
	public int ComparaMosse(Mosse x, Mosse y) {
		if(x==y)
			return 0;
		switch (x) {
		case SASSO:
			return (y==Mosse.FORBICE?1:-1);
		case CARTA:
			return (y==Mosse.SASSO?1:-1);
		case FORBICE:
			return (y==Mosse.CARTA ?1:-1);
		}
		return 0;
	
		}
	
	public void startGame() {
		System.out.println("Sasso,Carta,Forbice!");
		}
		
}	

	
	



