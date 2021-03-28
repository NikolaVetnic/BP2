package prakticne_vezbe.pv04_z01_p02;

public class MainMySQL {

	public static void main(String[] args) {
		
		try {
			Nastavnik nastavnik = new Nastavnik(6, "Ivan", "Pribela", "asistent");
			
			if (DBF.dodavanjeNastavnika(nastavnik))
				System.out.println("Unet nastavnik!");
			else
				System.out.println("Nije unet nastavnik!");
			
			if (DBF.brisanjeNastavnika(nastavnik.idNastavnika()))
				System.out.println("Obrisan nastavnik!");
			else
				System.out.println("Nije obrisan nastavnik!");
			
			DBF.prikazPredmeta(3);
			
			if (DBF.promenaPrezimena(1, "Andric"))
				System.out.println("Promenjeno prezime!");
			else
				System.out.println("Nije promenjeno prezime!");
			
		} catch (Exception e) {
			System.err.println("Greska u glavnom programu -> ");
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
	}
}
