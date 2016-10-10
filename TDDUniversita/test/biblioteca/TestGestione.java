package biblioteca;


import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.*;

public class TestGestione {
	
	static Gestione g;
	static Biblioteca b;
	static Libro l1 ;
	static Libro l2 ;
	static Libro l3 ;
	static Libro l4 ;
	static Libro l5 ;
	static Utente u1;
	static Utente u2;
	
	@BeforeClass
	public static void setUp(){
		g = new Gestione();
		b = new Biblioteca("Biblioteca Civica");
		l1 = new Libro("aaaa", "aaa", "Libro001");
		l1.setCopieDisp(1);
		l1.setCopieTot(1);
		b.getLibri().put(l1.getSerialNum(), l1);
		l2 = new Libro("bbb", "bbb", "Libro002");
		l2.setCopieDisp(1);
		l2.setCopieTot(1);
		b.getLibri().put(l2.getSerialNum(), l2);
		l3 = new Libro("ccc", "ccc", "Libro003");
		l3.setCopieDisp(1);
		l3.setCopieTot(1);
		b.getLibri().put(l3.getSerialNum(), l3);
		l4 = new Libro("ddd", "ddd", "Libro004");
		l4.setCopieDisp(1);
		l4.setCopieTot(1);
		b.getLibri().put(l4.getSerialNum(), l4);
		l5 = new Libro("eee", "eee", "Libro005");
		l5.setCopieDisp(1);
		l5.setCopieTot(1);
		b.getLibri().put(l5.getSerialNum(), l5);
		u1 = new Utente ("Giovanni", "Blu", "GioBlu001");
		b.getUtenti().put(u1.getCodFisc(), u1);
		u2 = new Utente ("Maria", "Bianca", "MarBia002");
		b.getUtenti().put(u2.getCodFisc(), u2);
	}
	
	public void testNotNul(){
		assertNotNull(g);
		assertNotNull(b);
	}
	
	@Test
	public void testRegistraLibro() {
		Libro l1 = g.registraLibro(b, "1984", "Orwell", "Libro006", 4);
		
		assertNotNull(l1);
		assertEquals(4, l1.getCopieDisp());
		assertEquals(4, l1.getCopieTot());
		
	}
	
	@Test
	public void testRegistraLibroAggiungeNonDuplica() {
		Libro l1 = g.registraLibro(b, "1984", "Orwell", "Libro006", 4);
		assertEquals(6, b.getLibri().size());
		assertEquals(8, l1.getCopieTot());
	}
	
	@Test
	public void testRegistraUtente() throws UtenteGiaEsiste {
		Utente u = g.registraUtente(b, "Mario", "Rossi", "MarRos003");
		assertNotNull(u);
		assertEquals(4, b.getUtenti().size());
	}
	
	@Test
	public void testRegistraUtente2() {
		try{
			Utente u1 = g.registraUtente(b, "Marco", "Verdi", "MarVer004");
			Utente u2 = g.registraUtente(b, "Marco", "Verdi", "MarVer004");
			fail();
		}catch(Exception e){
			e.getMessage();
		}
	}
	
	@Test
	public void testPrestaLibro() throws UtenteGiaEsiste {	
		boolean token = g.prestaLibro(b, "GioBlu001", "Libro001");
		boolean token1 = g.prestaLibro(b, "MarBia002", "Libro002");
		boolean token2 = g.prestaLibro(b, "MarBia002", "Libro002");
		boolean token3 = g.prestaLibro(b, "MarBia002", "Libro003");
		boolean token4 = g.prestaLibro(b, "MarBia002", "Libro004");
		boolean token5 = g.prestaLibro(b, "MarBia002", "Libro005");
		
		assertTrue(token);
		assertEquals(1, u1.getLibri().size());
		assertEquals(3, u2.getLibri().size());
		assertEquals(4, b.getPrestiti().size());
	}
	

	
	@Test
	public void testRestituisciLibro() {
		
		boolean token = g.restituisciLibri(b, "Libro001", "GioBlu001");
		assertTrue(token);
		assertEquals(0, u1.getLibri().size());
		assertEquals(4, b.getPrestiti().size());
		
	}
}