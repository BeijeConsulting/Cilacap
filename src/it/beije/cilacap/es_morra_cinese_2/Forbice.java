package it.beije.cilacap.es_morra_cinese_2;

public class Forbice implements mossa{

	static final int ID=FORBICE_ID;
	static final String NAME="forbice";
	private static final int VINCE_SU = CARTA_ID;
	
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
