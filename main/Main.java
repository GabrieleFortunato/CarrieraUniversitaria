package main;

import java.io.FileNotFoundException;

import libraries.Database;
import libraries.Esame;
import libraries.Idoneit‡;
import libraries.Carriera;
import libraries.PrintOnFile;

/**
 * Classe con il metodo main
 * @author Gabriele Fortunato
 *
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Esame[] esami = Database.esamiArray();
		Idoneit‡[] idoneit‡ = Database.idoneit‡Array();
		Carriera carriera = carriera(esami,idoneit‡);
		PrintOnFile.printOnFile(carriera);
		chiudiProgramma();

	}
	
	private static void chiudiProgramma(){
		System.out.println();
		System.out.println("Creato il file \"carriera universitaria.txt\"");
		System.out.println();
		System.out.println("Fine programma");
		System.out.println();
	}

	private static Carriera carriera(Esame[] esami, Idoneit‡[] idoneit‡){
		Carriera carriera = new Carriera();
		for (Esame e:esami){
			carriera.aggiungiEsame(e);
		}
		for (Idoneit‡ i:idoneit‡){
			carriera.aggiungiIdoneit‡(i);
		}
		return carriera;
	}
	
	
}
