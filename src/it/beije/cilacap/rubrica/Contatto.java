package it.beije.cilacap.rubrica;

public class Contatto {

	private String nome;
	private String cognome;
	private String telefono;
	private String email;
	
	static final String[] INTESTAZIONE = {"cognome", "nome", "telefono", "email"};
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
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
}
