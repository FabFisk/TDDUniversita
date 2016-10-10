package universita;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import universita.*;

public class TestSegreteria {

	static Universita uni;
	static Segreteria seg;
	static Docente doc;
	static Studente stu;
	static Corso cor;
	
	@BeforeClass
	public static void setUp(){
		uni = new Universita("Polito");
		seg = new Segreteria();
		doc = new Docente("Pippo", "Pappo", "PipPap001");
		stu = new Studente("Marco", "Marchi", "MarMar001");
		cor = new Corso("Java", 320);
		uni.aggiungiDocente(doc);
		uni.aggiungiStudente(stu);
		uni.getCorsi().put(cor.getNome()+"-"+cor.getOre(), cor);
	}
	
	@Test
	public void setUpNotNull(){
		assertNotNull(uni);
		assertNotNull(seg);
		assertNotNull(doc);
		assertNotNull(stu);
		assertNotNull(cor);
		assertEquals(2, uni.getCorsi().size());
		assertEquals(2, uni.getDocenti().size());
		assertEquals(2, uni.getStudenti().size());
	}
	
	@Test
	public void registraStudente(){
		Studente s1=null;
		Studente s2=null;
		try{
			s1 = seg.registraStudente(uni, "aaa", "aaa", "aaaaaa002");
			s2 = seg.registraStudente(uni, "aaa", "aaa", "aaaaaa002");
			fail("Mi aspettavo una eccezione!");
			
		}catch(Exception e){
			e.getMessage();
		}		
		assertNotNull(s1);
		assertEquals(2, uni.getStudenti().size());
		assertEquals(3, uni.getB().getUtenti().size());
	}
	
	@Test
	public void registraDocente(){
		Docente d1=null;
		Docente d2=null;
		try{
			d1 = seg.registraDocente(uni, "aaa", "aaa", "aaaaaa003");
			d2 = seg.registraDocente(uni, "aaa", "aaa", "aaaaaa003");
			fail("Mi aspettavo una eccezione!");
			
		}catch(Exception e){
			e.getMessage();
		}		
		assertNotNull(d1);
		assertEquals(2, uni.getDocenti().size());
		assertEquals(4, uni.getB().getUtenti().size());
	}
	
	@Test
	public void registraCorso(){
		Corso c1 = null;
		Corso c2 = null;
		try{
			c1 = seg.registraCorso(uni, "Java", 200);
			c2 = seg.registraCorso(uni, "Java", 200);
			fail("Mi aspettavo una eccezione!");
		}catch(CorsoGiaEsiste e){
			e.getMessage();
		}
		assertNotNull(c1);
		assertEquals(2, uni.getCorsi().size());
	}
	
	@Test
	public void aggiungiStudente(){
		boolean token1 = false;
		boolean token2 = true;
		
		token1 = seg.aggiungiStudente(uni, stu, cor);
		token2 = seg.aggiungiStudente(uni, stu, cor);
		
		assertTrue(token1);
		assertFalse(token2);
		assertEquals(1, cor.getIscritti().size());
		
		
	}
	
	@Test
	public void aggiungiDocente(){
		boolean token1 = false;
		boolean token2 = true;
		
		token1 = seg.aggiungiDocente(uni, doc, cor);
		token2 = seg.aggiungiDocente(uni, doc, cor);
		
		assertTrue(token1);
		assertFalse(token2);
		assertEquals(1, cor.getDocenti().size());
	}
	
}