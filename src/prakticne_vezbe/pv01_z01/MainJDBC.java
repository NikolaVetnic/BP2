package prakticne_vezbe.pv01_z01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainJDBC {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rSet = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@nastava.is.pmf.uns.ac.rs:1521:xe", "baze2", "baze2");
			stmt = conn.createStatement();
			
			rSet = stmt.executeQuery(""
					+ "SELECT *"
					+ "FROM nastavnik");
						
								System.out.printf("%5s %20s %20s \n", "ID", "Ime", "Prezime");
			while (rSet.next()) System.out.printf("%5d %20s %20s \n", rSet.getInt(1), rSet.getString(2), rSet.getString(3));
			
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
