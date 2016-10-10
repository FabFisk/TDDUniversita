package biblioteca;

import java.util.*;

public class Biblioteca {
	
	private String nome;
	private Map<String, Utente> utenti;
	private Map<String, Libro> libri;
	private Map<String, Prestito> prestiti;
	
	public Biblioteca(){}
	public Biblioteca(String nome) {
		super();
		this.nome = nome;
		this.utenti  = new TreeMap<String, Utente>();
		this.libri = new TreeMap<String, Libro>();
		this.prestiti = new TreeMap<String, Prestito>();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Map<String, Utente> getUtenti() {
		return utenti;
	}
	public void setUtenti(Map<String, Utente> utenti) {
		this.utenti = utenti;
	}
	public Map<String, Libro> getLibri() {
		return libri;
	}
	public void setLibri(Map<String, Libro> libri) {
		this.libri = libri;
	}
	public Map<String, Prestito> getPrestiti() {
		return prestiti;
	}
	public void setPrestiti(Map<String, Prestito> prestiti) {
		this.prestiti = prestiti;
	}
	
	//Metodi ausiliari
	public void aggiungiLibro(Libro l){
		this.libri.put(l.getSerialNum(), l);
	}
	public void aggiungiUtente(Utente u){
		this.utenti.put(u.getCodFisc(), u);
	}
	

}