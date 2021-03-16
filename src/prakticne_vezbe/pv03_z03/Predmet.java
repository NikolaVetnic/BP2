package prakticne_vezbe.pv03_z03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Predmet {
	
	private int id;
	private String naziv;

	private Predmet(int id, String naziv) {
		this.id = id;
		this.naziv = naziv;
	}
	
	public static Predmet unesi() {
		
		int 	id = -1;
		String 	naziv = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		System.out.println("=-= NOVI PREDMET =-=");
		
		try {
			System.out.printf("%-10s : ", "ID");
			input = br.readLine();
			id = Integer.parseInt(input);
			
			System.out.printf("%-10s : ", "NAZIV");
			input = br.readLine();
			naziv = input.trim();

			System.out.println();
			
			return new Predmet(id, naziv);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getInsert() {
		return String.format("VALUES (%d, '%s')", id, naziv);
	}
	
	public String getDelete() {
		return "DELETE FROM Predmet WHERE predmet_id = " + id;
	}
	
	public String getDeleteFromPredaje() {
		return "DELETE FROM Predaje WHERE predmet_id = " + id;
	}

	public int id() 		{ return id; 		}
	public String naziv() 	{ return naziv; 	}
}
