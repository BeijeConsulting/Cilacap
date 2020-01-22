package it.beije.cilacap.esercizi.rubrica;

public class Contatto {
	
	private String cognome;
	private String nome;
	private String telefono;
	private String email;
	
	public Contatto() {
		
	}
	
	public Contatto(String...strings) {
		cognome = strings[0];
		nome = strings[1];
		telefono = strings[2];
		email = strings[3];
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cognome: " + cognome + "\nNome: " + nome + "\nTelefono: " + telefono + "\nEmail: " + email;
	}
	
	

}
