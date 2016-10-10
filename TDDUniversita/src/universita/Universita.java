package universita;

import java.util.*;
import biblioteca.*;

public class Universita  {

	private String nome;
	private Map<String, Studente> studenti = new TreeMap<String, Studente>();
	private Map<String, Docente> docenti = new TreeMap<String, Docente>();
	private Map<String, Corso> corsi = new TreeMap<String, Corso>();
	private Biblioteca b;
	private Gestione g;
	
	public Universita(){}
	public Universita(String nome){
		this.nome = nome;
		b = new Biblioteca (nome);
		g = new Gestione();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Map<String, Studente> getStudenti() {
		return studenti;
	}
	public void setStudenti(Map<String, Studente> studenti) {
		this.studenti = studenti;
	}
	public Map<String, Docente> getDocenti() {
		return docenti;
	}
	public void setDocenti(Map<String, Docente> docenti) {
		this.docenti = docenti;
	}
	public Map<String, Corso> getCorsi() {
		return corsi;
	}
	public void setCorsi(Map<String, Corso> corsi) {
		this.corsi = corsi;
	}
	public Biblioteca getB() {
		return b;
	}
	public void setB(Biblioteca b) {
		this.b = b;
	}
	public Gestione getG() {
		return g;
	}
	public void setG(Gestione g) {
		this.g = g;
	}
	
	//Metodi ausiliari
	public void aggiungiStudente(Studente s){
		this.studenti.put(s.getCodFisc(), s);
		this.b.getUtenti().put(s.getCodFisc(), s);
	}
	public void aggiungiDocente(Docente d){
		this.docenti.put(d.getCodFisc(), d);
		this.b.getUtenti().put(d.getCodFisc(), d);
	}
	public void aggiungiCorso(Corso c){
		this.corsi.put(c.getNome()+"-"+c.getOre(), c);
	}

}