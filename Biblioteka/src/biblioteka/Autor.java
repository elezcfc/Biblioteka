package biblioteka;

import java.util.LinkedList;

public class Autor {

	private LinkedList <Autor> autori = new LinkedList<Autor>();

	@Override
	public String toString() {
		return "Autor [autori=" + autori + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autori == null) ? 0 : autori.hashCode());
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
		if (autori == null) {
			if (other.autori != null)
				return false;
		} else if (!autori.equals(other.autori))
			return false;
		return true;
	}
	
	
}
