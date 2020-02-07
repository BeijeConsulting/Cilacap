package it.beije.cilacap.pool2;

public class ResourceManager {
	
	private static ResourceManager resMan = null;
	private final static int MAX_RES = 10;
	private Resource[] resList = new Resource[MAX_RES];
	
	private ResourceManager() {}
	
	public static ResourceManager getInstance() {
		if(resMan == null) resMan = new ResourceManager();
		return resMan;
	}
	
	public Resource getResource() {
		for(int i=0; i<MAX_RES; i++) {
			if(resList[i] == null) return resList[i] = new Resource(false);
			if(resList[i].isAvailable()) return resList[i];
		}
		System.out.println("Numero max risorse raggiunto");
		throw new NullPointerException();
	}
	
	public void freeResource(Resource res) {
		for(int i=0; i<MAX_RES; i++)
			if(resList[i]!=null && resList[i].equals(res)) {
				res.setAvailable(true);
				return;
			}
		System.out.println("Risorsa non trovata");
		return;
	}
	
	public void freeResource(int index) {
		if(index<MAX_RES && resList[index]!=null) {
			if(!resList[index].isAvailable()) resList[index].setAvailable(true);
			else System.out.println("Risorsa già libera");
		}else System.out.println("Risorsa non trovata");
		return;
	}
	
	public void runGC() {
		for(int i=0; i<MAX_RES; i++) {
			if(resList[i]!=null && resList[i].isAvailable()) resList[i] = null;
		}
	}

}
