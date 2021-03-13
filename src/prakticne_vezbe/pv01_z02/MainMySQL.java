package prakticne_vezbe.pv01_z02;

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
