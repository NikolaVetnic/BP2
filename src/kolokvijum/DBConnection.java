package kolokvijum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	private static Connection conn;
	
	
	static {
		try {
			String host 	= "Nikolas-MacBook-Pro.local";
			String database = "kolokvijum";
			String user 	= "root";
			String passwd	= "r00t";
			
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
