package kolokvijum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBF {

	
	private static Statement stmt;
	private static ResultSet rSet;
	private static PreparedStatement pstmt;
	
	
	public static boolean dodajKnjigu(Knjiga k) {
		
		boolean res = false;
		
		try {
			pstmt = DBConnection.conn().prepareStatement(
					"INSERT INTO Knjiga (inventarni_broj, naslov, godina_izdanja) " + 
					"VALUES (?, ?, ?)");
			pstmt.setInt(1, k.inventarniBroj());
			pstmt.setString(2, k.naslov());
			pstmt.setInt(3, k.godinaIzdanja());
			
			int brRedova = pstmt.executeUpdate();
			
			res = brRedova > 0;
			
		} catch (SQLException e) {
			
			res = false;
			
			System.err.println("Greska prilikom izvrsavanja PreparedStatement objekta -> ");
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.err.println("Greska prilikom zatvaranja PreparedStatement objekta");
					e.printStackTrace();
				}
		}
		
		return res;
	}
	
	
	public static boolean promenaDatumaZaduzenja(int clanskiBroj, int inventarniBroj, String datum) {
		
		boolean res = false;
		
		try {
			
			pstmt = DBConnection.conn().prepareStatement(
					"UPDATE Clan c, Knjiga k, Iznajmljuje i " + 
					"SET datum = ? " + 
					"WHERE i.clanski_broj = ? AND i.inventarni_broj = ?");
			pstmt.setString(1, datum);
			pstmt.setInt(2, clanskiBroj);
			pstmt.setInt(3, inventarniBroj);
			
			int brRedova = pstmt.executeUpdate();
			
			res = brRedova > 0;
			
		} catch (SQLException e) {
			
			res = false;
			
			System.err.println("Greska prilikom izvrsavanja PreparedStatement objekta -> ");
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println("Greska prilikom zatvaranja PreparedStatement objekta -> ");
					e.printStackTrace();
				}
		}
		
		return res;
	}
	
	
	public static boolean brisanjeKnjige(int inventarniBroj) {
		
		boolean res = false;
		
		try {
			DBConnection.conn().setAutoCommit(false);
			
			pstmt = DBConnection.conn().prepareStatement(
					"DELETE FROM Iznajmljuje WHERE inventarni_broj = ?");
			pstmt.setInt(1, inventarniBroj);
			pstmt.executeUpdate();
			
			pstmt = DBConnection.conn().prepareStatement(
					"DELETE FROM Knjiga WHERE inventarni_broj = ?");
			pstmt.setInt(1, inventarniBroj);
			int brRedova = pstmt.executeUpdate();
			
			DBConnection.conn().commit();

			DBConnection.conn().setAutoCommit(true);
			
			res = brRedova > 0;
			
		} catch (SQLException e) {
			
			try {
				DBConnection.conn().rollback();
			} catch (SQLException e0) {
				e0.printStackTrace();
			}
			
			res = false;
			
			System.err.println("Greska prilikom izvrsavanja PreparedStatement objekta -> ");
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e1) {
					System.err.println("Greska prilikom zatvaranja PreparedStatement objekta -> ");
					e1.printStackTrace();
				}
		}
		
		return res;
	}
	
	
	public static void prikazClanovaZaKnjigu(String naslov) {
		
		try {
			stmt = DBConnection.conn().createStatement();
			rSet = stmt.executeQuery(
					"SELECT ime, prezime " + 
					"FROM Clan c, Knjiga k, Iznajmljuje i " + 
					"WHERE k.naslov = '" + naslov + "' AND k.inventarni_broj = i.inventarni_broj AND i.clanski_broj = c.clanski_broj");
			
			System.out.printf("Knjigu '%s' iznajmljuju sledeci korisnici: %n", naslov);
			while (rSet.next())
				System.out.println("\t" + rSet.getString(1) + " " + rSet.getString(2));
		} catch (Exception e) {
			System.err.println("Greska prilikom izvrsavanja Statement objekta -> ");
			e.printStackTrace();
		} finally {
			if (rSet != null)
				try {
					rSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
