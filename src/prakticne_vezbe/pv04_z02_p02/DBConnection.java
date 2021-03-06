package prakticne_vezbe.pv04_z02_p02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import prakticne_vezbe.MySQL_Access;

public class DBConnection {

	
	private static Connection conn;
	
	
	static {
		try {
			String host 	= MySQL_Access.HOST;
			String database = "radnik";
			String user 	= MySQL_Access.USER;
			String passwd	= MySQL_Access.PASS;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + 
					"?" + "user=" + user + "&password=" + passwd);
			
		} catch (Exception e) {
			System.err.println("Greska prilikom kreiranja konekcije -> ");
			e.printStackTrace();
		}
	}
	
	
	public static Connection conn() { return conn; 	}
	
	
	public static void closeConnection() {
		
		if (conn() != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Greska prilikom zatvaranja konekcije -> ");
				e.printStackTrace();
			}
		}
	}
}
