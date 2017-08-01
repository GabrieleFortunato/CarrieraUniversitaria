package libraries;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Idoneità universitaria
 * @author Gabriele Fortunato
 *
 */
public class Idoneità implements Comparable<Idoneità>{
	
	GregorianCalendar data;
	String nome;
	int cfu;
	
	public String getNome(){
		return nome;
	}
	
	public int getCfu(){
		return cfu;
	}
	
	public Idoneità(GregorianCalendar data, String nome, int cfu){
		this.data = data;
		this.nome = nome;
		this.cfu = cfu;
	}

	@Override
	public int compareTo(Idoneità i) {
		// TODO Auto-generated method stub
		return data.compareTo(i.getData());
	}

	public GregorianCalendar getData() {
		return data;
	}
	
	String data(){
		int giorno = data.get(Calendar.DATE);
		int mese = data.get(Calendar.MONTH)+1;
		int anno = data.get(Calendar.YEAR);
		return giorno+"/"+mese+"/"+anno;
	}
	
	public String toString(){
		return data+" "+nome+" Cfu: "+cfu;
	}
}
