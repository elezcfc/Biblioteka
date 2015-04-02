package biblioteka;

public class Knjiga {

	public String naslov;
	public String ISBN;
	public String autor;
	public String izdavac;
	public String izdanje;
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getIzdavac() {
		return izdavac;
	}
	public void setIzdavac(String izdavac) {
		this.izdavac = izdavac;
	}
	public String getIzdanje() {
		return izdanje;
	}
	public void setIzdanje(String izdanje) {
		this.izdanje = izdanje;
	}
	@Override
	public String toString() {
		return "Knjiga [naslov=" + naslov + ", ISBN=" + ISBN + ", autor="
				+ autor + ", izdavac=" + izdavac + ", izdanje=" + izdanje + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((izdanje == null) ? 0 : izdanje.hashCode());
		result = prime * result + ((izdavac == null) ? 0 : izdavac.hashCode());
		result = prime * result + ((naslov == null) ? 0 : naslov.hashCode());
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
		Knjiga other = (Knjiga) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (izdanje == null) {
			if (other.izdanje != null)
				return false;
		} else if (!izdanje.equals(other.izdanje))
			return false;
		if (izdavac == null) {
			if (other.izdavac != null)
				return false;
		} else if (!izdavac.equals(other.izdavac))
			return false;
		if (naslov == null) {
			if (other.naslov != null)
				return false;
		} else if (!naslov.equals(other.naslov))
			return false;
		return true;
	}
	
	
}
