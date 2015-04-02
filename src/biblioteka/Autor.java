package biblioteka;

/**
 * Ova klasa predstavlja autora knjige. 
 * @author Elez Stefan
 * @version 1.0
 *
 */
public class Autor { //testiracemo sav automatski ne generisani kod
	
	/**
	 * ime autora
	 */
	private String ime;
	
	/**
	 * prezime autora
	 */
	private String prezime;

	/**
	 * Vraca vrednost atributa ime
	 * @return ime autora kao string
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Metoda postavlja vrednost atributa ime na unetu vrednost
	 * @param ime Nova vrednost za ime autora
	 * @throws java.lang.RuntimeException kada je 
	 * <ul>
	 * <li> uneto ime null </li> 
	 * <li> prazan String</li> 
	 * </ul>
	 */
	public void setIme(String ime) {
		if(ime == null || ime.isEmpty()){
			throw new RuntimeException ("Morate uneti ime");
		}
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		if(prezime == null || prezime.isEmpty()){
			throw new RuntimeException ("Morate uneti prezime");
		}
		this.prezime = prezime;
	}

	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		return true;
	}
	
	

}
