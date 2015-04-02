package biblioteka;

import java.util.LinkedList;

public interface BibliotekaInterface {

	public void dodajKnjigu(Knjiga knjiga);
	public void izbaciKnjigu(Knjiga knjiga);
	public LinkedList<Knjiga> vratiSveKnjige();
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, long ISBN, String naslov, String izdavac);
}
