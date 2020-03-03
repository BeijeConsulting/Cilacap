package it.beije.cilacap.rubrica;

import java.util.List;

public class HDBtest {

	public static void main(String[] args) {
		System.out.println("HDBtest...");
		
		List<Contatto> contacts = HDBtools.getContactFromHDB();
		//HDBtools.insertInHDB(contacts);
		HDBtools.updateHDB(contacts);
	}

}
