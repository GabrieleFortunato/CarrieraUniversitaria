package libraries;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Iterator;

/**
 * Stampa su file
 * @author Gabriele Fortunato
 *
 */
public class PrintOnFile {
	
	private static void stampaEsame(PrintStream output, Esame e){
		output.println("DATA: "+e.dataStringa());
		output.println("INSEGNAMENTO: "+e.getNome());
		output.println("VOTO: "+e.getVoto());
		output.println("CFU: "+e.getCfu());
		output.print("===========================");
		output.print("===========================");
		output.println("===========================");
	}
	
	private static void stampaIdoneità(PrintStream output, Idoneità i){
		output.println("DATA: "+i.data());
		output.println("INSEGNAMENTO: "+i.getNome());
		output.println("CFU: "+i.getCfu());
		output.print("===========================");
		output.print("===========================");
		output.println("===========================");
	}
	
	public static void printOnFile(Carriera carriera) throws FileNotFoundException{
		PrintStream output = new PrintStream(new File("carriera universitaria.txt"));
		output.println();
		output.println("ESAMI SUPERATI");
		output.println();
		Iterator<Esame> iter = carriera.iterator();
		while (iter.hasNext()){
			stampaEsame(output,iter.next());
		}
		output.println();
		output.println("IDONEITA' OTTENUTE");
		output.println();
		for (Idoneità i:carriera.getIdoneità()){
			stampaIdoneità(output,i);
		}
		output.println("\n\n\nMedia aritmetica: "+Utility.round(carriera.aritmean(), 2));
		output.println("Media ponderale: "+Utility.round(carriera.pondmean(), 2));
		output.flush();
		output.close();
	}

}