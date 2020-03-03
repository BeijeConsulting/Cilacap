package it.beije.cilacap.rubrica;

import java.util.List;

public class JPDBtest {

	public static void main(String[] args) {
		
		List<Contatto> contacts = JPDBtools.getContactsFromJPAHDB();
		JPDBtools.insertInJPAHDB(contacts);

	}

}
