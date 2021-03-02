package prakticne_vezbe.pv01_z02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rSet = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@nastava.is.pmf.uns.ac.rs:1521:xe", "baze2", "baze2");
			stmt = conn.createStatement();
			
			rSet = stmt.executeQuery(""
					+ "SELECT p.predmet_id, p.naziv "
					+ "FROM nastavnik n, predmet p, predaje pr "
					+ "WHERE pr.nastavnik_id = n.nastavnik_id AND pr.predmet_id = p.predmet_id "
					+ "AND n.ime = 'Petar' AND n.prezime = 'Peric'");
			
							   System.out.printf("%5s %30s \n", "ID", "NAZIV_PREDMETA");
			while(rSet.next()) System.out.printf("%5d %30s \n", rSet.getInt(1), rSet.getString(2));
			
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
