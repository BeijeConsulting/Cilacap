package it.beije.cilacap.pool;

public class Resource {
	
	private boolean available = false;

	public Resource() {}
	
	public Resource(boolean available) {
		this.available = available;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
