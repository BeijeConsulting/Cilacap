package it.beije.cilacap.pool;

public class Resource {
	
	private boolean avaliable = false;
	private static ResourceManager rs = ResourceManager.getInstance(); 
	
	public Resource() {
		try {
			rs.openingRes();
			avaliable = true;
		}catch (BadResourcesException bre) {
			bre.printStackTrace();
		}
	}
	
	public boolean isAvailable() {
		return avaliable;
	}
	
	public void close() {
		if(avaliable) {
			try {
				rs.closingRes();
				avaliable = false;
			} catch (BadResourcesException e) {
				e.printStackTrace();
			}
		}else System.out.println("Risorsa non aperta");
	}
	
	
//	public Resource(boolean available) {
//		this.available = available;
//	}

	

//	public void setAvailable(boolean available) {
//		this.available = available;
//	}
	
	
}
