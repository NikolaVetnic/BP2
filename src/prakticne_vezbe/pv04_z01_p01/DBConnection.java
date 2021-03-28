package prakticne_vezbe.pv04_z01_p01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import prakticne_vezbe.MySQL_Access;

public class DBConnection {

	
	private static Connection conn;
	
	
	static {
		try {

			String host 	= MySQL_Access.HOST;
			String database = MySQL_Access.DATABASE;
			String user 	= MySQL_Access.USER;
			String passwd 	= MySQL_Access.PASS;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + 
					"?" + "user=" + user + "&password=" + passwd);
		} catch (Exception e) {
			System.err.println("Greska prilikom kreiranja konekcije -> ");
			e.printStackTrace();
		}
	}


	public static Connection conn() { return conn; }
	
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println("Greska prilikom zatvaranja konekcije -> ");
				e.printStackTrace();
			}
		}
	}
}
