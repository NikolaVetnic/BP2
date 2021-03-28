package prakticne_vezbe.pv04_z02_p01;

public class MainMySQL {

	public static void main(String[] args) {
		
		try {
			Radnik r = new Radnik(3, "Milan", "Milanov", "20-02-1980", 1);
			
			if (DBF.dodavanjeRadnika(r))
				System.out.println("Unet radnik!");
			else
				System.out.println("Nije unet radnik!");
			
			if (DBF.brisanjeRadnogMesta(1))
				System.out.println("Obrisano radno mesto!");
			else
				System.out.println("Nije obrisano radno mesto!");
			
			DBF.prikaziRadnike(1);
			
			if (DBF.promenaPrezimena(2, "Nedic"))
				System.out.println("Promenjeno prezime!");
			else
				System.out.println("Nije promenjeno prezime!");
			
			if (DBF.promenaPrezimena(2, "Ivanovic"))
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
