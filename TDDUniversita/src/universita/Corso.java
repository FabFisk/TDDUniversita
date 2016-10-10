package universita;

import java.util.*;

public class Corso {
	
	private String nome;
	private int ore;
	private Map<String, Studente> iscritti = new TreeMap<String, Studente>();
	private Map<String, Docente> docenti = new TreeMap<String, Docente>();
	
	public Corso(){}
	public Corso(String nome, int ore){
		this.nome = nome;
		this.ore = ore;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getOre() {
		return ore;
	}
	public void setOre(int ore) {
		this.ore = ore;
	}
	public Map<String, Studente> getIscritti() {
		return iscritti;
	}
	public void setIscritti(Map<String, Studente> iscritti) {
		this.iscritti = iscritti;
	}
	public Map<String, Docente> getDocenti() {
		return docenti;
	}
	public void setDocenti(Map<String, Docente> docenti) {
		this.docenti = docenti;
	}
	
	//Metodi ausiliari
	public void aggiungiDocente(Docente d){
		this.docenti.put(d.getCodFisc(), d);
	}
	public void aggiungiStudente(Studente s){
		this.iscritti.put(s.getCodFisc(), s);
	}

}