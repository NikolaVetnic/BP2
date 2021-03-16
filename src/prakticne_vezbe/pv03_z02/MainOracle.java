package prakticne_vezbe.pv03_z02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainOracle {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rSet = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@nastava.is.pmf.uns.ac.rs:1521:xe", "baze2", "baze2");
			
			System.out.print("Unesi neki upit: ");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String query = br.readLine();
			
			stmt = conn.createStatement();
			rSet = stmt.executeQuery(query);
			
			ResultSetMetaData rsmd = rSet.getMetaData();
			
			int brKolona = rsmd.getColumnCount();
			
			for (int i = 1; i <= brKolona; i++)
				System.out.println(rsmd.getColumnName(i) + " [" + rsmd.getColumnTypeName(i) + "]");
			
			System.out.println();
			
			while (rSet.next()) {
				for (int i = 1; i <= brKolona; i++) {
					if (rsmd.getColumnTypeName(i).equals("NUMBER"))
						System.out.printf("%5d ", rSet.getInt(i));
					else if (rsmd.getColumnTypeName(i).equals("VARCHAR2"))
						System.out.printf("%20s ", rSet.getString(i));
					else if (rsmd.getColumnTypeName(i).equals("DATE"))
						System.out.printf("%10s", rSet.getDate(i));
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				rSet.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
