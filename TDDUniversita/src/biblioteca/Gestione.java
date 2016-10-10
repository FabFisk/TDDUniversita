package biblioteca;

import java.util.Calendar;
import java.util.Date;

import static utility.DataUtility.*;

public class Gestione {

	public Libro registraLibro(Biblioteca b, String titolo, String autore, String serialNum, int copie) {
		Libro l = b.getLibri().get(serialNum);
		if(l == null){
			l = new Libro(titolo, autore, serialNum);
			b.aggiungiLibro(l);
		}		
		l.setCopieTot(l.getCopieTot()+copie);
		l.setCopieDisp(l.getCopieDisp()+copie);
		return l;
	}

	public Utente registraUtente(Biblioteca b, String nome, String cognome, String codFisc) throws UtenteGiaEsiste {
		if(b.getUtenti().containsKey(codFisc)){	
			throw new UtenteGiaEsiste();
			}
		Utente u = new Utente(nome, cognome, codFisc);
		b.aggiungiUtente(u);
		return u;
	}

	public boolean prestaLibro(Biblioteca b, String codFisc, String serialNum) {
		boolean token = false;
		Utente u = null;
		u = b.getUtenti().get(codFisc);
		Libro l = null;
		l = b.getLibri().get(serialNum);
		
		if(l!=null && b!=null
				&& u.getNumeroLibri()<3
				&& l.getCopieDisp()>0){
			
			Date today = new Date();
			Calendar cal = utilDateToCalendar(today);
			cal.add(Calendar.DATE, 14);
			Date dataScadenza = cal.getTime();
			Prestito p = new Prestito(u, l, today);
			p.setDataScad(dataScadenza);
			u.aggiungiLibro(l);
			b.getPrestiti().put(codFisc+"-"+serialNum, p);
			l.setCopieDisp(l.getCopieDisp()-1);
			token = true;
		
		}		
		return token;		
	}

	public boolean restituisciLibri(Biblioteca b, String serialNum, String cf) {
		boolean token = false;
		Libro l = null;
		l = b.getLibri().get(serialNum);
		Utente u = null;
		u = b.getUtenti().get(cf);
		Prestito p = null;
		p = b.getPrestiti().get(cf+"-"+serialNum);
		
		if(l!=null && u!=null && p!=null && p.getDataRest()==null){
			Date today = new Date();
			p.setDataRest(today);
			u.getLibri().remove(serialNum);
			token = true;
		}
		
		return token;
	}
	
	
	
	
	

}