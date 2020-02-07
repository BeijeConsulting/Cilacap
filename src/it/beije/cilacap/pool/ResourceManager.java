package it.beije.cilacap.pool;

public class ResourceManager {

	private static ResourceManager resMan = null;
	private final int MAX_RES = 10;
	private int currentRes;
	
	private ResourceManager() {
	}
	
	public static ResourceManager getInstance() {
		if(resMan == null) resMan = new ResourceManager();
		return resMan;
	}
	
//	public void open(Resource res) throws MaxResourcesException {
//		if(currentRes>=MAX_RES) throw new MaxResourcesException();
//		if(!res.isAvailable()) {
//			res.setAvailable(true);
//			currentRes++;
//		}
//	}
//	
//	public void close(Resource res) {
//		if(res.isAvailable()) {
//			res.setAvailable(false);
//			currentRes--;
//		}
//	}

	public void openingRes() throws BadResourcesException {
		if(currentRes<MAX_RES) currentRes++;
		else throw new BadResourcesException("Max resources");
	}
	
	public void closingRes() throws BadResourcesException {
		if(currentRes>0) currentRes--;
		else throw new BadResourcesException("???");
	}


}
