package prakticne_vezbe.pv03_z03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import prakticne_vezbe.MySQL_Access;

public class MainMySQL {
	
	
	public static final String INSERT_NASTAVNIK_STUB = "INSERT INTO Nastavnik (nastavnik_id, ime, prezime, zvanje) ";
	public static final String INSERT_PREDMET_STUB = "INSERT INTO Predmet (predmet_id, naziv) ";
	public static final String INSERT_PREDAJE_STUB = "INSERT INTO Predaje (nastavnik_id, predmet_id) VALUES (";

	
	public static void prikaziNastavnike(Statement stmt) {
		
		ResultSet  rSet = null;
		
		try {
			rSet = stmt.executeQuery(""
					+ "SELECT *"
					+ "FROM Nastavnik");
			
			System.out.printf("%5s %20s %20s \n", "ID", "Ime", "Prezime");
			while (rSet.next()) System.out.printf("%5d %20s %20s \n", rSet.getInt(1), rSet.getString(2), rSet.getString(3));
			System.out.println();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	public static void main(String[] args) {

		String host 	= MySQL_Access.HOST;
		String database = MySQL_Access.DATABASE;
		String user 	= MySQL_Access.USER;
		String passwd 	= MySQL_Access.PASS;

		Connection conn = null;
		Statement  stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" 
					+ database + "?" + "user=" + user + "&password=" + passwd);
			
			int result = -1;
			
			// ubaci novog nastavnika
			Nastavnik n = Nastavnik.unesi();
			
			stmt = conn.createStatement();
			result = stmt.executeUpdate(INSERT_NASTAVNIK_STUB + n.getInsert());
			
			Predmet p = Predmet.unesi();

			// dodavanje predmeta koji predaje taj nastavnik
			try {
				conn.setAutoCommit(false);
				
				result = stmt.executeUpdate(INSERT_PREDMET_STUB + p.getInsert());
				result = stmt.executeUpdate(INSERT_PREDAJE_STUB + n.id() + ", " + p.id() + ")");
				
			} catch (SQLException e) {
				conn.rollback();
				System.out.println(e.getMessage());
			}
			
			// prikaz nastavnika
			prikaziNastavnike(stmt);
			
			// brisanje predmeta
			try {
				conn.setAutoCommit(false);

				result = stmt.executeUpdate(n.getDeleteFromPredaje());
				result = stmt.executeUpdate(p.getDelete());
				
			} catch (SQLException e) {
				conn.rollback();
				System.out.println(e.getMessage());
			}
			
			// brisanje nastavnika
			conn.setAutoCommit(true);
			result = stmt.executeUpdate(n.getDelete());

			// prikaz nastavnika
			prikaziNastavnike(stmt);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
