package prakticne_vezbe.pv01_z01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import prakticne_vezbe.MySQL_Access;

public class MainMySQL {

	public static void main(String[] args) {
		
		String host 	= MySQL_Access.HOST;
		String database = MySQL_Access.DATABASE;
		String user 	= MySQL_Access.USER;
		String passwd 	= MySQL_Access.PASS;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rSet = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" 
					+ database + "?" + "user=" + user + "&password=" + passwd);
			stmt = conn.createStatement();
			
			rSet = stmt.executeQuery(""
					+ "SELECT *"
					+ "FROM Nastavnik");
						
								System.out.printf("%20s %20s \n", "Ime", "Prezime");
			while (rSet.next()) System.out.printf("%20s %20s \n", rSet.getString(2), rSet.getString(3));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
