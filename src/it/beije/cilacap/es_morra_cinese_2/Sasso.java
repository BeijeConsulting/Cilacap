package it.beije.cilacap.es_morra_cinese_2;

public class Sasso implements mossa{
	
	static final int ID=SASSO_ID;
	static final String NAME="sasso";
	private static final int VINCE_SU = FORBICE_ID;
	
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
