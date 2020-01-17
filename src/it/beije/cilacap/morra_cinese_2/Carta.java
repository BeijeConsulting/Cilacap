package it.beije.cilacap.morra_cinese_2;

public class Carta implements mossa{
	
	static final int ID=CARTA_ID;
	static final String NAME="carta";
	private static final int VINCE_SU = SASSO_ID;

	public String toString() {
		return NAME;
	}

	public boolean vittoria(mossa move) {
		return move.getId()==VINCE_SU;
	}

	public int getId() {
		return ID;
	}
}
