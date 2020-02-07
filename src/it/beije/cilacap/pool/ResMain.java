package it.beije.cilacap.pool;

import java.util.ArrayList;
import java.util.Random;

public class ResMain {

	public static void main(String[] args) {
		ArrayList<Resource> arrayRes = new ArrayList<>();
		for(int i=0; i<20;i++) {
			Random r = new Random();
			if(r.nextBoolean()) {
				arrayRes.add(new Resource());
				System.out.println("Resource created");
			}
		}
		for(int i=0; i<arrayRes.size();i++) {
			arrayRes.get(i).close();
		}
	}

}
