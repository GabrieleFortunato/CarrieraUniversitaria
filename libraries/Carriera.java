package libraries;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Metodi di utilitÓ
 * @author Gabriele Fortunato
 *
 */
public class Carriera implements Iterable<Esame>{

	private ArrayList<Esame> esami;
	private ArrayList<IdoneitÓ> idoneitÓ;
	
	public Carriera(){
		this.setEsami(new ArrayList<>());
		this.setIdoneitÓ(new ArrayList<>());
	}

	private void setEsami(ArrayList<Esame> exams) {
		this.esami = exams;
	}
	
	private void setIdoneitÓ(ArrayList<IdoneitÓ> idoneitÓ) {
		this.idoneitÓ = idoneitÓ;
	}

	public ArrayList<IdoneitÓ> getIdoneitÓ() {
		return idoneitÓ;
	}

	public void aggiungiEsame(Esame e){
		esami.add(e);
	}
	
	public void aggiungiIdoneitÓ(IdoneitÓ i){
		idoneitÓ.add(i);
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
