package prakticne_vezbe.pv04_z02_p01;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBF {

	
	private static PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet rSet;
	
	
	public static boolean dodavanjeRadnika(Radnik r) {
		
		boolean res = false;
		
		try {
			pstmt = DBConnection.conn().prepareStatement(
					"INSERT INTO Radnik (mbr, ime, prz, datr, ozrm)" +
					"VALUES(?, ?, ?, ?, ?)");
			pstmt.setInt(1, r.mbr());
			pstmt.setString(2, r.ime());
			pstmt.setString(3, r.prz());
			pstmt.setString(4, r.datr());
			pstmt.setInt(5, r.ozrm());
			
			int brRedova = pstmt.executeUpdate();
			
			res = brRedova > 0;
			
		} catch (SQLException e) {
			
			res = false;
			
			System.err.println("Greska prilikom izvrsavanja PreparedStatement objekta -> ");
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.err.println("Greska prilikom zatvaranja konekcije -> ");
					e.printStackTrace();
				}
			}
		}
		
		return res;
	}
	
	
	public static boolean brisanjeRadnogMesta(int ozrm) {
		
		boolean res = false;
		
		try {
			DBConnection.conn().setAutoCommit(false);
			
			pstmt = DBConnection.conn().prepareStatement(
					"DELETE FROM Radnik WHERE ozrm = ?");
			pstmt.setInt(1, ozrm);
			pstmt.executeUpdate();
			
			pstmt = DBConnection.conn().prepareStatement(
					"DELETE FROM RadnoMesto WHERE ozrm = ?");
			pstmt.setInt(1, ozrm);
			int brRedova = pstmt.executeUpdate();
			
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
					System.out.println("Greska prilikom zatvaranja PreparedStatement objekta -> ");
					e1.printStackTrace();
				}
		}
		
		return res;
	}
	
	
	public static void prikaziRadnike(int ozrm) {
		
		try {
			stmt = DBConnection.conn().createStatement();
			rSet = stmt.executeQuery(
					"SELECT * FROM Radnik r " + 
					"WHERE r.ozrm = " + ozrm);
			
			while (rSet.next())
				System.out.println(rSet.getString(2) + " " + rSet.getString(3));
			
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
	
	
	public static boolean promenaPrezimena(int mbr, String prz) {
		
		boolean res = false;
		
		try {
			pstmt = DBConnection.conn().prepareStatement(
					"UPDATE Radnik " +
					"SET prz = ? " +
					"WHERE mbr = ?");
			pstmt.setString(1, prz);
			pstmt.setInt(2, mbr);
			
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
