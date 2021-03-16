package prakticne_vezbe.pv03_z03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nastavnik {
	
	private int id;
	private String ime, prezime, zvanje;

	private Nastavnik(int id, String ime, String prezime, String zvanje) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.zvanje = zvanje;
	}
	
	public static Nastavnik unesi() {
		
		int 	id = -1;
		String 	ime = null, 
				prezime = null, 
				zvanje = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		System.out.println("=-= NOVI NASTAVNIK =-=");
		
		try {
			System.out.printf("%-10s : ", "ID");
			input = br.readLine();
			id = Integer.parseInt(input);
			
			System.out.printf("%-10s : ", "IME");
			input = br.readLine();
			ime = input.trim();
			
			System.out.printf("%-10s : ", "PREZIME");
			input = br.readLine();
			prezime = input.trim();
			
			System.out.printf("%-10s : ", "ZVANJE");
			input = br.readLine();
			zvanje = input.trim();
			
			System.out.println();
			
			return new Nastavnik(id, ime, prezime, zvanje);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getInsert() {
		return String.format("VALUES (%d, '%s', '%s', '%s')", id, ime, prezime, zvanje);
	}
	
	public String getDelete() {
		return "DELETE FROM Nastavnik WHERE nastavnik_id = " + id;
	}
	
	public String getDeleteFromPredaje() {
		return "DELETE FROM Predaje WHERE nastavnik_id = " + id;
	}

	public int id() 		{ return id; 		}
	public String ime() 	{ return ime; 		}
	public String prezime() { return prezime; 	}
	public String zvanje() 	{ return zvanje; 	}
}
