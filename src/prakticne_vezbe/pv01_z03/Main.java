package prakticne_vezbe.pv01_z03;

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
					+ "SELECT predmet_id, naziv "
					+ "FROM predmet p, nastavnik n, predaje pr "
					+ "WHERE pr.Nastavnik_nastavnik_id = n.nastavnik_id AND pr.Predmet_predmet_id = p.predmet_id "
					+ "AND n.ime = 'Petar' AND n.prezime = 'Peric'");
			
			System.out.println("Predmeti koje predaje Petar Peric: ");
			while(rSet.next()) {
				System.out.println(rSet.getInt(1) + " " + rSet.getString(2));
			}
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
