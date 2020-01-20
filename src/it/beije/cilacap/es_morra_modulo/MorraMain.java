package it.beije.cilacap.es_morra_modulo;

public class MorraMain {

	public static final String[] lista = {"sasso", "carta", "forbice"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	//0 vince giocatore 1, 1 vince giocatore 2, 2 pareggio
	public int vincitore(int a, int b) {
		int pos1=a;
		int pos2=lista.length-b-1;
		return (pos1+pos2)%lista.length;
	}
}
