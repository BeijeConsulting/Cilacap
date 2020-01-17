package it.beije.cilacap.morra_cinese_2;

public interface mossa {

	static final int SASSO_ID = 0;
	static final int CARTA_ID = 1;
	static final int FORBICE_ID = 2;
	
	public String toString();
	public boolean vittoria(mossa move);
	public int getId();
}
