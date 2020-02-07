package it.beije.cilacap.pool;

import java.util.ArrayList;
import java.util.List;

class ResourceManager {

			
		private static ResourceManager rs = null;
		private static final int MAX_RES= 5;
		
		private static List<Resource> res = new ArrayList<>();			
		//Singleton private constructor
		private ResourceManager() {}
		
		//Singleton getInstance method
		public static ResourceManager getInstance() {
			if (rs == null) 
	            rs = new ResourceManager(); 
	  
	        return rs; 
		}
		
		//Creazione della risorsa
		public static Resource createResource(Resource r) throws MaxResourceAvalaibleException{
			if (res.size() < MAX_RES) {
				r.setAvailable(false);
				res.add(r);
				return r;
			}else{throw new MaxResourceAvalaibleException(r);}
		}
		
		//Distruzione di una risorsa
		public static void makeResourceFree(Resource r) {
			r.setAvailable(true);
		}
		
		public static void destroyResource(Resource r) {
			res.remove(r);
		}

		public static int getMaxRes() {
			return MAX_RES;
		}

		public static List<Resource> getRes() {
			int i = 1;
			for(Resource r : res) {
				System.out.println("Resource "+ i +"is available = " + r.isAvailable());
				i++;
			}
			System.out.println("\n");
			return res;
		}

		public static void setRes(List<Resource> res) {
			ResourceManager.res = res;
		}
		
		public static void howManyResource(){
			System.out.println("Resource pool = Max resource available "+ MAX_RES + "- Active resource " + res.size());
			System.out.println("\n");
		}
}
