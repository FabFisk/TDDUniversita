package biblioteca;

import java.util.Date;

public class Prestito {
	
	private Utente utente;
	private Libro libro;
	private Date dataPrestito;
	private Date dataScad;
	private Date dataRest;
	
	public Prestito(){}
	public Prestito(Utente u, Libro l, Date data){
		this.utente = u;
		this.libro = l;
		this.dataPrestito = data;
		this.dataScad = null;
		this.dataRest = null;
	}
	
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Date getDataPrestito() {
		return dataPrestito;
	}
	public void setDataPrestito(Date dataPrestito) {
		this.dataPrestito = dataPrestito;
	}
	public Date getDataScad() {
		return dataScad;
	}
	public void setDataScad(Date dataScad) {
		this.dataScad = dataScad;
	}
	public Date getDataRest() {
		return dataRest;
	}
	public void setDataRest(Date dataRest) {
		this.dataRest = dataRest;
	}
}