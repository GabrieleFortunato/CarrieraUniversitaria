package libraries;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Metodi di utilità
 * @author Gabriele Fortunato
 *
 */
public class Utility {

	public Utility(){
	
	}
	
	/**
	 * Arrotonda un numero decimale
	 * @param a
	 * @param b
	 * @return
	 */
	public static double round(double a, double b){
		return Math.floor(a*Math.pow(10, b))/Math.pow(10, b);
	}
	
	public static String stringaData(GregorianCalendar data){
		int day = data.get(Calendar.DAY_OF_MONTH);
		int month = data.get(Calendar.MONTH);
		int year = data.get(Calendar.YEAR);
		return Integer.toString(day)+"/"+Integer.toString(month+1)+"/"+Integer.toString(year);
	}
	
}
