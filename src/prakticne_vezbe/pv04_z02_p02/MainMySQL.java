package prakticne_vezbe.pv04_z02_p02;

public class MainMySQL {

	public static void main(String[] args) {
		
		Radnik r = new Radnik(3, "Janko", "Jankovic", "20-02-1970", 2);
		
		try {
			if (DBF.dodajRadnika(r))
				System.out.println("Unet radnik!");
			else
				System.out.println("Nije unet radnik...");
			
			if (DBF.brisanjeRadnogMesta(2))
				System.out.println("Obrisano radno mesto!");
			else
				System.out.println("Nije obrisano radno mesto...");
			
			DBF.prikazRadnika(1);
			
			if (DBF.promenaPrezimena(1, "Miloradovic"))
				System.out.println("Promenjeno prezime!");
			else
				System.out.println("Nije promenjeno prezime...");
			
		} catch (Exception e) {
			System.err.println("Greska u glavnom programu -> ");
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
	}
}
