package biblioteca;

import java.util.*;

public class Utente {
	
	protected String nome;
	protected String cognome;
	protected String codFisc;
	protected Map<String, Libro> libri;
	
	public Utente(){}
	public Utente(String nome, String cognome, String codFisc) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codFisc = codFisc;
		this.libri = new TreeMap<String, Libro>();
	}
		
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
	public String getCodFisc() {
		return codFisc;
	}
	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}
	public Map<String, Libro> getLibri() {
		return libri;
	}
	public void setLibri(Map<String, Libro> libri) {
		this.libri = libri;
	}
	
	//Metodi ausiliari
	public int getNumeroLibri(){
		return this.libri.size();
	}
	public void aggiungiLibro(Libro l){
		this.libri.put(l.getSerialNum(), l);
	}
	

}