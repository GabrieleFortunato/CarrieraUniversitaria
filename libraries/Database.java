package libraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

/**
 * Interazione con il database
 * @author Gabriele Fortunato
 *
 */
public class Database {
	
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "esami";
	static String dbNameLogin = "login";
	static String driver = "com.mysql.jdbc.Driver";
	static String userName = "root"; 
	static String password = "qrnq946";
	
	static GregorianCalendar data(String data){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar c = new GregorianCalendar();
		try{
			c.setTime(sdf.parse(data));
		} 
		catch (ParseException e){
			e.printStackTrace();
		} 
		return c;
	}
	
	
	public static Idoneit‡[] idoneit‡Array(){
		ArrayList<Idoneit‡> listaidoneit‡ = idoneit‡();
		Idoneit‡[] idoneita = new Idoneit‡[listaidoneit‡.size()];
		for (int i=0;i<listaidoneit‡.size();i++){
			idoneita[i] = listaidoneit‡.get(i);
		}
		return idoneita;
	}
	
	public static Esame[] esamiArray(){
		ArrayList<Esame> listaesami = esami();
		Esame[] esami = new Esame[listaesami.size()];
		for (int i=0;i<listaesami.size();i++){
			esami[i] = listaesami.get(i);
		}
		return esami;
		
	}
	
	private static ArrayList<Esame> esami(){
		ArrayList<Esame> list = new ArrayList<>();
		try {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(
					url+dbName+"?autoReconnect=true&useSSL=false",userName,password
			);
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(
					"select day(data),month(data),year(data),denominazione,voto,cfu "
					+ "from esami order by data"
			);
			while (res.next()) {
				int giorno = res.getInt("day(data)");
				int mese = res.getInt("month(data)");
				int anno = res.getInt("year(data)");
				GregorianCalendar data = new GregorianCalendar(anno,mese-1,giorno);
				String nome = res.getString("denominazione");
				int voto = res.getInt("voto");
				int cfu = res.getInt("cfu");
				list.add(new Esame(data,nome,voto,cfu));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(list);
		return list;
	}
	
	private static ArrayList<Idoneit‡> idoneit‡(){
		ArrayList<Idoneit‡> list = new ArrayList<>();
		try {
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(
					url+dbName+"?autoReconnect=true&useSSL=false",userName,password
			);
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery(
					"select day(data),month(data),year(data),denominazione,cfu "
					+ "from idoneita order by day(data)"
			);
			while (res.next()) {
				int giorno = res.getInt("day(data)");
				int mese = res.getInt("month(data)");
				int anno = res.getInt("year(data)");
				GregorianCalendar data = new GregorianCalendar(anno,mese-1,giorno);
				String nome = res.getString("denominazione");
				int cfu = res.getInt("cfu");
				list.add(new Idoneit‡(data,nome,cfu));
				Thread.sleep(500);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
