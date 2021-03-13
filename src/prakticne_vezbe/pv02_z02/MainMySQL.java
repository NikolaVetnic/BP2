package prakticne_vezbe.pv02_z02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import prakticne_vezbe.MySQL_Access;

public class MainMySQL {

	public static void main(String[] args) {
		
		String host		= MySQL_Access.HOST;
		String database = MySQL_Access.DATABASE;
		String user		= MySQL_Access.USER;
		String passwd	= MySQL_Access.PASS;
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rSet = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" +
					database + "?" + "user=" + user + "&password=" + passwd);
			stmt = conn.createStatement();
			
			int rowsAffected = stmt.executeUpdate(
					"INSERT INTO Nastavnik (nastavnik_id, ime, prezime, zvanje) " + 
					"VALUES (6, 'Marko', 'Savic', 'docent');");
			
			rSet = stmt.executeQuery("SELECT * FROM Nastavnik;");
			
			System.out.printf("%5s %20s %20s \n", "ID", "Ime", "Prezime");
			while (rSet.next()) System.out.printf("%5d %20s %20s \n", rSet.getInt(1), rSet.getString(2), rSet.getString(3));
			System.out.println();
			
				rowsAffected = stmt.executeUpdate(
					"DELETE FROM Nastavnik WHERE nastavnik_id = 6;");
			
//				rowsAffected = stmt.executeUpdate(
//					"INSERT INTO Nastavnik (nastavnik_id, ime, prezime, zvanje) " + 
//					"VALUES (6, 'Milos', 'Savic', 'docent');");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rSet.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
