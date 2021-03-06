package libraries;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Esame universitario
 * @author Gabriele Fortunato
 *
 */
@SuppressWarnings("serial")
public class Esame implements Comparable<Esame>,Serializable{
	
	GregorianCalendar data;
	String nome;
	int voto;
	int cfu;
	
	/**
	 * Metodo costruttore
	 * @param data
	 * @param nome
	 * @param voto
	 * @param cfu
	 */
	public Esame(GregorianCalendar data, String nome, int voto, int cfu) {
		this.data = data;
		this.nome = nome;
		this.voto = voto;
		this.cfu = cfu;
	}
	
	public String getNome() {
		return nome;
	}


	public int getVoto() {
		return voto;
	}


	public int getCfu() {
		return cfu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Esame other = (Esame) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public String dataStringa(){
		int giorno = data.get(Calendar.DATE);
		int mese = data.get(Calendar.MONTH)+1;
		int anno = data.get(Calendar.YEAR);
		return giorno+"/"+mese+"/"+anno;
	}
	
	@Override
	public int compareTo(Esame e) {
		// TODO Auto-generated method stub
		return data.compareTo(e.getData());
	}

	public GregorianCalendar getData() {
		return data;
	}

}
	

