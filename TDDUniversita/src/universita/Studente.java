package universita;

import biblioteca.*;

public class Studente extends Utente {
	
	private String matricola;
	
	public Studente(){
		super();
	}
	public Studente(String nome, String cognome, String codFisc){
		super(nome, cognome, codFisc);
	}
	
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
}