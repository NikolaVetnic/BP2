package prakticne_vezbe.pv02_z01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import prakticne_vezbe.MySQL_Access;

public class MainMySQL {
	
	
	public static Nastavnik[] nastavnici = {
			new Nastavnik(6, "Tika", "Tikic", "docent"),
			new Nastavnik(7, "Zika", "Pavlovic", "profesor"),
			new Nastavnik(8, "Sloba", "Snajper", "asistent"),
	};
	
	
	public static void prikaziNastavnike(ResultSet rSet, Statement stmt) {
		
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
	

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// reminder: DELETE FROM table_name WHERE condition;
		// reminder: UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;
		
		String host		= MySQL_Access.HOST;
		String database = MySQL_Access.DATABASE;
		String user		= MySQL_Access.USER;
		String passwd	= MySQL_Access.PASS;
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rSet = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://" + host + "/"
					+ database + "?" + "user=" + user + "&password=" + passwd);
			stmt = conn.createStatement();
			
			prikaziNastavnike(rSet, stmt);
			
//			{
//				int rowsAffected = stmt.executeUpdate(
//						"INSERT INTO Nastavnik (nastavnik_id, ime, prezime, zvanje) " + 
//						"VALUES (6, 'Marko', 'Savic', 'docent')");
//				
//				prikaziNastavnike(rSet, stmt);
//			}
//			
//			{
//				int rowsAffected = stmt.executeUpdate(
//						"UPDATE Nastavnik " + 
//						"SET ime = 'Milos' " + 
//						"WHERE ime = 'Marko';");
//				
//				prikaziNastavnike(rSet, stmt);
//			}
//			
//			{
//				int rowsAffected = stmt.executeUpdate(
//						"DELETE FROM Nastavnik " +
//						"WHERE ime IN ('Marko', 'Milos');");
//				
//				prikaziNastavnike(rSet, stmt);
//			}
			
			PreparedStatement pstmt0 = conn.prepareStatement(
						"INSERT INTO Nastavnik " + 
						"(nastavnik_id, ime, prezime, zvanje) " + 
						"VALUES (?, ?, ?, ?)");
			
			for (Nastavnik n : nastavnici) {
				pstmt0.setInt(1, n.id);
				pstmt0.setString(2, n.ime);
				pstmt0.setString(3, n.prezime);
				pstmt0.setString(4, n.zvanje);
				
				pstmt0.executeUpdate();
			}
			
			pstmt0.close();

			prikaziNastavnike(rSet, stmt);
			
			int rowsAffected = stmt.executeUpdate(
					"DELETE FROM Nastavnik " +
					"WHERE nastavnik_id > 5;");
			
			prikaziNastavnike(rSet, stmt);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
