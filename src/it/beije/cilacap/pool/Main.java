package it.beije.cilacap.pool;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		ResourceManager rs = ResourceManager.getInstance();
		try {
			rs.howManyResource();
			
			Resource r1 = rs.createResource(new Resource());
			Resource r2 = rs.createResource(new Resource());
			Resource r3 = rs.createResource(new Resource());
			Resource r4 = rs.createResource(new Resource());
			Resource r5 = rs.createResource(new Resource());
			
			rs.howManyResource();
			
			rs.getRes();
			
			
			rs.makeResourceFree(r4);
			
			rs.getRes();
			
			
			rs.destroyResource(r3);
			rs.getRes();
			rs.howManyResource();
			
			Resource r6 = rs.createResource(new Resource());
			rs.howManyResource();
			
			
		}catch(MaxResourceAvalaibleException e) {
			throw e;
		}
	}

}
