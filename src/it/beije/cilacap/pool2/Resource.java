package it.beije.cilacap.pool2;

public class Resource {
	
	private boolean avaliable = false;
	
	Resource() {}
	
	Resource(boolean available) {
		this.avaliable = available;
	}

	public boolean isAvailable() {
		return avaliable;
	}

	void setAvailable(boolean available) {
		this.avaliable = available;
	}

}
