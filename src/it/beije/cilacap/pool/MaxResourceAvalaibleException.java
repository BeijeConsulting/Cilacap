package it.beije.cilacap.pool;

public class MaxResourceAvalaibleException extends RuntimeException{

		public MaxResourceAvalaibleException(Resource r) {
			System.out.println("MAX RESOURCE AVAILABLE: "+ ResourceManager.getMaxRes()+" - cannot creat other resource");
			System.out.println("\n");
		}
}
