package biblioteka;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BibliotekaTest {
	
	private Biblioteka biblioteka;

	@Before
	public void setUp() throws Exception {
		biblioteka = new Biblioteka();
	}

	@After
	public void tearDown() throws Exception {
		biblioteka = null;
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testDodajKnjiguNull() {
		biblioteka.dodajKnjigu(null);
	}

	@Test 
	public void testDodajKnjigu() {
		Knjiga knjiga = new Knjiga();
		
		biblioteka.dodajKnjigu(knjiga);
		
		assertEquals(1, biblioteka.getKnjige().size());
		assertEquals(knjiga, biblioteka.getKnjige().get(0));
	}
	
	@Test 
	public void testDodajKnjigu2() {
		Knjiga knjiga1 = new Knjiga();
		knjiga1.setISBN(123);
		Knjiga knjiga2 = new Knjiga();
		knjiga2.setISBN(77);
		
		biblioteka.dodajKnjigu(knjiga1);
		biblioteka.dodajKnjigu(knjiga2);
		
		assertEquals(2, biblioteka.getKnjige().size());
		assertEquals(knjiga1, biblioteka.getKnjige().get(0));
		assertEquals(knjiga2, biblioteka.getKnjige().get(1));
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testDodajKnjiguDuplikat() {
		Knjiga knjiga1 = new Knjiga();
		knjiga1.setISBN(123);
		Knjiga knjiga2 = new Knjiga();
		knjiga2.setISBN(123);
		
		biblioteka.dodajKnjigu(knjiga1);
		biblioteka.dodajKnjigu(knjiga2);

	}
}
