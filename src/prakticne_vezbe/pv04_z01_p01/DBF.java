package prakticne_vezbe.pv04_z01_p01;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBF {

	
	private static PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet rSet;
	
	
	public static boolean dodavanjeNastavnika(Nastavnik n) {
		
		boolean res = false;
		
		try {
			pstmt = DBConnection.conn().prepareStatement(
					"INSERT INTO Nastavnik (nastavnik_Id, ime, prezime, zvanje) " +
					"VALUES(?, ?, ?, ?)");
			pstmt.setInt(1, n.idNastavnika());
			pstmt.setString(2, n.ime());
			pstmt.setString(3, n.prezime());
			pstmt.setString(4, n.zvanje());
			
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
					System.err.println("Greska prilikom zatvaranja PreparedStatement objekta -> ");
					e.printStackTrace();
				}
		}
		
		return res;
	}
	
	
	public static boolean brisanjeNastavnika(int idNastavnika) {
		
		boolean res = false;
		
		try {
			DBConnection.conn().setAutoCommit(false);
			
			pstmt = DBConnection.conn().prepareStatement("DELETE FROM Predaje WHERE nastavnik_Id = ?");
			pstmt.setInt(1, idNastavnika);
			pstmt.executeUpdate();
			
			pstmt = DBConnection.conn().prepareStatement("DELETE FROM Nastavnik WHERE nastavnik_Id = ?");
			pstmt.setInt(1, idNastavnika);
			int brRedova = pstmt.executeUpdate();
			
			DBConnection.conn().commit();

			DBConnection.conn().setAutoCommit(true);
			
			res = brRedova > 0;
			
		} catch (Exception e) {
			
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
	
	
	public static void prikazPredmeta(int idNastavnika) {
		
		try {
			stmt = DBConnection.conn().createStatement();
			rSet = stmt.executeQuery(
					"SELECT naziv FROM Predmet p, Predaje pr " +
					"WHERE p.predmet_Id = pr.predmet_Id AND pr.nastavnik_Id = " + idNastavnika);
			
			while (rSet.next())
				System.out.println(rSet.getString(1));
		} catch (Exception e) {
			System.err.println("Greska prilikom prikaza predmeta -> ");
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			if (rSet != null)
				try {
					rSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	
	public static boolean promenaPrezimena(int idNastavnika, String prezime) {
		
		boolean res = false;
		
		try {
			
			pstmt = DBConnection.conn().prepareStatement(
					"UPDATE Nastavnik " +
					"SET prezime = ? " +
					"WHERE nastavnik_Id=?");
			
			pstmt.setString(1, prezime);
			pstmt.setInt(2, idNastavnika);
			
			int brRedova = pstmt.executeUpdate();
			
			res = brRedova > 0;
			
		} catch (SQLException e) {
			
			res = false;
			
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return res;
	}
}
