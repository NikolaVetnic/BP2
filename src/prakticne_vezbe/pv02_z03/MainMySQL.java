package prakticne_vezbe.pv02_z03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import prakticne_vezbe.MySQL_Access;

public class MainMySQL {
	
	
	public static Nastavnik[] n = { 
			new Nastavnik(6, "Marko", "Savic", "docent"),
			new Nastavnik(7, "Milos", "Savic", "docent"),
	};
	

	public static void main(String[] args) {
		
		String host		= MySQL_Access.HOST;
		String database = MySQL_Access.DATABASE;
		String user		= MySQL_Access.USER;
		String passwd	= MySQL_Access.PASS;
		
		Connection conn = null;
		Statement  stmt = null;
//		ResultSet  rSet = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" +
					database + "?user=" + user + "&password=" + passwd);
			
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			
			int rowsAffected = 0;
			
			rowsAffected = stmt.executeUpdate(
					"INSERT INTO Nastavnik (nastavnik_id, ime, prezime, zvanje) " + 
					"VALUES (6, 'Marko', 'Savic', 'docent');");
			
			rowsAffected = stmt.executeUpdate(
					"INSERT INTO Nastavnik (nastavnik_id, ime, prezime, zvanje) " + 
					"VALUES (7, 'Milos', 'Savic', 'docent');");
			
		} catch (SQLException e0) {
			try {
				conn.rollback();
				e0.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
//				rSet.close();
				stmt.close();
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
