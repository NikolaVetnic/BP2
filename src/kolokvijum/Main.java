package kolokvijum;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		Clan c = new Clan(6, "Ime", "Prezime", "Adresa");
		Knjiga k = new Knjiga(6, "Naslov", 2021);
		
		try {
			if (DBF.dodajKnjigu(k))
				System.out.println("Knjiga dodata!");
			else
				System.out.println("Knjiga nije dodata...");
			
			if (DBF.promenaDatumaZaduzenja(2, 1, "2021-12-31"))
				System.out.println("Promenjen datum!");
			else
				System.out.println("Nije promenjen datum...");
			
			if (DBF.brisanjeKnjige(5))
				System.out.println("Obrisana knjiga!");
			else
				System.out.println("Nije obrisana knjiga...");
			
			DBF.prikazClanovaZaKnjigu("Za kim zvona zvone");
		} catch (Exception e){
			System.err.println("Greska u glavnom programu -> ");
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
	}
}
