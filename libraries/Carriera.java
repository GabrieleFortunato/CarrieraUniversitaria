package libraries;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Metodi di utilit�
 * @author Gabriele Fortunato
 *
 */
public class Carriera implements Iterable<Esame>{

	private ArrayList<Esame> esami;
	private ArrayList<Idoneit�> idoneit�;
	
	public Carriera(){
		this.setEsami(new ArrayList<>());
		this.setIdoneit�(new ArrayList<>());
	}

	private void setEsami(ArrayList<Esame> exams) {
		this.esami = exams;
	}
	
	private void setIdoneit�(ArrayList<Idoneit�> idoneit�) {
		this.idoneit� = idoneit�;
	}

	public ArrayList<Idoneit�> getIdoneit�() {
		return idoneit�;
	}

	public void aggiungiEsame(Esame e){
		esami.add(e);
	}
	
	public void aggiungiIdoneit�(Idoneit� i){
		idoneit�.add(i);
	}
	
	public double aritmean(){
		int sum=0;
		for (Esame e:esami){
			sum += e.getVoto();
		}
		return (double)sum/(double)esami.size();
	}
	
	public double pondmean(){
		int sum=0;
		int sumcfu=0;
		for (Esame e:esami){
			sum += e.getCfu()*e.getVoto();
			sumcfu += e.getCfu();
		}
		return sum/(double)sumcfu;
	}

	@Override
	public Iterator<Esame> iterator() {
		return esami.iterator();
	}
	
}
