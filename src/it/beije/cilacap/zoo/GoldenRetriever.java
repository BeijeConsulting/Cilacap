package it.beije.cilacap.zoo;

public class GoldenRetriever extends Cane {
	private static final String TAGLIA= "media";
	
	public GoldenRetriever(int age) {
		super(age);
	}

	@Override
	public double getMaxSpeed() {
		return 0;
	}

}
