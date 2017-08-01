package libraries;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Metodi di utilità
 * @author Gabriele Fortunato
 *
 */
public class Carriera implements Iterable<Esame>{

	private ArrayList<Esame> esami;
	private ArrayList<Idoneità> idoneità;
	
	public Carriera(){
		this.setEsami(new ArrayList<>());
		this.setIdoneità(new ArrayList<>());
	}

	private void setEsami(ArrayList<Esame> exams) {
		this.esami = exams;
	}
	
	private void setIdoneità(ArrayList<Idoneità> idoneità) {
		this.idoneità = idoneità;
	}

	public ArrayList<Idoneità> getIdoneità() {
		return idoneità;
	}

	public void aggiungiEsame(Esame e){
		esami.add(e);
	}
	
	public void aggiungiIdoneità(Idoneità i){
		idoneità.add(i);
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
