package prakticne_vezbe.pv04_z01_p01;

public class MainMySQL {

	
	public static void main(String[] args) {
		
		try {
			Nastavnik nastavnik = new Nastavnik(6, "Marko", "Savic", "docent");
			
			if (DBF.dodavanjeNastavnika(nastavnik))
				System.out.println("Unet nastavnik!");
			else
				System.err.println("Nije unet nastavnik!");
			
			if (DBF.brisanjeNastavnika(nastavnik.idNastavnika()))
				System.out.println("Obrisan nastavnik!");
			else
				System.err.println("Nije obrisan nastavnik!");
			
			DBF.prikazPredmeta(3);
			
			if (DBF.promenaPrezimena(1, "Peric"))
				System.out.println("Promenjeno prezime!");
			else
				System.err.println("Nije promenjeno prezime!");
		} catch (Exception e) {
			System.err.println("Greska u glavnom programu -> ");
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
	}
}
