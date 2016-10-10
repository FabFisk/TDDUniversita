package universita;

public class Segreteria {

	public Studente registraStudente(Universita u, String nome, String cognome, String codFisc) throws StudenteGiaEsiste {
		
		if(u.getStudenti().containsKey(codFisc)){
			throw new StudenteGiaEsiste();
		}
		Studente s = new Studente (nome, cognome, codFisc);
		u.aggiungiStudente(s);
		s.setMatricola("S"+u.getStudenti().size());
		return s;
	}

	public Docente registraDocente(Universita u, String nome, String cognome, String codFisc) throws DocenteGiaEsiste {
		
		if(u.getDocenti().containsKey(codFisc)){
			throw new DocenteGiaEsiste();
		}		
		Docente d = new Docente(nome, cognome, codFisc);
		u.aggiungiDocente(d);
		return d;
	}

	public Corso registraCorso(Universita u, String nome, int ore) throws CorsoGiaEsiste {
		if(u.getCorsi().containsKey(nome+"-"+ore)){
			throw new CorsoGiaEsiste();
		}
		Corso c = new Corso(nome, ore);
		u.aggiungiCorso(c);
		return c;
	}

	public boolean aggiungiStudente(Universita u, Studente s, Corso c) {
		boolean token = false;
		if(!c.getIscritti().containsValue(s)){
			c.aggiungiStudente(s);
			token = true;
		}		
		return token;
	}

	public boolean aggiungiDocente(Universita u, Docente d, Corso c) {
		boolean token = false;
		if(!c.getDocenti().containsValue(d)){
			c.aggiungiDocente(d);
			token = true;
		}		
		return token;
	}

}