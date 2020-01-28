package it.beije.cilacap.es_zoo.animali;

public class TigreSiberiana extends Tigre {

	String place = "Siberia";
	
	public TigreSiberiana(int age) {
		this(age, 60);
		// TODO Auto-generated constructor stub
	}
	
	public TigreSiberiana(int age, double weight) {
		super(age, weight);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return super.toString()+" origine: "+ place;
	}
}
