/**
 * 
 */
package biblioteka;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AutorTest {//testove pisemo u toku pisanja programa

	private Autor autor;
	@Before
	public void setUp() throws Exception {
		autor = new Autor();
	}
	@After
	public void tearDown() throws Exception {
		autor = null; //moze i ne mora, svakako ga kupi Garbage collector
	}

	@Test
	public void testSetIme() {
		
		/*Autor autor  = new Autor(); (ide za svaku metodu ili... ^)
		 * bocni efekat - ako istu instancu autor iskoristimo za 2 testa, testovi ce 
		 * zavisiti jedan od drugod. Zato za svaki test prave nove instance
		 * ali se one brisu po zavrsetku testova. Za to sluze metode set up i tear down
		 * 
		 * setup()
		 * test1        }pa ponovi za svaki test
		 * tearDown();
		 * 
		 */
		
		autor.setIme("Pera");
		
		assertEquals("Pera", autor.getIme());//preklopljena metoda, 2 parametra: ocekivana i stv vrednost
		/*
		 * moze da proverava i klase, pozivanjem equals metode. Ako su 2 parametra =, test prolazi
		 */
	}
	
	@Test (expected = java.lang.RuntimeException.class)//ako ocekujemo da baci izuzetak
	public void testSetImeNull() {
		
		autor.setIme(null);//da nismo stavili ovo u notaciji, program bi pukao
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetImeEmptyString() {
		
		autor.setIme("");//PRAZAN STRING - znaci nema blanko znak (" ") test bi pao
	}
	
	@Test
	public void testSetPrezime() {
		autor.setPrezime("Peric");
		assertEquals("Peric", autor.getPrezime());
		//assertTrue(autor.getPrezime.equals("Peric"));
		//ekvivalentne metode, ima ih jos
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPrezimeNull() {
		autor.setPrezime(null);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPrezimeEmptyString() {
		
		autor.setPrezime("");//PRAZAN STRING - znaci nema blanko znak (" ") test bi pao
	}
}
