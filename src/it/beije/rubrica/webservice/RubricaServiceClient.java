package it.beije.rubrica.webservice;

public class RubricaServiceClient {
	
	public static void main(String[] args) {
		ContactsImplService service = new ContactsImplService();
		Contacts contactService = service.getContactsImplPort();
		
//		System.out.println("Tutti i contatti #####################");
//		for(Contact c : contactService.getContacts()) {
//			System.out.println(c.toString());
//		}
		
		System.out.println("Get Name #####################");
		for(String c : contactService.getNames()) {
			System.out.println(c);
		}
		
		System.out.println("Get By Parametro #####################");
		for(Contact c : contactService.getContactByParameter("mario")) {
			System.out.println(c.toString());
		}
	}
	
}
